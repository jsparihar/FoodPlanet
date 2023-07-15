/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetfood.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Shahnaz
 */
public class DBConnection {
    
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-7AK9FOK:1521/XE","planet","food");
            JOptionPane.showMessageDialog(null,"Successfully Connected","Success!!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error in connectivity","Error!!",JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception is:"+ex);
        }
    }
    public static Connection getConnection()
            {
                return conn;
            }
    
    
        public static void closeConnection()
      {
          if(conn!=null)
          {
         try
         {
             conn.close();
             JOptionPane.showMessageDialog(null,"Disconnected Successfully ","Success!!",JOptionPane.INFORMATION_MESSAGE );
         }
         catch(SQLException s)
         {
             JOptionPane.showMessageDialog(null,"Problem in closing the file"+s,"Error!!",JOptionPane.ERROR_MESSAGE);
         }
  
      }
    }

}
