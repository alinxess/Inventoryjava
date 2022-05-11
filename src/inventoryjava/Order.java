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
public class Order {
   private int order_id;
   private String cust_name;
   private String order_date;
   private int amount;
   
    DbConnect db = new DbConnect();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    Order(){
        
    }
    
    Order(int order_id,String cust_name,String order_date,int amount){
        this.order_id=order_id;
        this.cust_name=cust_name;
        this.order_date=order_date;
        this.amount=amount;
        
        addOrder(order_id,cust_name,order_date,amount);
    }
    
    public void addOrder(int order_id,String cust_name,String order_date,int amount){
      try{
          con = db.connect();
          PreparedStatement add = con.prepareStatement("insert into orders values(?,?,?,?)");
          add.setInt(1, order_id);
          add.setString(2, cust_name);
          add.setString(3, order_date);
          add.setInt(4, amount);
          int row = add.executeUpdate();
          System.out.println("order successfully added");
          con.close();
          
      }catch(SQLException e){
          e.printStackTrace();
      }
    }
    
     public ResultSet loadOrders(){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from orders");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
     public ResultSet getCount(String cust_name){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select count(*) from orders where cust_name='"+cust_name+"'");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
     
     public ResultSet getAmount(String cust_name){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select sum(amount) from orders where cust_name='"+cust_name+"'");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
     
}
