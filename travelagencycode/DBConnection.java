/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagencycode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class DBConnection {
    Connection con = null;
    PreparedStatement pst;
    
    public static Connection dbconnect()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_signupconnection","root"," ");
            System.out.println("Database successfully connected");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println("Code Failed to Run");
            return null;
        }
    }
    public static void main(String[] args) {
        DBConnection.dbconnect();
    }
    
}
