/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Mproducts;
import java.util.Date;
import java.sql.ResultSet;

/**
 *
 * @author Ockersz
 */
public class CProduct {
    
    public static ResultSet getProducts()
    {
        ResultSet rs = null;
         rs = Mproducts.getProducts();
        
        return rs;
    }
    
    public static int addProduct(String name,String brand,int quantity,Date manu_date,Date expire_date,int unit_price,String image)
    {
        int i = 0;
        i = Mproducts.addProduct(name, brand, quantity, manu_date, expire_date, unit_price, image);
        return i;
    }
    
    public static int updateProduct(int id,String name,String brand,int quantity,Date manu_date,Date expire_date,int unit_price,String image)
    {
        int i=0;
        i = Mproducts.updateProduct(id, name, brand, quantity, manu_date, expire_date, unit_price, image);
        return i;
    }
    public static int deleteProduct(int id)
    {
        int i=0;
        i = Mproducts.deleteProduct(id);
        return i;
    }
    
    public static ResultSet loadProductById(int id)
    {
        ResultSet rs;
        rs = Mproducts.loadProductById(id);
        
        return rs;
    }
    public static void insertDataChange(int eno,int pid)
    {
        Mproducts.insertDataChange(eno, pid);
    }
    
    public static int getProductIdBYName(String name)
    {
        int i = Mproducts.getProductIdBYName(name);
        return i;
    }
    
    public static ResultSet getProductByOrderId(int oid)
    {
        ResultSet rs = Mproducts.getProductByOrderId(oid);
        return rs;
    }
    
}
