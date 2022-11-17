package com.java.studentmanagerfx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public List<Student> loadStudents(){
        List<Student> studentAll= new ArrayList<Student>();
        Connection myConn= this.Connector();
        try {
            Statement myStmt= myConn.createStatement();
            String sql = "select * from studenttable";
            ResultSet myRs= myStmt.executeQuery(sql);
            while (myRs.next()) {
                Student s= new Student(myRs.getInt("id_student"),myRs.getString("name"), myRs.getString("gender"), myRs.getString("email"), myRs.getDate("birthdate").toLocalDate(), myRs.getString("photo"),myRs.getDouble("mark"), myRs.getString("comments"));
                studentAll.add(s);
            }
            this.close(myConn, myStmt, myRs);
            return studentAll;
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
    public Connection Connector(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=Europe%2FParis", "root","La_Tour_2018");
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try{
            if(myStmt!=null)
                myStmt.close();
            if(myRs!=null)
                myRs.close();
            if(myConn!=null)
                myConn.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(Student student){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try {
            myConn = this.Connector();
            String sql = "INSERT INTO `student`.`studenttable` (`name`,`gender`,`email`,`birthdate`,`photo`,`mark`,`comments`) VALUES (?,?,?,?,?,?,?)";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, student.getName());
            myStmt.setString(2, student.getGender());
            myStmt.setString(3, student.getEmail());
            myStmt.setString(4, String.valueOf(student.getBirthDate()));
            myStmt.setString(5, student.getPhoto());
            myStmt.setString(6, String.valueOf(student.getMark()));
            myStmt.setString(7, student.getComments());
            myStmt.execute();
            //System.out.println("test1");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }

    public void delStudent(Student student){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        try {
            //System.out.println(student.getId());
            myConn = this.Connector();
            String sql = "DELETE FROM `studenttable` WHERE `id_student` =" + String.valueOf(student.getId());
            myStmt = myConn.prepareStatement(sql);
            myStmt.execute();
            //System.out.println("test1");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
    }

    public int countStudents(){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        int count = 0;
        try {
            myConn = this.Connector();
            String sql = "SELECT COUNT(*) FROM  `student`.`studenttable`";
            myStmt = myConn.prepareStatement(sql);
            myRs = myStmt.executeQuery();
            myRs.next();
            count = myRs.getInt(1);
            //System.out.println(count);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
        return count;
    }

    public double avgMarkStudents(){
        Connection myConn=null;
        PreparedStatement myStmt = null;
        ResultSet myRs= null;
        double avg = 0;
        try {
            myConn = this.Connector();
            String sql = "SELECT AVG(`mark`) FROM  `student`.`studenttable`";
            myStmt = myConn.prepareStatement(sql);
            myRs = myStmt.executeQuery();
            myRs.next();
            avg = myRs.getDouble(1);
            //System.out.println(avg);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            close(myConn,myStmt,myRs);
        }
        return avg;
    }

}
