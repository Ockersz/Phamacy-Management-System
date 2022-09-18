/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Controller.CMessageManagement;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Ockersz
 */

public class MyDbConnection {
   
   private static Connection con;
   
   public static Connection getConnection()
   {
      try{
      String path="jdbc:mysql://localhost/pharmacy";
      con = DriverManager.getConnection(path,"root","");
      
      }
      catch(SQLException e)
      {
         JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(),"Database Error","Error",JOptionPane.ERROR_MESSAGE);
      }
      return con;
   }
   
}