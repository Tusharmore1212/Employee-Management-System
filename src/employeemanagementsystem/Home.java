/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author hp
 */
public class Home extends JFrame implements ActionListener{
    
    JButton add,view,update,remove; 
    Home()
    {
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3); 
        l2.setBounds(0,0,1120,630);
        add(l2);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYTEM");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("Railway",Font.BOLD,25));
        heading.setForeground(Color.black);
        l2.add(heading);
        
        
        add = new JButton("ADD Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        l2.add(add);
        
        view = new JButton("VIEW Employee");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        l2.add(view);
        
        update = new JButton("UPDATE Employee");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        l2.add(update);
        
        remove = new JButton("REMOVE Employee");
        remove.setBounds(820,140,150,40);
        remove.addActionListener(this);
        l2.add(remove);
        
        
        
        setSize(1120,630);
        setLocation(100,50);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
                setVisible(false);
                new addemployee();
        }else if( ae.getSource() == view)
        {  setVisible(false);
            new ViewEmployee();
        
        }else if( ae.getSource() == update)
        {
            setVisible(false);
            new ViewEmployee();
        }else
        {
            setVisible(false);
            new RemoveEmployee();
        }
    }
    public static void main(String args[])
    {
        new Home();
    }

   
}