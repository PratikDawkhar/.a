/*
2. Write a Java program to create LinkedList of integer objects and perform the following: 
i. Add element at first position 
ii. Delete last element 
iii. Display the size of link list 
 */
package com.mycompany.javaslip;


import java.util.*;

public class slip29_2
{
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        
        int ch;
        
        do {
            System.out.println("Menu");
            System.out.println("1. Insert at head");
            System.out.println("2. Delete tail.");
            System.out.println("3. Display size");
            System.out.println("4. Exit");
            
            System.out.println("------------------------------");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            System.out.println();
            
            switch(ch) {
                case 1: System.out.println("Enter a number:");
                    l.addFirst(sc.nextInt());
                    break;
                case 2: l.removeLast();
                    break;
                case 3: 
                    System.out.println("Size : " + l.size() + "\n" + l);
                    break;
                default: System.out.println("Invalid choice.");
            }
            System.out.println("-------------------------------");
        } while(ch != 4);
    }
}
