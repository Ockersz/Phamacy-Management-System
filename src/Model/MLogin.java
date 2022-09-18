/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.CLogin;
import Controller.CMessageManagement;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class MLogin {
    
    public boolean submitLoginDetails(String username, String password)
    {
        boolean i = false;
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet result = st.executeQuery("Select * from employee_login_credentials WHERE username='"+username+"' and password = '"+password+"' ");
            if(result.next())
            {
                i = true;
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), "Data Transit Failed \n\r" + e.getClass() + "\n\r" + e.getMessage(), "Login Details Management", JOptionPane.INFORMATION_MESSAGE);
        }
        return (i);  
    }
    public int getEmpNumber(String username)
    {
        int i = 0;
        try{
            
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet result = st.executeQuery("Select eno from employee_login_credentials where username = '"+username+"'");
            if(result.next())
            {
                i = result.getInt(1);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), "Data Transit Failed \n\r" + e.getClass() + "\n\r" + e.getMessage(), "Login Details Management", JOptionPane.INFORMATION_MESSAGE);
        }        
        return i ;
    }
    
    public void sendLoginHistory(String username)
    {
        int p = 0;
         int eno = getEmpNumber(username);
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
         LocalDateTime now = LocalDateTime.now();  
         try{  
         Statement st = MyDbConnection.getConnection().createStatement();
         st.executeUpdate("INSERT INTO employee_login_history (time,eno) values ('"+dtf.format(now)+"','"+eno+"')");
         
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
         
    }
    public String checkUsernameExist(String username)
    {
        String uname= "";
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select username FROM employee_login_credentials WHERE username ='"+username+"'");
        if(rs.next())
        {
            uname = rs.getString(1);
        }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        return uname;
    }
    
    public int registerEmployee(String fname,String lname,String gender,String homeno,String street,String city,String district,String province,String email,Date dob,String tp)
    {   int i = 0;
        String dateofbirth;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dateofbirth = format.format(dob);
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            i = st.executeUpdate("INSERT INTO `employee` (`eid`,`first_name`, `last_name`, `gender`, `home-no`, `street`, `city`, `district`, `province`, `tp`, `email`, `dob`) VALUES (NULL, '"+fname+"', '"+lname+"', '"+gender+"', '"+homeno+"', '"+street+"', '"+city+"', '"+district+"', '"+province+"', '"+tp+"', '"+email+"', '"+dateofbirth+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        return i ;
    }
    
    public int getMaxId()
    {   
        int i = 0;
    
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(eid) FROM `employee`");
            if(rs.next())
            {
                i = rs.getInt(1);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        
        
       return i; 
    }
    
    public void insertIntoEmpCred(String username,String password)
    {
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            st.executeUpdate("INSERT INTO `employee_login_credentials` (`username`, `password`, `eno`) VALUES ('"+username+"', '"+password+"', '"+getMaxId()+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
    }
}
