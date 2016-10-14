/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Tax;
import com.sg.flooringmastery.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class TaxDao {

    private static final String TAXES_FILE = "tax.txt";
    private static final String DELIMITER = "::";

    private ConsoleIO con = new ConsoleIO();
    List<Tax> taxes = new ArrayList<>();
   

    private void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(TAXES_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            con.print(sc.nextLine());
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Tax currentTax = new Tax();
            
            currentTax.setState((currentTokens[0]));
            currentTax.setTaxRate(Double.parseDouble(currentTokens[1]));
            
            taxes.add(currentTax);
        }

    }
}
    


    
    

