/*
 Write a Java program to display information about all columns in the DONAR table 
using ResultSetMetaData.
 */
package com.mycompany.javaslip;


import java.sql.*;

public class slip11_2
{
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        
        String sql = "select * from donar";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        
        ResultSet rs = stmt.getResultSet();
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int colCnt = rsmd.getColumnCount();
        System.out.println("Donar table Meta Data:");
        for(int i=1; i<colCnt; i++) {
            String colName = rsmd.getColumnName(i);
            String colType = rsmd.getColumnTypeName(i);
            int colSize = rsmd.getColumnDisplaySize(i);
            
            System.out.println(colName + " " + colType + "(" + colSize + ")");
        }
    }
}
