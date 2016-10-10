/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine1;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.sg.vendingmachine1.Change;

/**
 *
 * @author apprentice
 */
public class ItemController {
    ItemDao myItem = new ItemDao();
    Change change = new Change();
    ConsoleIO con = new ConsoleIO();
    double money;
    double roundedMoney;

    
        public void run() {

    boolean keepGoing = true;
        int menuSelection = 0;
        try {
              myItem.decode();
                con.print("Welcome to my Vending Machine");
               while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("Please select from the choices above.", 1,2);

                switch (menuSelection) {
                    case 1:
                        con.print("View Inventory and Prices");
                       vmInfo();
                       inputMoney();
                        break;
                    case 2:
                        con.print("Exit the program");
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Command");

                }
            }

            con.print("Thank you for using my Vending Machine");
            myItem.encode();
        } catch (FileNotFoundException ex) {
            con.print("Error loading Inventory.");
        } catch (IOException ex) {
            con.print("Error writing to file");

        }

    }

    private void printMenu() {
        con.print("========================Main Menu==============================");
        con.print("1. View inventory and prices");
        con.print("2. Exit");
    }

    private void vmInfo() {
        Integer[] ids = myItem.getInformation();
        for (Integer id : ids) {
            Item currentItem = myItem.getItem(id);
            con.print(id + " " + currentItem.getName() + " " + currentItem.getCost() + " "
                    + " " + currentItem.getNumInInventory());
        }
        con.readString("Please hit enter to contiue");
    }
    
    // Same method as above except without the Please hit enter to continue
    private void vmInfo1() {
        Integer[] ids = myItem.getInformation();
        for (Integer id : ids) {
            Item currentItem = myItem.getItem(id);
            con.print(id + " " + currentItem.getName() + " " + currentItem.getCost() + " "
                    + " " + currentItem.getNumInInventory());
        }
    }
    
    private void inputMoney() throws IOException {
      Item currentItem = new Item();
     double cost = currentItem.getCost();
     double newMoney = con.readDouble("How much money would you like to add?");
     
     // get current amount of money
      money = change.getAmount();
      // add the money that the user inputs
      money += newMoney;
     // sets the amount of money to the user input   
     change.setAmount(money);
     
     con.print("You have " + (Math.round(change.getAmount() * 100D) / 100D) + " available");
     
      con.print("Enter the number for the item you would like to purchase");
      vmInfo1();
        int choice = con.readInt("Please select from the choices above", 1, 6);
        
        
        if (money >= cost) {
            
            buyItem(choice);
            
        }else {
            addOrLeave();
        }
        
    }
    
    private void buyItem(int id) throws IOException {

        Item currentItem = new Item();

        double cost = currentItem.getCost();

        double money = change.getAmount();

        int invNum = currentItem.getNumInInventory();

        boolean isInventory = checkInventory(invNum, money, currentItem);

        if (isInventory == true) {

            updateItemInfo(money, cost, currentItem, invNum);

        } else {
            calculateChange(money * 100);
            change.setAmount(money);
        }
    }
    
       void updateItemInfo(double money1, double cost, Item item, int invNum) throws IOException {
        money1 -= cost;
        double pennies = money1 * 100;
        calculateChange(pennies);
        change.setAmount(money1);
        item.setNumInInventory(invNum - 1);
        myItem.update(item);
    }
       
         void addOrLeave() {
        boolean playAgain;
        con.print("Insufficient funds");
        
        
        int yn = con.readInt("Add money? (1 for y, 2 for n)", 2, 1);
        
        if (yn == 2) {
            playAgain = false;
        }
    }

    private void calculateChange(double pennies) {

        int penny = (int) pennies;
        int nickel = 0;
        int dime = 0;
        int quarter = 0;
        int remainder = 0;

        remainder = getRemainder(penny, 25);
        penny -= remainder;
        quarter += (penny / 25);
        penny += remainder;
        penny -= (25 * quarter);

        remainder = getRemainder(penny, 10);
        penny -= remainder;
        dime += (penny / 10);
        penny += remainder;
        penny -= (10 * dime);

        remainder = penny % 5;
        penny -= remainder;
        nickel += (penny / 5);
        penny += remainder;
        penny -= (nickel * 5);

        change.setPennies(penny);
        change.setNickels(nickel);
        change.setDimes(dime);
        change.setQuarters(quarter);

    }

    int getRemainder(int penny, int x) {
        int remainder;
        remainder = penny % x;
        return remainder;
    }

    private boolean checkInventory(int invNum, double money1, Item myItem) {
        if (invNum <= 0) {
            con.print("Sorry this item is out of inventory");
            return false;
        } else {
            return true;
        }
    }
}
