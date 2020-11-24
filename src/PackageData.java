import java.util.*;
import java.io.*;

public class PackageData implements Serializable{

    private static ArrayList<Students> studentList;
    private Students student;
    private String operationType;

    public PackageData(){
    }

    public PackageData(ArrayList<Students> studentList, String operationType) {
        this.studentList = studentList;
        this.operationType = operationType; }//list

    public PackageData(Students student, String operationType) {
        this.student = student;
        this.operationType = operationType; }//add

    public void setStudent(Students student){
        this.student = student;
    }

    public Students getStudent(){
        return this.student;
    }

    public void setStudentList(ArrayList<Students> studentList){
        this.studentList = studentList;
    }

    public ArrayList<Students> getStudentList(){ return studentList; }

    public void setOperationType(String operationType){
        this.operationType = operationType;
    }

    public String getOperationType(){
        return this.operationType;
    }

}