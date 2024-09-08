/*
 Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program 
should print randomly the name of thread and value of sleep time. The name of the 
thread should be hard coded through constructor. The sleep time of a thread will be a 
random integer in the range 0 to 4999.
 */
package com.mycompany.javaslip;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadLifeCycle extends Thread {
    private String threadName;
    
    ThreadLifeCycle(String threadName) {
        this.threadName = threadName;
    }
    
    public void run() {
        Random rand = new Random();
        int sTime = rand.nextInt(5000);
        System.out.println(threadName + " is created.");
        System.out.println("Sleep time of " + threadName + " is: " + sTime + "ms.");
        try {
            Thread.sleep(sTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadLifeCycle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(threadName + " is dead.");
    }
}

public class slip13_2
{
    public static void main(String[] args) {
        ThreadLifeCycle t1 = new ThreadLifeCycle("First");
        ThreadLifeCycle t2 = new ThreadLifeCycle("Second");
        ThreadLifeCycle t3 = new ThreadLifeCycle("Third");
        
        t1.start();
        t2.start();
        t3.start();
    }
}
