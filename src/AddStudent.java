import com.sun.javafx.tools.packager.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudent extends Container {
    private JButton addstudent;
    private JButton btn;
    private JLabel label;
    private JLabel name;
    private JTextField intername;
    private JLabel surname;
    private JTextField intersurname;
    private JComboBox interfaclty;
    private JLabel age;
    private JTextField interage;

    public AddStudent(){
        Students st = new Students();
        setLayout(null);
        setSize(500,500);

        label = new JLabel("ADD STUDENT");
        label.setLocation(100,50);
        label.setSize(100,30);

        name = new JLabel("Name:");
        name.setLocation(100,80);
        name.setSize(100,30);

        intername = new JTextField();
        intername.setLocation(160,80);
        intername.setSize(100,30);
        add(intername);

        surname = new JLabel("Surname:");
        surname.setLocation(100,120);
        surname.setSize(100,30);

        intersurname = new JTextField();
        intersurname.setLocation(160,120);
        intersurname.setSize(100,30);
        add(intersurname);

        age = new JLabel("Age:");
        age.setLocation(100,190);
        age.setSize(100,30);

        interage = new JTextField();
        interage.setLocation(160,190);
        interage.setSize(100,30);
        add(interage);

        btn = new JButton("Back");
        btn.setLocation(50,300);
        btn.setSize(150,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainFrame.addStudent.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
        add(btn);
        add(label);
        add(name);
        add(surname);
        add(age);

        addstudent = new JButton("Add student");
        addstudent.setLocation(280,300);
        addstudent.setSize(150,30);
        addstudent.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String name = intername.getText();
                String surname = intersurname.getText();
                int age = Integer.parseInt(interage.getText());
              st.setName(name);
              st.setSurname(surname);
              st.setAge(age);
              Client.addStudent(st);
                 MainFrame.addStudent.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
        add(addstudent);
}
}
