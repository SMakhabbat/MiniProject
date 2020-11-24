import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    public static Socket socket;
    public static ObjectOutputStream outStream;
    public static ObjectInputStream inputStream;

    public static void main(String[] args) {
        connectToServer();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

    }

    public static void addStudent(Students st){
        PackageData pd = new PackageData();
        pd.setOperationType("ADD");
        pd.setStudent(st);
        try{
            outStream.writeObject(pd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> listStudent(){
        PackageData pd = new PackageData();
        pd.setOperationType("LIST");
//        pd.setStudentList(Server.allStudents());/////////////

        try{
            outStream.writeObject(pd);
            PackageData response = (PackageData) inputStream.readObject();
             //response = (PackageData) inputStream.readObject();
            if (response !=null){
                response.getStudentList();
                //ArrayList<Students> studentList = response.getStudentList();
            }
        }catch(Exception e){
            e.printStackTrace();
        }


       return pd.getStudentList();
    }

public static void connectToServer() {
        try{
            socket = new Socket("127.0.0.1",1979);
            outStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch(Exception e){
            e.printStackTrace();
        }}
}
