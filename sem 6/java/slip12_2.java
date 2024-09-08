/*
 Write a Java Program to create a PROJECT table with field’s project_id, Project_name, 
Project_description, Project_Status. Insert values in the table. Display all the details of 
the PROJECT table in a tabular format on the screen.(using swing). 
 */
package com.mycompany.javaslip;


import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class ProjectTable {
    private JFrame frame;
    private JTable table;
    
    ProjectTable() throws SQLException {
        frame = new JFrame("Project Table");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 150);
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        
        createTable(conn);
        insert(conn);
        
        String[] colNames = {"pid", "pname", "description", "status"};
        String[][] data = retriveData(conn);
        
        table = new JTable(data, colNames);
        JScrollPane scrPane = new JScrollPane(table);
        
        frame.getContentPane().add(scrPane, BorderLayout.CENTER);        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void createTable(Connection conn) throws SQLException {
        String sql = "create table if not exists project("
                    + "pid int primary key,"
                    + "pname varchar(30),"
                    + "description varchar(30),"
                    + "status varchar(30))";
        
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    private void insert(Connection conn) throws SQLException {
        String sql = "insert into project values"
                    + "(1, 'Game', 'Java Platformer Game', 'complete'),"
                    + "(2, 'Website', 'MERN stack', 'complete'),"
                    + "(3, 'Portfolio', 'PHP', 'complete')";
        
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    private String[][] retriveData(Connection conn) throws SQLException {
        String sql = "select * from project";

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();

        int noCol = rsmd.getColumnCount();
        rs.last();
        int noRow = rs.getRow();
        rs.beforeFirst();

        String[][] data = new String[noRow][noCol];

        int rowCnt = 0;
        while (rs.next()) {
            for (int i = 1; i <= noCol; i++)
                data[rowCnt][i - 1] = rs.getString(i); 
            rowCnt++;
        }
        return data;
    }

}

public class slip12_2
{
    public static void main(String[] args) throws SQLException {
        new ProjectTable();
    }
}
