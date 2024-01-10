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
public class Splash extends JFrame implements ActionListener{
    Splash()
    {
        setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYTEM");
        heading.setBounds(80,30,1200,80);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.RED);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3); 
        l2.setBounds(50,100,1050,500);
        add(l2);
        
        JButton contiue = new JButton("Click Here To CONTINUE");
        contiue.setBounds(400,400,300,70);
        contiue.setBackground(Color.BLACK);
        contiue.setForeground(Color.WHITE);
        contiue.addActionListener(this);
        l2.add(contiue);
        
        
        
        setSize(1100,650);
        setLocation(150,50);
        setVisible(true);
        
        while(true)
        {
            heading.setVisible(false);
            
            try{
                Thread.sleep(500);
            }catch(Exception e)
            {
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e)
            {}
        }
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String args[])
    {
        
        new Splash();
    }
}
