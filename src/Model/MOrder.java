/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.CMessageManagement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class MOrder {
    
    public static void makeOrder(int price,int eno)
    {
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            st.executeUpdate("INSERT INTO `orders`(`price`, `eno`) VALUES ('"+price+"','"+eno+"')");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
    }
    
    public static void setOrderProducts()
    {
        int oid = 0;
         try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet rs1 = st.executeQuery("Select MAX(oid) from orders");
            while(rs1.next())
            {
                oid = rs1.getInt(1);
            }
            rs1.close();
             Statement st2 = MyDbConnection.getConnection().createStatement();
            ResultSet rs2 = st2.executeQuery("Select `pno`,`unit_quantity` from cart");
            while(rs2.next())
            {
                st.executeUpdate("INSERT INTO `orders_has_products`(`ono`, `pno`, `unit_quantity`) VALUES ('"+oid+"','"+rs2.getInt(1)+"','"+rs2.getInt(2)+"') ");
                int exist_qty = getProductQuantity(rs2.getInt(1));
                updateProductQuantity(rs2.getInt(1),exist_qty-rs2.getInt(2));
            }
            rs2.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
    }
    public static int getProductQuantity(int pid)
    {
        int existing_qty = 0;
        try
        {
        Statement st = MyDbConnection.getConnection().createStatement();
        ResultSet rs = st.executeQuery("Select `avail_quantity` from product where `pid` = '"+pid+"' ");
        
        while(rs.next())
        {
            existing_qty = rs.getInt(1);
        }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        return existing_qty;
    }
    public static void updateProductQuantity(int pid,int qty)
    {
        try
        {
        Statement st = MyDbConnection.getConnection().createStatement();
        st.executeUpdate("UPDATE `product` SET `avail_quantity`='"+qty+"' WHERE `pid` = '"+pid+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
    }
    public static int getOid()
    {
        int oid =0;
        try{
        Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select MAX(oid) from orders");
            while(rs.next())
            {
                oid = rs.getInt(1);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        return oid;
    }
    public static ResultSet getOrders()
    {ResultSet rs =null;
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            rs = st.executeQuery("Select * from orders");
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        return rs; 
    }
     public static ResultSet getOrderById(int oid)
    {ResultSet rs =null;
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            rs = st.executeQuery("Select * from orders where oid = '"+oid+"'");
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        return rs; 
    }
    
}
