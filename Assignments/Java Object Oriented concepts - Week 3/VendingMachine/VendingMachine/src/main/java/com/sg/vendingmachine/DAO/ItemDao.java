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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class ItemDao {

    private static String INVENTORY_FILE = "inventory.txt";
    private static final String DELIMITER = "::";
    private List<Item> items = null;
    private int nextId = 1;

   /* public ItemDao() {

        items = decode();

        for (Item i : items) {

            if (i.getId() >= nextId) {

                nextId = i.getId() + 1;
            }
        }
 */

    

    public Item add(Item item) throws IOException {
        item.setId(nextId);

        items.add(item);

        nextId++;

        encode();

        return item;
    }

    public Item read(int id) {

        for (Item i : items) {

            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void update(Item item) throws IOException {

        for (Item i : items) {

            if (i.getId() == item.getId()) {
                i = item;
            }

        }

        encode();

    }

    public void delete(Item item) throws IOException {

        for (Item i : items) {

            if (i.getId() == item.getId()) {
                items.remove(i);
            }
            break;

        }

        encode();
    }

    public List<Item> list() {

        return new ArrayList(items);

    }

    public void encode() throws IOException {

        PrintWriter out = new PrintWriter(new FileWriter(INVENTORY_FILE));

        for (Item i : items) {

            out.print(i.getId());
            out.print(DELIMITER);

            out.print(i.getName());
            out.print(DELIMITER);

            out.print(i.getCost());
            out.print(DELIMITER);

            out.print(i.getNumInInventory());
            out.println("");

        }

        out.flush();
        out.close();

    }

    public List<Item> decode() throws FileNotFoundException {

        List<Item> tempItemList = new ArrayList();

            Scanner sc = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));

            while (sc.hasNextLine()) {

                String currentLine = sc.nextLine();

                String[] stringParts = currentLine.split(DELIMITER);

                Item myItem = new Item();

                int itemId = Integer.parseInt(stringParts[0]);
                String item = (stringParts[1]);
                double itemCost = Double.parseDouble(stringParts[2]);
                int numInventory = Integer.parseInt(stringParts[3]);

                myItem.setId(itemId);
                myItem.setName(item);
                myItem.setCost(itemCost);
                myItem.setNumInInventory(numInventory);

                tempItemList.add(myItem);
            }

        return tempItemList;
    }
}
