/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.Product;

/**
 *
 * @author Shahnaz
 */
public class ProductDao {
    
//AddproductFrame
    public static String getNewId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select count(*) from products");
       int id=101;
        if(rs.next())
        {
            id=id+rs.getInt(1);
            
        }
        return "p"+id;
        
    }
 
//AddProduct    
    public static boolean addProduct(Product p)throws SQLException
    {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("Insert into products values(?,?,?,?,?)");
         
         ps.setString(1,p.getProdId());
         ps.setString(2, p.getCatId());
         ps.setString(3, p.getProdName());
         ps.setDouble(4, p.getProdPrice());
         ps.setString(5, p.getIsActive());
       
         ResultSet rs=ps.executeQuery();
        return rs.next();
       
    }

 //ViewProduct
    public static ArrayList<Product> getAllData()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="Select * from products";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<Product>productList=new ArrayList<>();
        while(rs.next())
        {
            Product p=new Product();
            p.setCatId(rs.getString("cat_id"));
            p.setProdId(rs.getString("prod_id"));
            p.setProdName(rs.getString("prod_name"));
            p.setProdPrice(rs.getDouble("prod_price"));
            p.setIsActive(rs.getString("active"));
            productList.add(p);
          //  System.out.println(productList);
            
        }
        return productList;
    
    }
    
//removeProduct
    public static boolean removeProduct(String prodId)throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("update products set active='N' where prod_id=?");
     ps.setString(1, prodId);
     //int x=ps.executeUpdate;if(x>0)
     if(ps.executeUpdate()>0)
         return true;
     else
         return false;
    }
    
 //removeProduct
     public static HashMap<String, String>getActiveProductByCategory(String catId)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(" select prod_name,prod_id from products where cat_id=? and active='y'");
        HashMap<String,String>productList=new HashMap<>();
        
        ps.setString(1,catId);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
           String prodName=rs.getString("prod_name");
           String prodId=rs.getString("prod_id");
           productList.put(prodName, prodId);
           System.out.println(productList);
        }
        return productList;
            
    }
     
   
 //EditProduct
     public static boolean updateProduct(Product p)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update products set prod_name=?,prod_price=?,active=? where prod_id=?");
        ps.setString(1,p.getProdName());
        ps.setDouble(2,p.getProdPrice());
        ps.setString(3,p.getIsActive());
        ps.setString(4,p.getProdId());
        int x;
        x=ps.executeUpdate();
        if(x>0)
            return true;
        else
            return false;
}
 
 //EditProduct
    public static HashMap<String,Product>getProductByCategory(String catId)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select * from Products where cat_id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        HashMap<String,Product>productList=new HashMap<>();
        ps.setString(1, catId);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            Product p=new Product();
            p.setCatId(catId);
            p.setProdId(rs.getString("prod_id"));
            p.setProdName(rs.getString("prod_name"));
            p.setProdPrice(rs.getDouble("prod_price"));
            p.setIsActive(rs.getString("active"));
            productList.put(p.getProdId(), p);
           
            System.out.println("productList"+productList);
        }
        return productList;
    }
    
   
 //ViewMenu   
    public static ArrayList<Product> getAllProductsByCat( String catId)throws SQLException
    {
        Connection conn=   DBConnection.getConnection();
    // Statement st=conn.createStatement();
     PreparedStatement ps=conn.prepareStatement("select * from products where CAT_ID=?");
     ps.setString(1, catId);
     ResultSet rs=ps.executeQuery();
     ArrayList<Product>productList=new ArrayList<>();
     while(rs.next()){  
     
         
            Product p=new Product();
            p.setCatId(catId);
            p.setProdId(rs.getString("prod_id"));
            p.setProdName(rs.getString("prod_name"));
            p.setProdPrice(rs.getDouble("prod_price"));
            p.setIsActive(rs.getString("active"));
         
         
    /* String pID=rs.getString(1);
     String catid=rs.getString(2);
     String pname=rs.getString(3);
     Double price=rs.getDouble(4);
     String active=rs.getString(5);
     Product p=new Product();
     p.setProdId(pID);
     p.setProdName(pname);
     p.setProdPrice(price);
     p.setIsActive(active);
     p.setCatId(catid);*/
    
    productList.add(p);
    
   
    
   } return productList;
    
    }


}