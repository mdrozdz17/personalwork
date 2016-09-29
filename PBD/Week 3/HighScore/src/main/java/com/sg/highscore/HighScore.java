/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.highscore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HighScore {
    private final String OUTPUT_FILE = "score.txt";
    Scanner sc = new Scanner(System.in);
   public void run() throws IOException {
       try{
       PrintWriter outPrinter = new PrintWriter(new FileWriter(OUTPUT_FILE));
           System.out.println("You got a high score");
           System.out.println("Please enter your score");
           int score = sc.nextInt();
           System.out.println("Please enter your name");
           String name = sc.next();
        outPrinter.println("score: " + score);
        outPrinter.println("name: " + name);
           System.out.println("Data stored into score.txt");
                outPrinter.close();
      } catch (FileNotFoundException fnf) {
    }
    
}
}

