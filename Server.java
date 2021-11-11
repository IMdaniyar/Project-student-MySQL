package MiniProject;


import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Server
{
    public static Socket socket;
    public static ObjectInputStream inputStream;
    private static Connection connection;

    public static void main(String[] args)
    {
        try
        {
            ServerSocket server = new ServerSocket(1234);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    (
                            "jdbc:mysql://localhost:3306/jdbs_ex?useUnicode=true&serverTimezone=UTC","root", ""
                    );

            while (true)
            {
                Socket socket = server.accept();
                ClientHandler socketThreads = new ClientHandler(socket, connection );
                socketThreads.start();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

