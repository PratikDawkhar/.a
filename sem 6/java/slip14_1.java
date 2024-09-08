/*
Write a Java program using Multithreading for a simple search engine. Accept a string 
to be searched. Search the string in all text files in the current folder. Use a separate 
thread for each file. The result should display the filename and line number where the 
string is found.
 */
package com.mycompany.javaslip;

import java.io.*;
import java.util.Scanner;

class SearchThread extends Thread {
    private File file;
    private String searchStr;

    SearchThread(File file, String searchStr) {
        this.file = file;
        this.searchStr = searchStr;
    }

    public void run() {
        searchInFile(file, searchStr);
    }

    public void searchInFile(File file, String searchStr) {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                if (line.contains(searchStr)) {
                    System.out.println("Found '" + searchStr + "' in " + file.getName() + " at line " + lineNo);
                    found = true;
                }
            }
        } catch (IOException ex) {
            System.err.println("Error reading file: " + file.getName());
        }
        if (!found) {
            System.out.println(searchStr + " not found in " + file.getName());
        }
    }
}

public class slip14_1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string to be searched in files:");
        String searchStr = sc.nextLine();

        File currDir = new File(".");
        File[] files = currDir.listFiles();

        if (files != null) {
            boolean foundInAnyFile = false;
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    SearchThread t = new SearchThread(file, searchStr);
                    t.start();
                    foundInAnyFile = true;
                }
            }
            if (!foundInAnyFile) {
                System.out.println("No text files found in the current directory.");
            }
        } else {
            System.err.println("Error: Unable to access current directory.");
        }
    }
}
