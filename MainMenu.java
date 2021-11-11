package MiniProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends Container {

    public JButton add;
    public static JButton list;
    public JButton button;


    public MainMenu()
    {
        setSize(500,500);
        setLayout(null);

        add = new JButton("Add Student");
        add.setLocation(100,150);
        add.setSize(300,30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.menu.setVisible(false);
                Client.frame.addStudent.setVisible(true);
                Client.frame.repaint();
            }
        });
        add(add)
        ;
        list = new JButton("List Students");
        list.setLocation(100,200);
        list.setSize(300,30);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client.frame.menu.setVisible(false);
                Client.frame.listStudent.setVisible(true);
                Client.frame.repaint();
            }
        });
        add(list);


        button = new JButton("EXIT");
        list.setLocation(100,230);
        list.setSize(300,30);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(button);
    }
}