/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
/**
 *
 * @author hp
 */
public class RemoveEmployee extends JFrame implements ActionListener {
    Choice ch;
    JButton delete, back;
    RemoveEmployee()
    {
        setBackground(Color.white);
        setLayout(null);
             
        JLabel lblId = new JLabel("Employee Id");
        lblId.setBounds(50,50,100,30);
        add(lblId);
        
        ch = new Choice();
        ch.setBounds(200,50,150,30);
        add(ch);
        
        try{
            conn c = new conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                ch.add(rs.getString("empId"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,100,100,30);
        add(lblname);
        
        JLabel lblname2 = new JLabel();
        lblname2.setBounds(200,100,100,30);
        add(lblname2);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(50,150,100,30);
        add(phone);
        
        JLabel phone2 = new JLabel();
        phone2.setBounds(200,150,100,30);
        add(phone2);
        
        JLabel email = new JLabel("Email");
        email.setBounds(50,200,100,30);
        add(email);
        
        JLabel email2 = new JLabel();
        email2.setBounds(200,200,100,30);
        add(email2);
        
        try{
            conn c = new conn();
            String query = "select * from employee where empId = '"+ch.getSelectedItem()+"'";
    
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblname2.setText(rs.getString("name"));
                phone2.setText(rs.getString("phone"));
                email2.setText(rs.getString("Email"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
           ch.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent io)
           {
                 try{
            conn c = new conn();
            String query = "select * from employee where empId = '"+ch.getSelectedItem()+"'";
    
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblname2.setText(rs.getString("name"));
                phone2.setText(rs.getString("phone"));
                email2.setText(rs.getString("Email"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
           }
           });
           
           
        delete= new JButton("Delete Details");
        delete.setBounds(80,300,120,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
         back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3); 
        l2.setBounds(350,0,600,400);
        add(l2);
        
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==delete)
        {
            try{
                conn c = new conn();
                String sql = "delete from employee where empId = '"+ch.getSelectedItem()+"'";
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"employee information deleted successfully");
                setVisible(false);
                new Home();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[])
    {
        new RemoveEmployee();
    }

}
