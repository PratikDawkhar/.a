/*
 2. Write a java program for the following:
i. To create a Product (Pid, Pname, Price) table.
ii. Insert at least five records into the Product table.
iii. Display all the records from a Product table. 
Assume Database is already created
 */
package com.mycompany.practical_slip;

import java.sql.*;
import java.util.Scanner;

public class slip7_2
{
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
        
        int ch;
        do {
            System.out.println("Menu");
            System.out.println("1. Create table Product.");
            System.out.println("2. Insert into Product.");
            System.out.println("3. Display records of product.");
            System.out.println("4. Exit.");
            
            System.out.println("------------------------------");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            
            switch(ch) {
                case 1: create(conn);
                    break;
                case 2: insert(conn);
                    break;
                case 3 : select(conn);
                    break;
                default : System.out.println("Invalid choice.");
                    break;
            }
        } while(ch != 4);
    }

    private static void create(Connection conn) throws SQLException {
        String sql = "create table if not exists product("
                        + "pid int primary key,"
                        + "pname varchar(30),"
                        + "price decimal(10, 2))";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    private static void insert(Connection conn) throws SQLException {
        String sql = "insert into product values(?, ?, ?)";
        
        PreparedStatement pt = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter pid:");
        int pid = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter pname:");
        String name = sc.nextLine();
        
        System.out.println("Enter price");
        float price = sc.nextFloat();
        
        pt.setInt(1, pid);
        pt.setString(2, name);
        pt.setFloat(3, price);
        pt.executeUpdate();
    }

    private static void select(Connection conn) throws SQLException {
        String sql = "select * from product";
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        ResultSet res = stmt.getResultSet();
        
        while(res.next()) {
            System.out.println("Pid = " + res.getInt("pid"));
            System.out.println("PName = " + res.getString("pname"));
            System.out.println("Price = " + res.getFloat("price"));
            System.out.println("----------------------------------------------");
        }
    }
}
