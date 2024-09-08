/*
 2. Write a Java program to create LinkedList of String objects and perform the following:
i. Add element at the end of the list
ii. Delete first element of the list
iii. Display the contents of list in reverse order
 */
package com.mycompany.javaslip;

import java.util.*;

public class slip3_2 {

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int ch;

        do {
            System.out.println("Menu");
            System.out.println("1. Insert at tail");
            System.out.println("2. Delete head.");
            System.out.println("3. Display in reverse");
            System.out.println("4. Exit");

            System.out.println("------------------------------");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (ch) {
                case 1:
                    System.out.println("Enter name.");
                    names.addLast(sc.nextLine());
                    break;
                case 2:
                    names.removeFirst();
                    break;
                case 3:
                    Iterator it = names.descendingIterator();
                    while (it.hasNext()) {
                        System.out.println(it.next());

                    }

                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println("-------------------------------");
        } while (ch != 4);
    }
}
