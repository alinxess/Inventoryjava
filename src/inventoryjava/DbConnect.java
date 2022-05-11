/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventoryjava;

import java.sql.*;
/**
 *
 * @author Alin Xess
 */
public class DbConnect {
    
    /*public static void main(String[] args){
        connect();
    }*/
    
    public  Connection connect()
    {
     try
        {
       
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
         System.out.println("Database Connected");
         return conn;
         
        }
     catch(ClassNotFoundException | SQLException e)
        {
            System.out.println("error in connection"+ e);
        }
     return null;
    }

}
