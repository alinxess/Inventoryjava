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
public class Product {
   private int prod_id;
   private String prod_name;
   private int prod_qty;
   private String prod_desc;
   private String prod_category;
   
    DbConnect db = new DbConnect();
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    Product(){
        
    }
   
   Product(int prod_id, String prod_name, int prod_qty, String prod_desc, String prod_category){
       this.prod_id = prod_id;
       this.prod_name=prod_name;
       this.prod_qty= prod_qty;
       this.prod_desc=prod_desc;
       this.prod_category=prod_category;
       
       
       addProd(prod_id, prod_name, prod_qty, prod_desc, prod_category);
             
   }
   
    public void addProd(int prod_id, String prod_name, int prod_qty, String prod_desc, String prod_category){
      try{
          con = db.connect();
          PreparedStatement add = con.prepareStatement("insert into Product values(?,?,?,?,?)");
          add.setInt(1, prod_id);
          add.setString(2, prod_name);
          add.setInt(3, prod_qty);
          add.setString(4, prod_desc);
          add.setString(5, prod_category);
          int row = add.executeUpdate();
          System.out.println("product successfully added");
          con.close();
          
      }catch(SQLException e){
          e.printStackTrace();
      }
    }
    
    public ResultSet loadProducts(){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from Product");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void delProduct(int prod_id){
      try{
         con = db.connect();
         String q = "delete from Product where prod_id="+prod_id;
         st = con.createStatement();
         st.executeUpdate(q);
      }catch(SQLException e){
         e.printStackTrace();
      }
    }
    
     public void updateProduct(int prod_id,String prod_name,int prod_qty,String prod_desc,String prod_category){
      try{
         con = db.connect();
         String q = "update Product set prod_name='"+prod_name+"'"+",prod_qty="+prod_qty+""+",prod_desc='"+prod_desc+"'"+",prod_cat='"+prod_category+"'"+" where prod_id="+prod_id;
         st = con.createStatement();
         st.executeUpdate(q); 
      }catch(SQLException e){
         e.printStackTrace();
      }
    }
    

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public int getProd_qty() {
        return prod_qty;
    }

    public void setProd_qty(int prod_id,int prod_qty) {
        try{
         con = db.connect();
         String q = "update Product set prod_qty="+prod_qty+""+" where prod_id="+prod_id;
         st = con.createStatement();
         st.executeUpdate(q); 
      }catch(SQLException e){
         e.printStackTrace();
      }
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getProd_category() {
        return prod_category;
    }

    public void setProd_category(String prod_category) {
        this.prod_category = prod_category;
    }
   
   
   
}
