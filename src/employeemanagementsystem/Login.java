/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author hp
 */
public class Login extends JFrame implements ActionListener{
    Connection c;
    Statement s;
    JTextField tfusername,password;
    Login()
    {
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblUserName = new JLabel("username:");
        lblUserName.setBounds(40,20,100,30);
        add(lblUserName);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        password = new JTextField();
        password.setBounds(150,70,150,30);
        add(password);
        
        
        JButton contiue = new JButton("Login");
        contiue.setBounds(150,140,150,30);
        contiue.setBackground(Color.BLACK);
        contiue.setForeground(Color.WHITE);
        contiue.addActionListener(this);
        add(contiue);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3); 
        l2.setBounds(350,0,200,200);
        add(l2);
        
        
         setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
     
        try{
            String username = tfusername.getText();
            String pass = password.getText();
           //conn c = new conn();
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","admin");
            s =c.createStatement();
            String query = "select * from login where username = '"+username+"' and password = '"+pass+"'";
            ResultSet rs = s.executeQuery(query);
            if(rs.next())
            {
                setVisible(false);
                new Home();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"invalid username or password");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
           }
    }   
    public static void main(String args[])
    {
        new Login();
    }
    
}
