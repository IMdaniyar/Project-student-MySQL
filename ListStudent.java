package MiniProject;

import javax.swing.*;
import java.awt.*;


public class ListStudent extends JPanel
{
    private JLabel label;
    public static JButton btn;
    public static JTable table;
    private JScrollPane scrollPane;

    public ListStudent()
    {
        label = new JLabel("LIST STUDENTS");
        label.setLocation(100,100);
        label.setSize(100,30);
        add(label);

        btn = new JButton("Back");
        btn.setLocation(100,350);
        btn.setSize(300,30);
        add(btn);

        table = new JTable();
        table.setFont(new Font("Calibri",Font.PLAIN, 12));
        table.setRowHeight(30);
        table.setSize(100,150);

        scrollPane = new JScrollPane(table);
        scrollPane.setLocation(100,150);
        scrollPane.setSize(300,200);
        add(scrollPane);
    }
}
