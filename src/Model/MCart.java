/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.CMessageManagement;
import com.mysql.cj.protocol.Resultset;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class MCart {
    
    public static void insertIntoCart(int id,int qty,int price,String name)
    {
        try{
        int tot = qty*price;    
        Statement st = MyDbConnection.getConnection().createStatement();
        st.executeUpdate("INSERT INTO `cart`(`pno`, `name`, `unit_quantity`, `tot_price`) VALUES ('"+id+"','"+name+"','"+qty+"','"+tot+"')");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
    }
    
    public static void  emptyCart()
    {
        try{    
        Statement st = MyDbConnection.getConnection().createStatement();
        st.executeUpdate("truncate table cart");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        
    }
    
    public static Resultset loadCart()
    {
        Resultset rs = null;
        try{   
        Statement st = MyDbConnection.getConnection().createStatement();
        rs = (Resultset) st.executeQuery("SELECT * FROM `cart`");  
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        return rs;
    }
    
    public static void deleteItem(int id)
    {
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            st.executeUpdate("DELETE FROM `cart` WHERE `pno`='"+id+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
    }
    
    
}
