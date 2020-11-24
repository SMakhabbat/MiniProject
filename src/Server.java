import java.sql.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static Connection conn;
   // ArrayList<Students> studentList = new ArrayList<>();
    public static void main(String[] args) {
        connect();

        try {
            ServerSocket server = new ServerSocket(1979);
            System.out.println("Wainting for client...");
            Socket socket = server.accept();
            System.out.println("Client connected");
            ObjectInputStream inStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            PackageData pd = new PackageData();

            while ((pd = (PackageData) inStream.readObject()) != null) {
                if (pd.getOperationType().equals("ADD")) {
                    addStudentToDb(pd.getStudent());
                } else if (pd.getOperationType().equals("LIST")) {
                    PackageData response  = new PackageData();
//      ArrayList<Students> studentList = Server.allStudents();
//                    response.setStudentList(studentList);
                    response.setStudentList(Server.getAllStudents());
                    outputStream.writeObject(response);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void connect(){
        try{
            //Подтягиваем драйвер, который мы добавили в самом начале урока
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Создаем подключение.
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void disconnect() {
        try {
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addStudentToDb(Students student) {
        try {
            PreparedStatement st = conn.prepareStatement("insert into students(id,name,surname,age) values(null,?,?,?)");
            st.setString(1, student.getName());
            st.setString(2, student.getSurname());
            st.setInt(3, student.getAge());
            st.execute();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getAllStudents (){
        ArrayList<Students> studentList = new ArrayList<>();
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM students");
            ResultSet result = st.executeQuery();

            while(result.next()){
                Long id = result.getLong("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int age = result.getInt("age");
                studentList.add(new Students(id, name, surname, age));
            }
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }
    }