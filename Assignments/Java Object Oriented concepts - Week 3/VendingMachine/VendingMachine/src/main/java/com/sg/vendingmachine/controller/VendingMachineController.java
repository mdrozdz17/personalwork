/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;
import com.sg.vendingmachine.DAO.VendingMachineDao;
import com.sg.vendingmachine.model.Item;
import com.sg.vendingmachine.ui.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author apprentice
 */
public class VendingMachineController {

    private VendingMachineDao vending = new VendingMachineDao();
    private ConsoleIO con = new ConsoleIO();
    int money = 0;
    int cost = 0;
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
         vending.decode();
         while (keepGoing) {
             printMenu();
        menuSelection = con.readInt("Please select from the above choices.", 1, 3);

        switch(menuSelection) {
            case 1:
                con.print("View Inventory and Prices");
                viewInventory();
                break;
            case 2:
                con.print("View current $ in Vending Machine");
                currentMoney();
            case 3: 
                con.print("Exit Vending Machine");
            keepGoing = false;
            break;
                
        }
         }
              con.print("Thanks for using my Vending Machine");
          vending.encode();
        } catch (FileNotFoundException ex) {
            con.print("Error loading Vending Machine.");
        } catch (IOException ex) {
            con.print("Error writing to file");
         
         
        }
    }
    
    private void printMenu() {
        con.print("===================Main Menu===========================");
        con.print("1. View Vending Machine Inventory and Prices");
        con.print("2. View Current Money in Vending Machine");
        con.print("3. Exit");
    }     

    private void viewInventory() {
         Integer[] vendingStock = vending.getVendingInventory();
        for (Integer i : vendingStock) {
            Item currentItem = vending.getInformation(i);

            con.print(i + "." + " " + currentItem.getItem());
        }
        con.readString("Please hit enter to continue.");
    }

    private void currentMoney() {
       con.readInt("You currently have" + money + "inserted in the Vending Machine");
    }
}
    

