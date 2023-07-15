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
import java.util.TreeSet;
import planetfood.dbutil.DBConnection;
import planetfood.pojo.Employee;

/**
 *
 * @author Shahnaz
 */
public class EmployeeDAO {
    
    //AddEmp
    public static boolean addEmployee(Employee e)throws SQLException
   {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setInt(1,e.getEmpid());
        ps.setString(2,e.getEname());
        ps.setString(3,e.getJob());
        ps.setDouble(4,e.getSal());
        
        int ans;
        ans=ps.executeUpdate();
        if(ans>0)
        {
          return true;
        }
          else
        {
          return false;
        }
        
    }

//EditEmp//singleEmp
    public static Employee findEmployeeById(int eno)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from Employees where EmpId=?");
        ps.setInt(1,eno);
        Employee e=null;
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            e=new Employee();
            e.setEmpid(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSal(rs.getDouble(4));
        }
        return e;
        
     }
    
 //removeEmp   
    public static ArrayList<Employee>getAllEmployee()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from employees");
        ResultSet rs=ps.executeQuery();
        ArrayList<Employee>empList=new ArrayList<>();
        while(rs.next())
        {
            Employee e=new Employee();
            e.setEmpid(rs.getInt(1));
            e.setEname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSal(rs.getDouble(4));
            empList.add(e);
        }
        return empList;
        
    }

//removeEmp
    public static boolean deleteEmployee(int eno)throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Delete from employees where empid=?");
     ps.setInt(1, eno);
     if(ps.executeUpdate()>0)
         return true;
     else
         return false;
    }
    
  //EditEmp
    public static boolean updateEmp(Employee e , int eno)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update employees set ENAME=?,SAL=?,JOB=? where EMPID=?");
       
       ps.setString(1,e.getEname());
       ps.setDouble(2,e.getSal());
       ps.setString(3,e.getJob());
       ps.setInt(4,e.getEmpid());
           
            if(ps.executeUpdate()>0)
                return true;
            else 
                return false;
  }
   
//SingleEmp    //RegisterCashier
   public static HashMap<String,String>getAllEmployeeId()throws SQLException
    {
        
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from employees");
        HashMap<String,String> empList=new HashMap<>();
      
        while(rs.next())
        {
         
            
           String empId=rs.getString(1);
           String Ename=rs.getString(2);
           empList.put(empId,Ename);
        }
        return empList;
    }
   
 //editEmp
  public static HashMap<String,String>getAllJobName()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from employees");
        HashMap<String,String> empList=new HashMap<>();
      
        while(rs.next())
        {
         
            /*Employee e=new Employee();
            e.setEmpid(rs.getInt("empid"));
            e.setEname(rs.getString("ename"));
            e.setJob(rs.getString("job"));
            e.setSal(rs.getDouble("sal"));
            */
            String job=rs.getString(3);
            String Ename=rs.getString(2);
            empList.put(job,Ename);
        }
        return empList;
    }

  
}
