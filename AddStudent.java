package MiniProject;

import javax.swing.*;
import java.awt.*;

public class AddStudent extends Container
{
    public static JButton btnBack, btnAdd;
    private JLabel label,labelName,labelSurname,labelAge;
    public static JTextField textName, textSurname,textAge;

    public AddStudent()
    {
        setLayout(null);
        setSize(500,500);
        label = new JLabel("Add Student");
        label.setLocation(70,100);
        label.setSize(100,30);
        add(label);

        btnAdd = new JButton("Add");
        btnAdd.setLocation(100,300);
        btnAdd.setSize(300,30);
        add(btnAdd);

        btnBack = new JButton("Add");
        btnBack.setLocation(100,350);
        btnBack.setSize(300,30);
        add(btnBack);

        labelName = new JLabel("Name");
        labelName.setBounds(70,130,70,30);
        add(labelName);
        textName = new JTextField();
        textName.setBounds(150,130,250,30);
        add(textName);

        labelSurname = new JLabel("Surname");
        labelSurname.setBounds(70,170,70,30);
        add(labelSurname);
        textSurname = new JTextField();
        textSurname.setBounds(150,170,250,30);
        add(textSurname);

        labelAge = new JLabel("Age:");
        labelAge.setBounds(70,210,70,30);
        add(labelAge);
        textAge = new JTextField();
        textAge.setBounds(150,210,250,30);
        add(textAge);
    }
}

