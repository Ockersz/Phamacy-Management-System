/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MOrder;
import java.sql.ResultSet;

/**
 *
 * @author Ockersz
 */
public class COrder {
    
    public static void makeOrder(int price,int eno)
    {
        MOrder.makeOrder(price, eno);
        MOrder.setOrderProducts();
    }
    
    public static int getOid()
    {
        int i = MOrder.getOid();
        return i;
    }
    public static ResultSet getOrders()
    {
       ResultSet rs = MOrder.getOrders();
       return rs;
    }
    
    public static ResultSet getOrderById(int oid)
    {
        ResultSet rs = MOrder.getOrderById(oid);
        return rs;
    }
}
