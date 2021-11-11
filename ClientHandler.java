package MiniProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientHandler extends Thread
{
    private Socket socket;
    private Connection connection;
    public ClientHandler(Socket socket, Connection connection)
    {
        this.socket = socket;
        this.connection = connection;
    }

    @Override
    public void run()
    {
        try
        {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            while (true)
            {
                PackageData pd = (PackageData) inputStream.readObject();
                System.out.println(pd + " CH");
                if(pd.operationType.equals("Add"))
                {
                    addStudentToDB(pd.student);
                    System.out.println("Student added to DB");
                }
                else if(pd.operationType.equals("List"))
                {
                    System.out.println("got list command");
                    pd.setStudents(getDBStudents());
                    System.out.println(pd);
                    outputStream.writeObject(pd);
                }
            }
        }
        catch (Exception s)
        {
            s.printStackTrace();
        }
    }
    public void addStudentToDB(Students st)
    {
        PackageData pd = new PackageData();
        pd.setOperationType("Add");
        pd.setStudent(st);
        System.out.println(st);
        try
        {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students (name,surname,age) VALUES(?,?,?)");
            ps.setString(1,st.getName());
            ps.setString(2,st.getSurname());
            ps.setInt(3,st.getAge());
            ps.executeUpdate();
            ps.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public ArrayList<Students> getDBStudents()
    {
        ArrayList<Students> students = new ArrayList<>();
        try
        {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `students`");
            ResultSet result = ps.executeQuery();
            while (result.next())
            {
                Long id = result.getLong("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int age = result.getInt("age");
                Students st = new Students(id,name,surname,age);
                students.add(st);
            }
            ps.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return students;
    }
}

