package com.sg.vendingmachine1.ops;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sg.vendingmachine.model.Change;
import com.sg.vendingmachine.model.Item;
import com.sg.vendingmachine1.dao.ItemDao;
import com.sg.vendingmachine1.ui.ConsoleIO;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ItemController {
 DecimalFormat d = new DecimalFormat("0.00");
  DecimalFormat df = new DecimalFormat("0");

    private ConsoleIO io = new ConsoleIO();

    private ItemDao itemDao = new ItemDao("inventory.txt");

    Change change = new Change();

    double money;

    double roundedMoney;

    boolean playAgain = true;

    public void run() {

        printMenu();
        io.print("");

        while (playAgain) {

            roundedMoney = change.getAmount();
            io.print("You have " + df.format(change.getQuarters()) + " quarters available");
            io.print("You have " + df.format(change.getDimes()) + " dimes available");
            io.print("You have " + df.format(change.getNickels()) + " nickels available");
            io.print("You have " + df.format(change.getPennies()) + " pennies available");
            io.print("Total money: $" + d.format(roundedMoney));
            io.print("");

            int quit = io.readInt("Press 0 to quit, press 1 to continue", 0, 1);

            if (quit == 0) {
                playAgain = false;
                io.print("Thanks for visiting my Vending Machine");
            } else {
                continuePurchase();
            }
        }
    }

    void continuePurchase() {

        io.print("");
        double newMoney = io.readDouble("How much money would you like to add?");

        io.print("");
        printMenu();
        io.print("");

        money = change.getAmount();

        money += newMoney;

        change.setAmount(money);
        
        io.print("You have " + (d.format((change.getAmount()))) + " available");
        io.print("");

        io.print("Enter the number for the item you would like to purchase");
        int choice = io.readInt("", 1, 6);
        
        Item item = itemDao.read(choice);
        
        double cost =item.getCost();

        if (money >= cost) {

            buyItem(choice);

        } else {
            io.print("");
            io.print("Insufficient funds");
            io.print("");
            
            int yn = io.readInt("Add money? (1 for y, 2 for n)", 1, 2);

            if (yn == 2) {
                playAgain = false;
                io.print("Thanks for visting my Vending Machine");
            }

        }
    }

    private void printMenu() {

        List<Item> items = itemDao.list();
        for (Item i : items) {

            double cost = i.getCost();
            String name = i.getName();
            int id = i.getItemId();

            io.print("+--Item--------Cost----+");
            io.print(" " + id + " " + name + "----- " + cost);

        }
    }

    private void buyItem(int id) {

        Item item = itemDao.read(id);

        double cost = item.getCost();

        double money = change.getAmount();

        int invNum = item.getNumInInventory();

        boolean yesOrNo = checkInventory(invNum, money, item);

        if (yesOrNo == true) {

            money -= cost;

            double pennies = money * 100;

            calculateChange(pennies);

            change.setAmount(money);
            item.setNumInInventory(invNum - 1);
            itemDao.update(item);

        } else {
            calculateChange(money * 100);
            change.setAmount(money);
        }
    }

    private void calculateChange(double pennies) {

        int penny = (int) pennies;
        int nickel = 0;
        int dime = 0;
        int quarter = 0;
        int remainder = 0;

        remainder = penny % 25;
        penny -= remainder;
        quarter += (penny / 25);
        penny += remainder;
        penny -= (25 * quarter);

        remainder = penny % 10;
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

    private boolean checkInventory(int invNum, double money1, Item item) {
        if (invNum <= 0) {
            io.print("Sorry this item is out of inventory");
            io.print("");
            return false;
        } else {
            return true;
        }
    }

}
    

