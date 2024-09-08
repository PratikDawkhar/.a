/*
Write a Java Program for the following: Assume database is already created.
 */
package com.mycompany.javaslip;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class slip25_2
{
    JFrame frame;
    JButton b1, b2, b3;
    JTextField tf;
    
    slip25_2() throws SQLException {
        frame = new JFrame("DB App");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 100);
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        
        tf = new JTextField();
        p1.setLayout(new GridLayout(1, 2));
        p1.add(new JLabel("Type your DDL query:"));
        p1.add(tf);
        
        b1 = new JButton("Create Table");
        b2 = new JButton("Alter Table");
        b3 = new JButton("Drop Table");
        p2.setLayout(new GridLayout(1, 3));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres"); 
        
        b1.addActionListener((ActionEvent e) -> {
            try {
                create(conn);
            } catch (SQLException ex) {
                Logger.getLogger(S25Q2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        b2.addActionListener((ActionEvent e) -> {
            try {
                alter(conn);
            } catch (SQLException ex) {
                Logger.getLogger(S25Q2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        b3.addActionListener((ActionEvent e) -> {
            try {
                drop(conn);
            } catch (SQLException ex) {
                Logger.getLogger(S25Q2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        frame.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private void create(Connection conn) throws SQLException {
        String sql = tf.getText();        
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    private void alter(Connection conn) throws SQLException {
        String sql = tf.getText();        
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    private void drop(Connection conn) throws SQLException {
        String sql = tf.getText();        
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
    
    public static void main(String[] args) throws SQLException {
        new S25Q2();
    }
}
