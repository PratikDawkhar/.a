/*
 Write a Java program to display all the alphabets between ‘A’ to ‘Z’ after every 2 
seconds.
 */
package com.mycompany.practical_slip;

import java.util.logging.*;
import javax.swing.SwingUtilities;

public class slip1_1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            while(true) {
                for(char ch = 'A'; ch <= 'Z'; ch++)
                    System.out.println(ch);
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(slip1_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("2 seconds are passed....");
            }
        });
        
    }
}