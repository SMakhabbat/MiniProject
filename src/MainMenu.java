import com.sun.javafx.tools.packager.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends Container {
    public JButton add;
    public JButton list;
    public JButton exit;

    public MainMenu(){
        setSize(500,500);
        setLayout(null);

        add = new JButton("Add");
        add.setLocation(100,150);
        add.setSize(300,30);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainFrame.menu.setVisible(false);
                MainFrame.addStudent.setVisible(true);
            }
        });
        add(add);

        list = new JButton("List");
        list.setLocation(100,190);
        list.setSize(300,30);
        list.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainFrame.menu.setVisible(false);
                MainFrame.listStudent.setVisible(true);
                MainFrame.getListStudent();
            }
        });
        add(list);

        exit = new JButton("Exit");
        exit.setSize(300,30);
        exit.setLocation(100,230);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        add(exit);
    }
}
