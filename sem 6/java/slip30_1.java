/*
1. Write a java program using Multithreading to demonstrate drawing Indian flag (Use 
Swing
 */
package com.mycompany.javaslip;

import javax.swing.*;
import java.awt.*;

class IndianFlag extends JFrame {

    public IndianFlag() {
        setTitle("Simple Temple Drawing");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FlagPanel flagPanel = new FlagPanel();
        add(flagPanel);
        setVisible(true);
    }
}

class FlagPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFlag(g);
    }

    private void drawFlag(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(50, 50, 200, 50);
        
        g.setColor(Color.WHITE);
        g.fillRect(50, 100, 200, 50); 
        
        g.setColor(Color.GREEN);
        g.fillRect(50, 150, 200, 50); 
        
    }
}

public class slip30_1
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new IndianFlag();
        });
    }
}
