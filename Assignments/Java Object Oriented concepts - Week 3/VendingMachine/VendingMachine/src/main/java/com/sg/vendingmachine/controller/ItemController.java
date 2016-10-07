/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;
import com.sg.vendingmachine.DAO.ItemDao;
import com.sg.vendingmachine.Ops.Change;
import com.sg.vendingmachine.model.Item;
import com.sg.vendingmachine.ui.ConsoleIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author apprentice
 */
public class ItemController {

    private ItemDao itemDao;
    private ConsoleIO io = new ConsoleIO();

    Change change = new Change();

    double money;

    double roundedMoney;

    boolean playAgain = true;

    public ItemController() {
        this.itemDao = new ItemDao();
    }


    public void run() throws IOException {

        printMenu();
        while (playAgain) {

            roundedMoney = Math.round(change.getAmount() * 100D) / 100D;
            io.print("You have " + change.getQuarters() + " quarters available");
            io.print("You have " + change.getDimes() + " dimes available");
            io.print("You have " + change.getNickels() + " nickels available");
            io.print("You have " + change.getPennies() + " pennies available");
            io.print("Total money: " + roundedMoney);
            io.print("");

            int quit = io.readInt("Press 0 to quit, press 1 to continue", 0,1);

            if (quit == 0) {
                playAgain = false;
            } else {
                continuePurchase();
            }
        }
    }

    void continuePurchase() throws IOException {

        double newMoney = io.readDouble("How much money would you like to add?");

        
        printMenu();
        

        getAndSetAmount(newMoney);
        
        io.print("You have " + (Math.round(change.getAmount() * 100D) / 100D) + " available");
        io.print("");

        io.print("Enter the number for the item you would like to purchase");
        int choice = io.readInt("", 5, 1);
        
        buyOrDeny(choice);
    }

    void buyOrDeny(int choice) throws IOException {
        Item item = itemDao.read(choice);
        
        double cost =item.getCost();

        if (money >= cost) {

            buyItem(choice);

        } else {
            addOrLeave();

        }
    }

    void addOrLeave() {
       
        io.print("Insufficient funds");
        
        
        int yn = io.readInt("Add money? (1 for y, 2 for n)", 2, 1);
        
        if (yn == 2) {
            playAgain = false;
        }
    }

    void getAndSetAmount(double newMoney) {
        money = change.getAmount();
        
        money += newMoney;
        
        change.setAmount(money);
    }

    private void printMenu() {

        List<Item> items = itemDao.list();
        for (Item i : items) {

            double cost = i.getCost();
            String name = i.getName();
            int id = i.getId();

            io.print("ID----+--Item--------Cost----+");
            io.print(" " + id + " " + name + "----- " + cost);

        }
    }

    private void buyItem(int id) throws IOException {

        Item item = itemDao.read(id);

        double cost = item.getCost();

        double money = change.getAmount();

        int invNum = item.getNumInInventory();

        boolean yesOrNo = checkInventory(invNum, money, item);

        if (yesOrNo == true) {

            updateItemInfo(money, cost, item, invNum);

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
        itemDao.update(item);
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

    private boolean checkInventory(int invNum, double money1, Item item) {
        if (invNum <= 0) {
            io.print("Sorry this item is out of inventory");
            io.print1("");
            return false;
        } else {
            return true;
        }
    }

}