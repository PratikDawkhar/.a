/*
 Write a java program using Multithreading to scroll the text from left to right 
continuously (Use Swing). 
 */
package com.mycompany.javaslip;

import javax.swing.*;

class TextScrolling extends JFrame implements Runnable {
    private JLabel label;
    private String text;
    private Thread thread;

    public TextScrolling(String text) {
        this.text = text;
        label = new JLabel(text);
        add(label);
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startScrolling() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String labelText = label.getText();
                labelText = labelText.substring(1) + labelText.charAt(0);
                label.setText(labelText);
                Thread.sleep(200); // Adjust scrolling speed
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    
}

public class slip24_1
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextScrolling ts = new TextScrolling("Hello, this text is scrolling continuously!");
            ts.startScrolling();
        });
    }
}
