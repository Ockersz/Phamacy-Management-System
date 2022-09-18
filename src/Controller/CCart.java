/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MCart;
import com.mysql.cj.protocol.Resultset;

/**
 *
 * @author Ockersz
 */
public class CCart {
    
    public static void insertIntoCart(int id,int qty,int price,String name)
    {
        MCart.insertIntoCart(id, qty, price,name);
    }
    
    public static Resultset loadCart()
    {
        Resultset rs =null;
        rs = MCart.loadCart();
        return rs;
    }
    public static void deleteItem(int id)
    {
        MCart.deleteItem(id);
    }
    
    public static void  emptyCart()
    {
        MCart.emptyCart();
    }
    
}
