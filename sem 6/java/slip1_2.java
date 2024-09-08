/*
Write a Java program to accept the details of Employee (Eno, EName, Designation, 
Salary) from a user and store it into the database. (Use Swing) 
 */
package com.mycompany.practical_slip;

//slip 1-2
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

class EmpApp {
    private JFrame frame;
    private JTextField eno, ename, desig, sal;
    private JButton clear, insert;
    
    EmpApp() throws SQLException {
        frame = new JFrame("Employee App");
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5,2));
        
        eno = new JTextField();
        ename = new JTextField();
        desig = new JTextField();
        sal = new JTextField();
        
        frame.add(new JLabel("Eno."));
        frame.add(eno);
        frame.add(new JLabel("EName"));
        frame.add(ename);
        frame.add(new JLabel("Designation"));
        frame.add(desig);
        frame.add(new JLabel("Salary"));
        frame.add(sal);
        
        clear = new JButton("Clear");
        insert = new JButton("insert");
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        
        insert.addActionListener((ActionEvent e) -> {
            try {
                insertEmp(conn, eno, ename, desig, sal);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(EmpApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        clear.addActionListener((ActionEvent e) -> {
            eno.setText("");
            ename.setText("");
            desig.setText("");
            sal.setText("");
        });
        
        frame.add(insert);
        frame.add(clear);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void insertEmp(Connection conn, JTextField eno, JTextField ename, JTextField desig, JTextField sal)
            throws IOException, SQLException {
        String sql = "insert into emp values(?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(eno.getText()));
        ps.setString(2, ename.getText());
        ps.setString(3, desig.getText());
        ps.setFloat(4, Float.parseFloat(sal.getText()));
        ps.executeUpdate();
    }
}

public class slip1_2
{
    public static void main(String[] args) throws SQLException {
        new EmpApp();
    }
}
