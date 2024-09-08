/*
2. Write a Java program to display first record from student table (RNo, SName, Per) onto 
the TextFields by clicking on button. (Assume Student table is already created)
 */
package com.mycompany.javaslip;


import java.awt.GridLayout;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;

class StudentRec 
{
    private JFrame frame;
    private JTextField tf1, tf2, tf3; 
    private JButton display;
    
    StudentRec() throws SQLException {
        frame = new JFrame("Student First Record.");
        frame.setSize(200, 300);
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        
        display = new JButton("Show Record");
        
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        
        display.addActionListener((ActionEvent) -> {
            try {
                select(conn);
            } catch (SQLException ex) {
                Logger.getLogger(StudentRec.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        frame.setLayout(new GridLayout(4,1));
        
        frame.add(tf1);
        frame.add(tf2);
        frame.add(tf3);
        frame.add(display);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void select(Connection conn) throws SQLException {
        String sql = "select * from student where rno = 1";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        ResultSet rs = stmt.getResultSet();
        
        while(rs.next()) {
            tf1.setText("       " + rs.getInt("rno"));
            tf2.setText("      " + rs.getString("sname"));
            tf3.setText("      "  + rs.getFloat("per") + "");
        }
    }
}

public class slip10_2
{
    public static void main(String[] args) throws SQLException {
        new StudentRec();
    }
}
