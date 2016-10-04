/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.DAO;

import com.sg.vendingmachine.model.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class VendingMachineDao {
    
    public static final String VENDING_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    
    private HashMap<String, Item> vm = new HashMap();
    
    public void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(VENDING_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            //con.print(sc.nextLine());
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Item currentItem = new Item();

            currentItem.setItem(currentTokens[0]);
            currentItem.setCost(Double.parseDouble((currentTokens[1])));
            currentItem.setNumberOfItems(Integer.parseInt((currentTokens[2])));
            

            vm.put((currentTokens[0]), currentItem);
        }

    }

    public void encode() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(VENDING_FILE));
        Set<String> keySet = vm.keySet();
        for (String i : keySet) {

            out.print((vm.get(i)).getItem());
            out.print(DELIMITER);

            out.print((vm.get(i)).getCost());
            out.print(DELIMITER);

            out.print((vm.get(i)).getNumberOfItems());
            out.println("");

        }
        out.flush();
        out.close();
    }



    public Integer[] getVendingInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Item getInformation(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
