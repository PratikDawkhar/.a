/*
 Write a java program to read ‘N’ names of your friends, store it into HashSet and 
display them in ascending order.
 */
package com.mycompany.practical_slip;

import java.util.*;

public class slip2_1
{
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many names:");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter three names:");
        for(int i=0; i<n; i++)
            names.add(sc.nextLine());
        
        TreeSet<String> sortedNames = new TreeSet<>(names);
        System.out.println(sortedNames);       
    }
}