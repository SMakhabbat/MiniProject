import com.sun.javafx.tools.packager.Main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListStudent extends Container {
    private JLabel label;
    private JButton btn;
    private JTable table;
    private String header[] = {"Name","Surname","Age"};
   private JScrollPane scrollPane;
    public ListStudent(){
        ArrayList<Students> studentList = new ArrayList<>();

        setLayout(null);
        setSize(500,500);


        label = new JLabel("List STUDENT");
        label.setLocation(100,100);
        label.setSize(100,30);
        add(label);

        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.setSize(300,300);
        table.setLocation(100,200);
        add(table);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);

        btn = new JButton("Back");
        btn.setLocation(100,150);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               MainFrame.listStudent.setVisible(false);
                MainFrame.menu.setVisible(true);

            }
        });
        add(btn);
    }

   public  void getTable (ArrayList<Students> getStudentList){

        Object data[][] = new Object[getStudentList.size()][3];
                  for(int i =0;i<getStudentList.size();i++){
                      data[i][0] = getStudentList.get(i).getName();
                    data[i][1] = getStudentList.get(i).getSurname();
                    data[i][2] = getStudentList.get(i).getAge();

    }
     DefaultTableModel model = new DefaultTableModel(data, header);
     table.setModel(model);
    }

}

