/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author hp
 */
public class addemployee extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    JDateChooser dcdob;
    JComboBox cbEducation;
    JLabel lblempoyeeid;
    JButton addemployee,back;
    JTextField TName,FTName,Tsalary,Taddress,Thpone,TEmail,Tdesination,Taadhar;
    addemployee()
    {
        setBackground(Color.white);
        setLayout(null);
        JLabel heding = new JLabel("Add Employee Detail");
        heding.setBounds(320,30,500,50);
        heding.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heding);
        
        
        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblname);
        
        
         TName = new JTextField();
        TName.setBounds(200,150,150,30);
        add(TName);
        
        
        JLabel lblFname = new JLabel("Father's Name:");
        lblFname.setBounds(400,150,220,30);
        lblFname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblFname);
        
        
        FTName = new JTextField();
        FTName.setBounds(600,150,150,30);
        add(FTName);
        
        
        JLabel lbldob = new JLabel("DoB:");
        lbldob.setBounds(50,200,150,30);
        lbldob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lbldob);
        
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        JLabel lblsalary = new JLabel("Salary:");
        lblsalary.setBounds(400,200,220,30);
        lblsalary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblsalary);
        
        
        Tsalary = new JTextField();
        Tsalary.setBounds(600,200,150,30);
        add(Tsalary);
        
        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50,250,220,30);
        lbladdress.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lbladdress);
        
        
        Taddress = new JTextField();
        Taddress.setBounds(200,250,150,30);
        add(Taddress);
        
        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400,250,220,30);
        lblphone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblphone);
        
        
        Thpone = new JTextField();
        Thpone.setBounds(600,250,150,30);
        add(Thpone);
        
        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50,300,220,30);
        lblemail.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblemail);
        
        
        TEmail = new JTextField();
        TEmail.setBounds(200,300,150,30);
        add(TEmail);
        
        JLabel lbleducation = new JLabel("Higest Education:");
        lbleducation.setBounds(400,300,220,30);
        lbleducation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lbleducation);
        
        String course[] ={"BBA","BCA","MCA","MBA"};
        cbEducation = new JComboBox(course);
        cbEducation.setBounds(600,300,150,30);
        add(cbEducation);
        
        JLabel lbldesignation = new JLabel("Designation:");
        lbldesignation.setBounds(50,350,220,30);
        lbldesignation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lbldesignation);
        
        
        Tdesination = new JTextField();
        Tdesination.setBounds(200,350,150,30);
        add(Tdesination);
        
        JLabel lblaadhar = new JLabel("Aadhar:");
        lblaadhar.setBounds(400,350,220,30);
        lblaadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblaadhar);
        
        
        Taadhar = new JTextField();
        Taadhar.setBounds(600,350,150,30);
        add(Taadhar);
        
        JLabel lblempid = new JLabel("EMployeeID:");
        lblempid.setBounds(50,400,220,30);
        lblempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblempid);
        
        lblempoyeeid = new JLabel(""+number);
        lblempoyeeid.setBounds(200,400,220,30);
        lblempoyeeid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(lblempoyeeid);
        
        addemployee = new JButton("Add Details");
        addemployee.setBounds(250,550,150,40);
        addemployee.setBackground(Color.BLACK);
        addemployee.setForeground(Color.WHITE);
        addemployee.addActionListener(this);
        add(addemployee);
        
         back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==addemployee)
       {
           String name = TName.getText();
           String fname = FTName.getText();
           String dob  = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
           String salary = Tsalary.getText();
           String address = Taddress.getText();
           String phone = Thpone.getText();
           String email = TEmail.getText();
           String education = (String) cbEducation.getSelectedItem();
           String designation = Tdesination.getText();
           String Aadhar = Taadhar.getText();
           String empId = lblempoyeeid.getText();
           
           try{
               conn c = new conn();
               String Query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+Aadhar+"','"+empId+"')";
               c.s.executeUpdate(Query);
               JOptionPane.showMessageDialog(null, "Details addedd Successfully");
           }catch(Exception e)
           {
           }
       }else
       {
           setVisible(true);
           new Home();
       }
    }
    
    public static void main(String args[])
    {
        new addemployee();
    }
    
}
