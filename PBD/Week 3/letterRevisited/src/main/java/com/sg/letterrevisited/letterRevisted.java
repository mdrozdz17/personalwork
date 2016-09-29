/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.letterrevisited;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author apprentice
 */
public class letterRevisted {

    private final String OUTPUT_FILE = "OutFile.txt";

    public void run() throws IOException {
        try {
            PrintWriter outPrinter = new PrintWriter(new FileWriter(OUTPUT_FILE));
            outPrinter.println("+---------------------------------------------------+");
            outPrinter.println("|                                              #### |");
            outPrinter.println("|                                              #### |");
            outPrinter.println("|                                              #### |");
            outPrinter.println("|                                                   |");
            outPrinter.println("|                                                   |");
            outPrinter.println("|                          Matt Drozdz              |");
            outPrinter.println("|                          143 Wood Ave             |");
            outPrinter.println("|                          Portsmouth, NH 03801     |");
            outPrinter.println("|                                                   |");
            outPrinter.println("+---------------------------------------------------+");
            outPrinter.close();
        } catch (FileNotFoundException fnf) {
            // Tell the user we can't find a file and include the file
            System.out.println("We canot find the file " + OUTPUT_FILE);

        }
    }
}
