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
import planetfood.pojo.Category;
import planetfood.pojo.Product;

/**
 *
 * @author Shahnaz
 */
public class CategoryDao {
    //AddCategory
    public static String getNewId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select count(*) from categories");
       int id=101;
        if(rs.next())
        {
            id=id+rs.getInt(1);
            
        }
        return "C"+id;
        
    }
    
    //EditProduct
    public static HashMap<String,String>getAllCategoryId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from Categories");
        HashMap<String,String> categories=new HashMap<>();
      
        while(rs.next())
        {
         
           String catId=rs.getString(2);
           String catName=rs.getString(1);
           categories.put(catId,catName);
        }
        return categories;
    }
    
    
//ViewAllCat    
     public static ArrayList<Category> getAllCategoryData()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="Select * from categories";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(qry);
        ArrayList<Category>categoryList=new ArrayList<>();
        while(rs.next())
        {
            Category cat=new Category();
            cat.setCatId(rs.getString("cat_id"));
            cat.setCatName(rs.getString("cat_name"));
            categoryList.add(cat);
            
        }
        return categoryList;
    }
     
        
    //AddProduct
    public static boolean addCategory(Category c)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="insert into Categories values(?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, c.getCatId());
        ps.setString(2,c.getCatName());
        
        if(ps.executeUpdate()>0)
            return true;
        else
            return false;
        
    }
    //EditCategory
    public static HashMap<String,String>getCategoryId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from Categories");
        HashMap<String,String> categories=new HashMap<>();
      
        while(rs.next())
        {
         
           String catId=rs.getString(1);
           String catName=rs.getString(2);
           categories.put(catId,catName);
        }
        return categories;
    }
    //EditCategory
    public static boolean updatCategory(Category c) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="update categories set cat_name=? where cat_id=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,c.getCatName());
        ps.setString(2,c.getCatId());
         int x;
        x=ps.executeUpdate();
        if(x>0)
            return true;
        else
            return false;
        
        
    }

  
}

