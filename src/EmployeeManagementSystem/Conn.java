package EmployeeManagementSystem;
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql:///emploeemanagementsystem","root","shreyas");
             s=c.createStatement();
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }
}
