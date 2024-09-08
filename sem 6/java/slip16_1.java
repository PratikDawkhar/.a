/*
1. Write a java program to create a TreeSet, add some colors (String) and print out the 
content of TreeSet in ascending order
 */
package com.mycompany.javaslip;


import java.util.*;

public class slip16_1
        
{
    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Black");
        
        System.out.println(colors);
    }
}
