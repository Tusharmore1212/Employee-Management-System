/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employeemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author hp
 */
public class ViewEmployee extends JFrame implements ActionListener{
    JTable table;
     Choice cemployee;
     JButton search,print,update,back;
    ViewEmployee()
    {
        setBackground(Color.white);
        setLayout(null);
        JLabel searchlbl = new JLabel("Search by Employee id");
        searchlbl.setBounds(20,20,150,20);
        add(searchlbl);
        
        cemployee = new Choice();
        cemployee.setBounds(180,20,150,20);
        add(cemployee);
        table = new JTable();
         try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            
            while(rs.next())
            {
                cemployee.add(rs.getString("empId"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                cemployee.add(rs.getString("empId"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
       update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==search)
            {
                String query = "select * from employee where empId = '"+cemployee.getSelectedItem()+"'";
                try{
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }else if(ae.getSource()==print)
            {
                try{
                   table.print();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }else if(ae.getSource()==update)
            {
                setVisible(false);
                new updateEmployee(cemployee.getSelectedItem());
            }
            else
            {
                setVisible(false);
                new Home();
            }
        }
    public static void main(String args[])
    {
        new ViewEmployee();
    }

    
}
