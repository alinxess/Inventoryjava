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
public class Category {
   private int cat_id;
   private String cat_name;
   
   DbConnect db = new DbConnect();
   Connection con = null;
   Statement st = null;
   ResultSet rs = null;
   
   Category(){
       
   }
   
   Category(int cat_id, String cat_name){
       this.cat_id= cat_id;
       this.cat_name=cat_name;
       
       addCat(cat_id, cat_name);
   }
   
   public void addCat(int cat_id, String cat_name){
      try{
          con = db.connect();
          PreparedStatement add = con.prepareStatement("insert into Category values(?,?)");
          add.setInt(1, cat_id);
          add.setString(2, cat_name);
          int row = add.executeUpdate();
          System.out.println("category successfully added");
          con.close();
          
      }catch(SQLException e){
          e.printStackTrace();
      }
    }
   
   public ResultSet loadCategories(){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from Category");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
   
   public ResultSet getCategories(){
        try{
         con = db.connect();
         st = con.createStatement();
         rs= st.executeQuery("select * from Category");
         return rs;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void delCategory(int cat_id){
      try{
         con = db.connect();
         String q = "delete from Category where cat_id="+cat_id;
         st = con.createStatement();
         st.executeUpdate(q);
      }catch(SQLException e){
         e.printStackTrace();
      }
    }
    
     public void updateCategory(int cat_id,String cat_name){
      try{
         con = db.connect();
         String q = "update Category set cat_name='"+cat_name+"'"+"where cat_id="+cat_id;
         st = con.createStatement();
         st.executeUpdate(q); 
      }catch(SQLException e){
         e.printStackTrace();
      }
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }
   
   
}
