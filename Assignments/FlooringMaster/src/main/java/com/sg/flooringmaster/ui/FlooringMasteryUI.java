/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ui;

import com.sg.flooringmaster.model.Order;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryUI {
        private ConsoleIO con = new ConsoleIO();

    
    public boolean returnToMenu(String returnToMenu) {

        con.print(returnToMenu);
        int choice = con.readInt("", 1, 2);
        return choice != 1;
    }

    public boolean validateOrder(List<Order> search) {

        if (search.isEmpty()) {
            con.print("ORDER DOES NOT EXIST PLEASE TRY AGAIN");
            return false;
        }
        return true;
    }

    public boolean confirmation(String question) {

        con.print(question);
        int choice = con.readInt("", 1, 2);
        return choice != 2;
    }
    
           public void printMenu() {
        con.print("===================Main Menu===========================");
        con.print("1. Display Orders");
        con.print("2. Add Order");
        con.print("3. Edit an Order");
        con.print("4. Remove an Order");
        con.print("5. Save information");
        con.print("6. Exit");
        }
    
}
