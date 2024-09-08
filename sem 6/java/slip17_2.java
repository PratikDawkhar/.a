/*
Write a java program using Multithreading to display the number’s between 1 to 100 
continuously in a JTextField by clicking on JButton. (Use Runnable Interface & 
Swing).
 */
package com.mycompany.javaslip;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.logging.*;
import javax.swing.*;

public class slip17_2
{
    private JFrame frame;
    private JTextField tf;
    private JButton print;
    private Thread intThread;
    
    slip17_2() {
        frame = new JFrame("Integer printing App");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(2,1));
        
        tf = new JTextField();
        print = new JButton("Print");
        
        frame.add(tf);
        frame.add(print);
        
        print.addActionListener((ActionEvent e) -> {
            tf.setText("");
            if(intThread == null || !intThread.isAlive()) {
                intThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true) {
                            for(int i=1; i<=100; i++) {
                                tf.setText(String.valueOf(i));
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(S17Q2.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            tf.setText("");
                        }
                    }
                });
                intThread.start();
            }
        });
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new S17Q2();
    }
}
