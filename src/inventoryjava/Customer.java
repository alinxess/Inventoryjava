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
public class Customer {
   private int cust_id;
   private String cust_name;
   private String cust_phone;
   
   DbConnect db = new DbConnect();
   Connection con = null;
   Statement st = null;
   ResultSet rs = null;
   
   Customer(){
       
   }
   
   Customer(int cust_id,String cust_name, String cust_phone){
       this.cust_id=cust_id;
       this.cust_name=cust_name;
       this.cust_phone=cust_phone;
       
       addCust(cust_id,cust_name,cust_phone);
   }
   
   public void addCust(int cust_id, String cust_name,String cust_phone){
      try{
          con = db.connect();
          PreparedStatement add = con.prepareStatement("insert into Customer values(?,?,?)");
          add.setInt(1, cust_id);
          add.setString(2, cust_name);
          add.setString(3, cust_phone);
          int row = add.executeUpdate();
          System.out.println("customer successfully added");
          con.close();
          
      }catch(SQLException e){
          e.printStackTrace();
      }
    }
   
   public ResultSet loadCustomer(){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from Customer");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void delCustomer(int cust_id){
      try{
         con = db.connect();
         String q = "delete from Customer where cust_id="+cust_id;
         st = con.createStatement();
         st.executeUpdate(q);
      }catch(SQLException e){
         e.printStackTrace();
      }
    }
    
     public void updateCustomer(int cust_id,String cust_name,String cust_phone){
      try{
         con = db.connect();
         String q = "update Customer set cust_name='"+cust_name+"'"+",cust_phone='"+cust_phone+"'"+" where cust_id="+cust_id;
         st = con.createStatement();
         st.executeUpdate(q); 
      }catch(SQLException e){
         e.printStackTrace();
      }
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }
   
   
}
