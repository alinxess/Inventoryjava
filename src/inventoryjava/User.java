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
public class User {
   private String uname;
   private String upass;
   private String uphone;
   
   DbConnect db = new DbConnect();
   Connection con = null;
   Statement st = null;
   ResultSet rs = null;
   
   User(){
       
   }
   
   User(String uname, String upass, String uphone){
       this.uname=uname;
       this.upass=upass;
       this.uphone=uphone;
       
       addUser(uname,upass,uphone);
   }
   
   public void addUser(String uname, String upass,String uphone){
      try{
          con = db.connect();
          PreparedStatement add = con.prepareStatement("insert into User values(?,?,?)");
          add.setString(1, uname);
          add.setString(2, upass);
          add.setString(3, uphone);
          int row = add.executeUpdate();
          System.out.println("user successfully added");
          con.close();
          
      }catch(SQLException e){
          e.printStackTrace();
      }
    }
   
   public ResultSet loadUser(){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from User");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void delUser(String uphone){
      try{
         con = db.connect();
         String q = "delete from User where uphone="+uphone;
         st = con.createStatement();
         st.executeUpdate(q);
      }catch(SQLException e){
         e.printStackTrace();
      }
    }
    
     public void updateUser(String uname, String upass,String uphone){
      try{
         con = db.connect();
         String q = "update User set uname='"+uname+"'"+",upass='"+upass+"'"+" where uphone='"+uphone+"'";
         st = con.createStatement();
         st.executeUpdate(q); 
      }catch(SQLException e){
         e.printStackTrace();
      }
    }
     
     public ResultSet loginUser(String uname, String upass){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from User where uname='"+uname+"' and upass='"+upass+"'");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    
   
   
}
