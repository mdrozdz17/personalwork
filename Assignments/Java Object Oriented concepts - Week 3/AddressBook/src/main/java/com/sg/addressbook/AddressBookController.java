/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookController {

    private HashMap<String, Address> addressMap = new HashMap<String, Address>();

    private AddressbookDAO myAddresses = new AddressbookDAO();
    private ConsoleIO con = new ConsoleIO();

    void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            //  myAddresses.decode();
            while (keepGoing) {
                printMenu();
                menuSelection = con.readInt("Please select from the above choices.", 1, 7);

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
                        con.print("Edit an Address");
                        editAddress();
                        break;
                    case 7:
                        con.print("Exit address book");
                        keepGoing = false;
                        break;
                    default:
                        con.print("Unknown Command");

                }

            }

            con.print("Thanks for using my address book");
            myAddresses.encode();
        } catch (FileNotFoundException ex) {
            con.print("Error loading address book.");
        } catch (IOException ex) {
            con.print("Error writing to file");

        }
    }

    private void printMenu() {
        con.print("===================Main Menu===========================");
        con.print("1. Add an Address");
        con.print("2. Delete an Address");
        con.print("3. Find an address by last name");
        con.print("4. Show a count of addresses in address book");
        con.print("5. Show all addresses in address book");
        con.print("6. Edit an Address");
        con.print("7. Exit");
    }

    private void addAddress() {
        Integer addressId = con.readInt("Please enter Address ID");
        String firstName = con.readString("Please enter First Name");
        String lastName = con.readString("Please enter Last Name");
        String Street = con.readString("Please enter Street Name");
        String City = con.readString("Please enter City Name");
        String State = con.readString("Please enter State Name");
        Integer Zip = con.readInt("Please enter Zip Name");
        Address currentAddress = new Address();
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreet(Street);
        currentAddress.setCity(City);
        currentAddress.setState(State);
        currentAddress.setZip(Zip);

        myAddresses.addAddress(addressId, currentAddress);

        con.readString("Address successfully created.  Please hit enter to continue.");
    }

    private void removeAddress() {
        Integer addressId = con.readInt("Please enter the Address ID you would like removed");
        myAddresses.removeAddress(addressId);
        con.readString("Student successfully removed.  Please hit enter to continue.");

    }

    private void addressByLastName() {
        String lastName = con.readString("Please enter the Last Name you would like to search for");
        myAddresses.findByLastName(lastName);
    }

    private void addressCount() {
        Integer[] addressIds = myAddresses.getAddressIDCount();
        int number = addressMap.size();
        con.print("The number of addresses are: " + number);
        
    }
    

    private void addressList() {
        Integer[] addressIds = myAddresses.getAddressIDCount();
        for (Integer addressId : addressIds) {
            Address currentAddress = myAddresses.getAddress(addressId);
            con.print(addressId + " " + currentAddress.getFirstName() + " " + currentAddress.getLastName() + " "
                    + "" + currentAddress.getStreet() + " "
                    + currentAddress.getCity() + "," + currentAddress.getState() + " "
                    + currentAddress.getZip());
        }
        con.readString("Please hit enter to continue.");

    }

    private void editAddress() {
        int addressId = con.readInt("Please enter the ID at the address you would like to edit");
        String Street = con.readString("Please enter the new Street");
        String City = con.readString("Please enter the new City");
        String State = con.readString("Please enter the new State");
        int zip = con.readInt("Please enter the Zip Code");
        
        Address newAddress = new Address();
        newAddress.setStreet(Street);
        newAddress.setCity(City);
        newAddress.setState(State);
        newAddress.setZip(zip);

        myAddresses.addAddress(addressId, newAddress);

        con.readString("Address successfully Updated.  Please hit enter to continue.");

        
        
    }
}
