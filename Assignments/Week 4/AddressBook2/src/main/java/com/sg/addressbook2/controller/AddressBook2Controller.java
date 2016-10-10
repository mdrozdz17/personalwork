/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook2.controller;

import com.sg.addressbook2.ui.ConsoleIO;
import com.sg.addressbook2.dao.AddressBook2DAO;
import com.sg.addressbook2.dto.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBook2Controller {

    private HashMap<Integer, Address> addressMap = new HashMap<Integer, Address>();

    private AddressBook2DAO myAddresses = new AddressBook2DAO();
    private ConsoleIO con = new ConsoleIO();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            myAddresses.decode();
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
                        removeAddressId();
                        break;
                    case 3:
                        con.print("Find address by Field");
                        findAddressByField();
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
        con.print("3. Find an address by Field");
        con.print("4. Show a count of addresses in address book");
        con.print("5. Show all addresses in address book");
        con.print("6. Edit an Address");
        con.print("7. Exit");
    }

    private void addAddress() { // This works
        Integer addressId = con.readInt("Please enter Address ID");
        String firstName = con.readString("Please enter First Name");
        String lastName = con.readString("Please enter Last Name");
        String Street = con.readString("Please enter Street Name");
        String City = con.readString("Please enter City Name");
        String State = con.readString("Please enter State Name");
        String Zip = con.readString("Please enter Zip Name");
        Address currentAddress = new Address();
        currentAddress.setAddressId(addressId);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreet(Street);
        currentAddress.setCity(City);
        currentAddress.setState(State);
        currentAddress.setZip(Zip);

        myAddresses.addAddress(currentAddress);

        con.readString("Address successfully created.  Please hit enter to continue.");
    }

    private void removeAddressId() { //This works
        Integer addressId = con.readInt("Please enter the Address ID you would like removed");
       // Address address = new Address();
        myAddresses.removeAddress(addressId);
        con.readString("Address successfully removed.  Please hit enter to continue.");

    }

    private void findAddressByField() { // This works
        int menuSelection = 0;

        printSearchMenu();
        menuSelection = con.readInt("Please select from the above choices.", 1, 6);

        switch (menuSelection) {

            case 1:
                String lastName = con.readString("Please enter the last name you would like to search for");
                myAddresses.getAddressByLastName(lastName);
                break;
            case 2:
                String city = con.readString("Please enter the City you would like to search for");
                myAddresses.getAddressByCity(city);
                break;
            case 3:
                String state = con.readString("Please enter the State you would like to search for");
                myAddresses.getAddressByState(state);
                break;
            case 4:
                String zip = con.readString("Please enter the Zip Code you would like to search for");
                myAddresses.getAddressByZip(zip);
                break;
            default:
                con.print("Unknown Command");

        }
    }

    private void addressByCity() {
        String city = con.readString("Please enter the City you would like to search for");
       // List<Address> addresses = myAddresses.list();
        myAddresses.getAddressByCity(city);

    }

    private void addressByState() {
        String state = con.readString("Please enter the State you would like to search for");
        myAddresses.getAddressByState(state);
    }

    private void addressByZip() {
        String zip = con.readString("Please enter the Zip Code you would like to search for");
        myAddresses.getAddressByZip(zip);
    }

    private void addressCount() {
        int number = myAddresses.getAddressCount();
        con.print("The number of addresses are: " + number);

    }

    private void addressList() {
        List<Address> addresses = myAddresses.list();

        for (Address a : addresses) {
            con.print(a.getFirstName() + " ");
            con.print(a.getLastName() + " ");
            con.print(a.getStreet() + " ");
            con.print(a.getState() + " ");
            con.print(a.getCity() + " ");
            con.print(a.getZip()  + " ");
            con.print("=====================================");

        }
    }

    private void editAddress() throws IOException {
        int addressId = con.readInt("Please enter the ID at the address you would like to edit");
        String firstName = con.readString("Please enter First Name");
        String lastName = con.readString("Please enter Last Name");
        String Street = con.readString("Please enter Street Name");
        String City = con.readString("Please enter City Name");
        String State = con.readString("Please enter State Name");
        String Zip = con.readString("Please enter Zip Name");
        Address currentAddress = new Address();
        currentAddress.setAddressId(addressId);
        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setStreet(Street);
        currentAddress.setCity(City);
        currentAddress.setState(State);
        currentAddress.setZip(Zip);

        myAddresses.editAddress(currentAddress);
        con.readString("The address with id " + addressId + " has been changed. Please hit enter to continue.");
    }

    private void printSearchMenu() {
        con.print("Please choose what field you would like to search by");
        con.print("1. Last Name");
        con.print("2. City");
        con.print("3. State");
        con.print("4. Zip Code");
    }
}
