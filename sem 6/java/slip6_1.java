/*
 Write a Java program to accept ‘n’ integers from the user and store them in a Collection. 
Display them in the sorted order. The collection should not accept duplicate elements. 
(Use a suitable collection). Search for a particular element using predefined search 
method in the Collection framework
 */
package com.mycompany.practical_slip;

import java.util.*;

public class slip6_1
{
    public static void main(String[] args) {
        TreeSet<Integer> nums = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many number:");
        int n = sc.nextInt();
        System.out.println("Eneter " + n + " values:");
        for(int i=0; i<n; i++)
            nums.add(sc.nextInt());
        
        System.out.println(nums);
        
        System.out.println("Enter key to search:");
        int key = sc.nextInt();
        if(nums.contains(key))
            System.out.println("Found.");
        else
            System.out.println("Not found.");
    }
}
