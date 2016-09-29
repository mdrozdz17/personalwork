/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    private Address myAddresses = new Address();
    private ConsoleIO con = new ConsoleIO();
    
    void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            myAddresses.loadAddress();
            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt(Please select from the above choices.
                ", 1, 5")
                
                switch (menuSelection) {
                    case 1:
                        con.print("Add an address");
                        addAddress();
                        break;
                    case 2:
                        con.print("Remove an address");
                        removeAddress();
                        break;
                    case 3:
                        con.print("Find address by last name");
                        addressByLastName();
                        break;
                    case 4:
                        con.print("Return a count of addresses in address book");
                        addressCount();
                        break;
                    case 5:
                        con.print("List all addresses in address book");
                        addressList();
                        break;
                    case 6:
                        con.print("Exit address book");
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Command");
                    
                }
                
            }
            
            con.print("Thanks for using my address book");
            myAddresses.writeAddress();
        } catch (FileNotFoundException ex) {
            con.print("Error loading address book.");
        } catch (IOException ex) {
            con.print("Error writing to file");
            
        }
    }
        
        private void printMenu() {
            con.print("Main Menu");
            con.print("1. Add an Address");
            con.print("2. Delete an Address");
            con.print("3. Find an address by last name");
            con.print("4. Show a count of addresses in address book");
            con.print("5. Show all addresses in address book");
            con.print("6. Exit");
        }

    private void addAddress() {
    }

    private void removeAddress() {
    }

    private void addressByLastName() {
    }

    private void addressCount() {
    }

    private void addressList() {
        String [] addressIds = myAddresses.getAllAddressIds();
        for (int i = 0, i < addressIds.length; i++) {
            Address currentAddress = myAddresses.getAddress(addressIds[i]);
            con.print(addressIds[i] + ": " + currentAddress.getFirstName() +
                    "" + currentAddress.getLastName());
            
        }
    }
        
    }
    

