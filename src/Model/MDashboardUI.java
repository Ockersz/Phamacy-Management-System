/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.CCart;
import Controller.CMessageManagement;
import View.VCart;
import com.sun.prism.j2d.J2DPipeline;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Ockersz
 */
	

public class MDashboardUI implements MouseListener,ActionListener{
    
    private JFrame frm_qty;
    private JSpinner txt_qty;
    private JButton btn_addcart;
    String loadimage;
    int maxqty,pid=0;
    private JLabel label1,label2,label3,lbl_image,lbl_name,lbl_price,lbl_qty,name,price;
        
    public void createTile(Container container,int x,int y,String name,String price,String imagefile,int id) 
    {
      label1 = new JLabel();
      label1.setBounds(x,y,200,200);
      label1.setName(Integer.toString(id));
      container.add(label1);
      label1.addMouseListener(this);
      
      label2 = new JLabel();
      label2.setBounds(x,y+220,200,30);
      label2.setText(name);
      label2.setForeground(new Color(46,51,73));
      label2.setFont(new Font("Segoe UI", Font.BOLD, 20));
      label2.setHorizontalAlignment(SwingConstants.CENTER);
      container.add(label2);

      label3 = new JLabel();
      label3.setBounds(x,y+250,200,30);
      label3.setText("Rs."+price+"/= per unit");
      label3.setForeground(new Color(0,0,0));
      label3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
      label3.setHorizontalAlignment(SwingConstants.CENTER);
      container.add(label3);
      
    try
      {
        BufferedImage img = ImageIO.read(new File(imagefile));  
        
        Image image = img.getScaledInstance(label1.getWidth(),label1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        label1.setIcon(imageicon);
      }
      catch(IOException e)
      {
         JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
      }

    } 
    
    public void createQuantitySelector(int i)
    {     pid= i;
        frm_qty = new JFrame();
        frm_qty.setTitle("ADD TO CART");
        frm_qty.setSize(700,500);
        frm_qty.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm_qty.setLayout(null);
        frm_qty.getContentPane().setBackground( new Color(24,30,54) );
        frm_qty.setVisible(true);
        frm_qty.setLocationRelativeTo(null);
        
        Border blackline = BorderFactory.createLineBorder(new Color(0,126,249));
        Border buttonline = BorderFactory.createLineBorder(new Color(0,126,249),3);
        
        lbl_image = new JLabel();
        lbl_image.setBounds(50,100,200,200);
        lbl_image.setBorder(blackline);
        frm_qty.add(lbl_image);
        
        lbl_name = new JLabel();
        lbl_name.setBounds(300,100,150,30);
        lbl_name.setText("NAME : ");
        lbl_name.setForeground(new Color(158,161,176));
        lbl_name.setFont(new Font("Segoe UI", Font.BOLD, 18));
        frm_qty.add(lbl_name);
       
        lbl_price = new JLabel();
        lbl_price.setBounds(300,150,150,30);
        lbl_price.setText("PRICE : ");
        lbl_price.setForeground(new Color(158,161,176));
        lbl_price.setFont(new Font("Segoe UI", Font.BOLD, 18));
        frm_qty.add(lbl_price);
        
        lbl_qty = new JLabel();
        lbl_qty.setBounds(300,200,150,30);
        lbl_qty.setText("QUANTITY : ");
        lbl_qty.setForeground(new Color(158,161,176));
        lbl_qty.setFont(new Font("Segoe UI", Font.BOLD, 18));
        frm_qty.add(lbl_qty);
        
           
        btn_addcart = new JButton();
        btn_addcart.setBounds(225,350,250,50);
        btn_addcart.setText("ADD TO CART");
        btn_addcart.setBackground( new Color(24,30,54) );
        btn_addcart.setForeground(new Color(0,126,249));
        btn_addcart.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btn_addcart.setBorder(buttonline);
        btn_addcart.addActionListener(this);

        frm_qty.add(btn_addcart);
        
        
        //loaded stuff       
        name = new JLabel();
        name.setBounds(450,100,150,30);
        name.setText("ZART");
        name.setForeground(new Color(0,126,249));
        name.setFont(new Font("Segoe UI", Font.BOLD, 20));
        frm_qty.add(name);
        
        price = new JLabel();
        price.setBounds(450,150,150,30);
        price.setText("ZART");
        price.setForeground(new Color(0,126,249));
        price.setFont(new Font("Segoe UI", Font.BOLD, 20));
        frm_qty.add(price);      
          
        try{
            ResultSet rs =Mproducts.loadProductById(i);
            while(rs.next())
            {
               
                name.setText(rs.getString(1));
                price.setText(Integer.toString(rs.getInt(6)));
                loadimage = rs.getString(7);
                maxqty = rs.getInt(3);
               
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(), e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
               
        SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, maxqty, 1);
        txt_qty = new JSpinner(model1);
        txt_qty.setBounds(450,200,150,35); 
        txt_qty.setFont(new Font("Segoe UI", Font.BOLD, 20));
        frm_qty.add(txt_qty);
        
                try
      {
        BufferedImage img = ImageIO.read(new File(loadimage));  
        Image image = img.getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageicon = new ImageIcon(image);
        lbl_image.setIcon(imageicon);
      }
      catch(IOException e)
      {
       JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(),e.getMessage());
      }  
        
        
        
    }

        @Override
    public void mouseClicked(MouseEvent e)
    {
    // JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(),"You clicked "+label1.getName());
        createQuantitySelector(Integer.parseInt(label1.getName()));
    } 
        @Override
    public void mouseEntered(MouseEvent e) {  
         
    }  
        @Override
    public void mouseExited(MouseEvent e) {  
        
    }  
        @Override
    public void mousePressed(MouseEvent e) {  
       
    }  
        @Override
    public void mouseReleased(MouseEvent e) {  
       
    }  
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        int required_quntity = (Integer) txt_qty.getValue();
        if(required_quntity == 0)
        {
            JOptionPane.showMessageDialog(CMessageManagement.getVisibleContent(),"Please Select Quantity","INFO",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
           CCart.insertIntoCart(pid, required_quntity, Integer.parseInt(price.getText()),name.getText());
           frm_qty.dispose();
        }
    }
    
}
