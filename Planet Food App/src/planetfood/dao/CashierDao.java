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
import java.util.ArrayList;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.User;

/**
 *
 * @author Shahnaz
 */
public class CashierDao {
    
      public static boolean AddCashier(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="insert into users values(?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,user.getUserid());
        ps.setString(2,user. getUsername());
        ps.setString(3,user.getEmpid());
        ps.setString(4,user.getPassword());
        ps.setString(5,user.getUserType());
        
        int x=ps.executeUpdate();
        if(x>0)
            return true;
        else
            return false;
        
    }
  
      //removeCashier
       public static ArrayList<User>getAllUserId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from users");
        ResultSet rs=ps.executeQuery();
        ArrayList<User>userList=new ArrayList<>();
        while(rs.next())
        {
            User user=new User();
            user.setUserid(rs.getString(1));
            user.setUsername(rs. getString(2));
            user.setEmpid(rs.getString(3));
            user.setPassword(rs.getString(4));
            user.getUserType();
            userList.add(user);
        }
        return userList;
        
    }

//DeleteCashier
    public static boolean deleteCashier(String userId)throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Delete from users where userid=?");
     ps.setString(1, userId);
     if(ps.executeUpdate()>0)
         return true;
     else
         return false;
    }
    
}
