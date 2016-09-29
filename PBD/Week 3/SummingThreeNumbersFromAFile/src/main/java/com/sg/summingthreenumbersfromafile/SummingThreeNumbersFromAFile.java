/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.summingthreenumbersfromafile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SummingThreeNumbersFromAFile {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("3nums.txt"));
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int sum = a + b + c;
        
        System.out.println("Reading numbers from file 3nums.txt....done");
        
        
        System.out.println(a + " + " + b + " + " + c + " = " + sum);
        
        sc.close();

    }

}
