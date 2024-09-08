/*
Write a Menu Driven program in Java for the following: Assume Employee table with 
attributes (ENo, EName, Salary) is already created. 1. Insert 2. Update 3. Display 4. 
Exit
 */
package com.mycompany.javaslip;

import java.sql.*;
import java.util.Scanner;

public class slip22_1
{
    private static void insert(Connection conn) throws SQLException {
        String sql = "insert into emp2 values (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter eno:");
        ps.setInt(1, sc.nextInt());
        sc.nextLine();

        System.out.println("Enter ename:");
        ps.setString(2, sc.nextLine());

        System.out.println("Enter salary:");
        ps.setFloat(3, sc.nextFloat());
        
        ps.executeUpdate();
    }

    private static void update(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter eno:");
        int eno = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter new  ename:");
        String ename = sc.nextLine();
        
        System.out.println("Enter new salary:");
        float salary = sc.nextFloat();
        
        String sql = "update emp2 set ename = '" + ename + "', salary = " + salary + " where eno = " + eno;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    private static void display(Connection conn) throws SQLException {
        String sql = "select * from emp2";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Emp table data:");
        while (rs.next()) {
            System.out.println("eno: " + rs.getInt("eno"));
            System.out.println("ename: " + rs.getString("ename"));
            System.out.println("salary: " + rs.getFloat("salary"));
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

        int ch;
        do {
            System.out.println("Menu");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.println("-------------------------");

            System.out.println("Enter your choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    insert(conn);
                    break;
                case 2:
                    update(conn);
                    break;
                case 3:
                    display(conn);
                        break;
            }
        } while (ch != 4);
    }
}
