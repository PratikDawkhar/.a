/*
1. Write a java program to define a thread for printing text on output screen for ‘n’ 
number of times. Create 3 threads and run them. Pass the text ‘n’ parameters to the 
thread constructor. 
 Example: 
i. First thread prints “COVID19” 10 times. 
ii. Second thread prints “LOCKDOWN2020” 20 times 
iii. Third thread prints “VACCINATED2021” 30 times 
 */
package com.mycompany.practical_slip;

class T1 extends Thread {
    String msg;
    
    T1(String msg) {
        this.msg = msg;
    }
    
    public void run() {
        for(int i=0; i<10; i++)    
            System.out.println(msg);
    }
}

class T2 extends Thread {
    String msg;
    
    T2(String msg) {
        this.msg = msg;
    }
    
    public void run() {
        for(int i=0; i<20; i++)
            System.out.println(msg);
    }
}
class T3 extends Thread {
    String msg;
    
    T3(String msg) {
        this.msg = msg;
    }
    
    public void run() {
        for(int i=0; i<30; i++)
            System.out.println(msg);
    }
}
        
public class slip8_1
{
    public static void main(String[] args) {
        T1 t1 = new T1("COVID19");
        T2 t2 = new T2("LOCKDOWN2020");
        T3 t3 = new T3("VACCINATED2021");
        
        t1.start();
        t2.start();
        t3.start();
    }
}
