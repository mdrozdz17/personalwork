/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine1;

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
public class ItemDao {

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";
    private ConsoleIO con = new ConsoleIO();

    private HashMap<Integer,Item> itemMap = new HashMap();

    public void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Item currentItem = new Item();
            
            currentItem.setId(Integer.parseInt((currentTokens[0])));
            currentItem.setName(currentTokens[1]);
            currentItem.setCost(Double.parseDouble(currentTokens[2]));
            currentItem.setNumInInventory(Integer.parseInt(currentTokens[3]));
            
            itemMap.put(Integer.parseInt((currentTokens[0])), currentItem);
            
        }
    }
    
    public void encode() throws IOException {
       PrintWriter out = new PrintWriter(new FileWriter(INVENTORY_FILE));
       Set<Integer> keySet = itemMap.keySet();
       for (Integer id : keySet) {
           
           out.print((itemMap.get(id)).getId());
           out.print(DELIMITER);
           
           out.print((itemMap.get(id)).getName());
           out.print(DELIMITER);
           
           out.print((itemMap.get(id)).getCost());
           out.print(DELIMITER);
           
           out.print((itemMap.get(id)).getNumInInventory());
           out.println("");

           out.flush();
       }
       
       out.close();

    }

    Integer[] getInformation() {
        Set<Integer> keySet = itemMap.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    public Item getItem(Integer id) {
        return itemMap.get(id);
    }

    //Item read(int choice) {
      
  //  }

    void update(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

  


