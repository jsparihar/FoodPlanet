
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.OrderDetails;
import planetfood.pojo.Orders;
import planetfood.pojo.UserProfile;

/**
 *
 * @author Shahnaz
 */
public class OrdersDao {
    
    public static ArrayList<Orders>getOrdersByDate(Date startDate ,Date endDate) throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       String qry="select * from orders where ord_date between ? and ?";
       PreparedStatement ps=conn.prepareStatement(qry);
       //util.Date ko convert sql m
       long ms1=startDate.getTime();
       long ms2=endDate.getTime();
       //java.util.ko convert Sql me for Databse
       java.sql.Date d1=new java.sql.Date(ms1);
       java.sql.Date d2=new java.sql.Date(ms2);
       
       ps.setDate(1,d1);
       ps.setDate(2, d2);
       
       ArrayList<Orders>orderList=new ArrayList<>();
       ResultSet rs=ps.executeQuery();
       while(rs.next())
       {
           
           Orders obj=new Orders();
           obj.setOrdId(rs.getString("ord_id"));
            java.sql.Date d=rs.getDate("ord_Date");
           //java.date  sql convert to String
             SimpleDateFormat sdf=    new SimpleDateFormat("dd-MMM-yyyy");
             String datestr=sdf.format(d);//date convert to String //Parse() :Str to date convert 
                    obj.setOrdDate(datestr);
                    obj.setOrdAmount(rs.getDouble("ord_amount"));
                    obj.setGst(rs.getDouble("gst"));
                    obj.setGstAmount(rs.getDouble("gst_amount"));
                    obj.setGranTtotal(rs.getDouble("grand_total"));
                    obj.setDiscount(rs.getDouble("discount"));
                    obj.setUserId(rs.getString("userid"));
                    orderList.add(obj);
                    
       }
       return orderList;
    }

    public static ArrayList<Orders>getOrdersByUserId(Date startDate ,Date endDate,UserProfile UserId) throws SQLException
    {
       Connection conn=DBConnection.getConnection();
       String qry="select * from orders where ord_date between ? and ? and userId=?" ;
       PreparedStatement ps=conn.prepareStatement(qry);
       //util.Date ko convert sql m
       long ms1=startDate.getTime();
       long ms2=endDate.getTime();
       String ms3=UserProfile.getUserid();
       
       //java.util.ko convert Sql me for Databse
       java.sql.Date d1=new java.sql.Date(ms1);
       java.sql.Date d2=new java.sql.Date(ms2);
       UserProfile userId=new UserProfile();
       
       ps.setDate(1,d1);
       ps.setDate(2, d2); 
       ps.setString(3, ms3);
       
       ArrayList<Orders>orderList=new ArrayList<>();
       ResultSet rs=ps.executeQuery();
       while(rs.next())
       {
           
           Orders obj=new Orders();
           obj.setOrdId(rs.getString("ord_id"));
            java.sql.Date d=rs.getDate("ord_Date");
           //java.date  sql convert to String
             SimpleDateFormat sdf=    new SimpleDateFormat("dd-MMM-yyyy");
             String datestr=sdf.format(d);//date convert to String //Parse() :Str to date convert 
                    obj.setOrdDate(datestr);
                    obj.setOrdAmount(rs.getDouble("ord_amount"));
                    obj.setGst(rs.getDouble("gst"));
                    obj.setGstAmount(rs.getDouble("gst_amount"));
                    obj.setGranTtotal(rs.getDouble("grand_total"));
                    obj.setDiscount(rs.getDouble("discount"));
                    obj.setUserId(rs.getString("userid"));
                    orderList.add(obj);
                    
       }
       return orderList;
    }
    
  //singleOrder  
   public static HashMap<String,String>getAllOrderId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from order_details");
        HashMap<String,String> order=new HashMap<>();
      
        while(rs.next())
        {
         
           String ordId=rs.getString(1);
           String prodName=rs.getString(2);
           order.put(ordId,prodName);
            System.out.println(order);
        }
        return order;
    }
  
    
}

