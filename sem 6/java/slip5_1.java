/*
1. Write a Java Program to create the hash table that will maintain the mobile number and 
student name. Display the details of student using Enumeration interface
 */
package com.mycompany.javaslip;

import java.util.*;

public class slip5_1
{
    public static void main(String[] args) 
    {
        Hashtable<String, String> studentTable = new Hashtable<>();

        studentTable.put("1234567890", "john");
        studentTable.put("1239874560", "carry");

        Enumeration<String> moblieNumbers = studentTable.keys();
        while(moblieNumbers.hasMoreElements())
        {
            String no = moblieNumbers.nextElement();
            String name = studentTable.get(no);
            System.out.println("Student name: " + name + ", Mobile no: " + no);
        }
    }
}