/*
Write a Java program using Runnable interface to blink Text on the JFrame (Use 
Swing)
 */
package com.mycompany.practical_slip;

import java.awt.Color;
import java.util.Random;
import javax.swing.*;

class BlinkText implements Runnable 
{
    private JFrame frame;
    private JLabel blink;
    
    public BlinkText() {
        frame = new JFrame("Blink Light");
        frame.setSize(200, 200);
        blink = new JLabel("Blink");
        frame.add(blink);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(true) {
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            blink.setForeground(new Color(r, g, b));
        }
    }
}

public class slip4_1
{
    public static void main(String[] args) {
        Thread t = new Thread(new BlinkText());
        t.start();
    }
}
