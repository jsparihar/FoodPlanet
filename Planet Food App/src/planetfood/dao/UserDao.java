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
import planetfood.dbutil.DBConnection;
import planetfood.pojo.User;

/**
 *
 * @author Shahnaz
 */
public class UserDao {
    
    public static String ValidateUser(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        String qry="select username from users where userid=? and password=? and usertype=?";
        PreparedStatement ps=conn.prepareStatement(qry);
  
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
       
        ResultSet rs=ps.executeQuery();
        
        String username = null;
        if(rs.next())
        {
            username=rs.getString(1);
            System.out.println("print "+username);
        }
        return username;
    }
    
   
}
