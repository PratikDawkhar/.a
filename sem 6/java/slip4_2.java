/*
2. Write a Java program to store city names and their STD codes using an appropriate 
collection and perform following operations:
i. Add a new city and its code (No duplicates) 
ii. Remove a city from the collection 
iii. Search for a city name and display the code
 */
package com.mycompany.practical_slip;

import java.util.*;

public class slip4_2
{
    public static void main(String[] args) {
        Map<String, String> cityMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        
        int ch;
        String code, city;
        do {
            System.out.println("Menu");
            System.out.println("1. Add City and std code.(no duplicates)");
            System.out.println("2. Remove City.");
            System.out.println("3. Search city name dsiplay std code");
            System.out.println("4. Exit");
            
            System.out.println("------------------------------");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            sc.nextLine();
            System.out.println();
            
            switch(ch) {
                case 1: System.out.println("Enter std code.");
                    code = sc.nextLine();
                    System.out.println("Enter City.");
                    city = sc.nextLine();
                    cityMap.put(code, city);
                    break;
                case 2: System.out.println("Enter std code.");
                    code = sc.nextLine();
                    cityMap.remove(code);
                    break;
                case 3: System.out.println("Enter city:");
                    city = sc.nextLine();
                    code = null;
                    for(Map.Entry<String, String> map : cityMap.entrySet()) {
                        if(map.getValue().equals(city))
                            code = map.getKey();
                    }
                    if(code != null)
                        System.out.println("Code is " + code);
                    else
                        System.out.println("Not found.");
                    break;
                default: System.out.println("Invalid choice.");
            }
            System.out.println("-------------------------------");
        } while(ch != 4);
    }
}
