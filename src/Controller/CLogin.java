/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.MLogin;
import java.util.Date;

/**
 *
 * @author Ockersz
 */
public class CLogin {
    
    public static boolean submitLoginDetails(String username,String password)
    {
        MLogin login = new MLogin();
        boolean i = login.submitLoginDetails(username, password);
        return i ;
    }
    
    public static void sendLoginHistory(String username)
    {
        MLogin login = new MLogin();
        login.sendLoginHistory(username);
    }
    
    public static String checkUsernameExist(String username)
    {
        MLogin login = new MLogin();
        String uname = login.checkUsernameExist(username);
        return uname;
    }
    
    public static int registerEmployee(String fname,String lname,String gender,String homeno,String street,String city,String district,String province,String email,Date dob,String tp,String username,String password)
    {
       
        MLogin login = new MLogin();
        int i = login.registerEmployee(fname, lname, gender, homeno, street, city, district, province, email, dob, tp);
        login.insertIntoEmpCred(username, password);
        return i;
    }
    
    public static int getEmpNumber(String username)
    {
        MLogin login = new MLogin();
        int i = login.getEmpNumber(username);
        return i;
    }

    
}
