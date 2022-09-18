/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.CMessageManagement;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Ockersz
 */
public class Mproducts {
    public static ResultSet getProducts()
    {
        ResultSet rs = null;
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            rs  = st.executeQuery("select * from product");
        }
        catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
                }
        return rs;
    }
    
    public static int addProduct(String name,String brand,int quantity,Date manu_date,Date expire_date,int unit_price,String image)
    {
        int i = 0;
        String mfc_date;
        String exp_date;
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        mfc_date = format.format(manu_date);
        exp_date = format.format(expire_date);
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            i = st.executeUpdate("INSERT INTO `product` (`pid`, `p_name`, `brand`, `avail_quantity`, `manu_date`, `expire_date`, `unit_price`, `image`) VALUES (NULL, '"+name+"', '"+brand+"', '"+quantity+"', '"+mfc_date+"', '"+exp_date+"', '"+unit_price+"','"+image+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        return i ;
    }
    
    public static int updateProduct(int id,String name,String brand,int quantity,Date manu_date,Date expire_date,int unit_price,String image)
    {   int i = 0;
        String mfc_date;
        String exp_date;
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        mfc_date = format.format(manu_date);
        exp_date = format.format(expire_date);
        
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            i= st.executeUpdate("UPDATE `product` SET `p_name`='"+name+"',`brand`='"+brand+"',`avail_quantity`='"+quantity+"',`manu_date`='"+mfc_date+"',`expire_date`='"+exp_date+"',`unit_price`='"+unit_price+"',`image`='"+image+"' WHERE `pid`='"+id+"'");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        return i;
        
    }
    public static int deleteProduct(int id)
    {
        int i=0;
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            i = st.executeUpdate("UPDATE `product` SET `avail_quantity`='"+0+"' WHERE `pid` = '"+id+"'");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage());
        }
        return i;
    }
    
    public static ResultSet loadProductById(int id)
    {   ResultSet rs =null;
    
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            rs = st.executeQuery("SELECT `p_name`, `brand`, `avail_quantity`, `manu_date`, `expire_date`, `unit_price`, `image`,`pid` FROM `product` WHERE pid = '"+id+"'");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        return rs;
    }
    
    public static int getMaxId()
    {
        ResultSet rs;
       int i =0;
    
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            rs = st.executeQuery("SELECT MAX(pid) FROM `product`");
            
            while(rs.next())
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
    
    public static void insertDataChange(int eno,int pid)
    {
        try{
            Statement st = MyDbConnection.getConnection().createStatement();
            st.executeUpdate("INSERT INTO `employee_manage_product`(`eno`, `pno`) VALUES ('"+eno+"','"+pid+"')");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
    }
    public static int getProductIdBYName(String name)
    {   int id= 0;
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT pid FROM `product` where p_name ='"+name+"' ");
            
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
 
        return id;
    }
    public static ResultSet getProductByOrderId(int oid)
    {
        ResultSet rs =null;
    
        try
        {
            Statement st = MyDbConnection.getConnection().createStatement();
            rs = st.executeQuery("SELECT product.p_name, orders_has_products.unit_quantity\n" +
"from product INNER JOIN\n" +
"orders_has_products \n" +
"ON\n" +
"product.pid = orders_has_products.pno\n" +
"INNER JOIN\n" +
"orders\n" +
"ON\n" +
"orders.oid = orders_has_products.ono\n" +
"WHERE orders.oid = '"+oid+"'\n" +
"");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), ex.getMessage());
        }
        return rs;
    }
    
}
