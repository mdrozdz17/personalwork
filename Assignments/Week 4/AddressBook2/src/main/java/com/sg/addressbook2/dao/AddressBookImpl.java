/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook2.dao;

import com.sg.addressbook2.dto.Address;
import com.sg.addressbook2.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookImpl implements AddressBook2Dao {
    

    public static final String ADDRESS_FILE = "address.txt";
    public static final String DELIMITER = "::";
    private int addressID = 0;
    private ConsoleIO con = new ConsoleIO();
    //private List<Address> addresses = null; // maybe i need this

    List<Address> addressBook = new ArrayList<>();

    // private HashMap<Integer, Address> addressMap = new HashMap<Integer, Address>();
    @Override
    public void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Address currentAddress = new Address();
            currentAddress.setAddressId(Integer.parseInt((currentTokens[0])));
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setLastName(currentTokens[2]);
            currentAddress.setStreet(currentTokens[3]);
            currentAddress.setCity(currentTokens[4]);
            currentAddress.setState(currentTokens[5]);
            currentAddress.setZip(currentTokens[6]);

            // Put currentAddress into the ArrayList
            addressBook.add(currentAddress);
        }
    }

    @Override
    public void encode() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE));
            for (Address a: addressBook) {

            out.print(a.getAddressId());
            out.print(DELIMITER);

            out.print(a.getFirstName());
            out.print(DELIMITER);

            out.print(a.getLastName());
            out.print(DELIMITER);

            out.print(a.getStreet());
            out.print(DELIMITER);

            out.print(a.getCity());
            out.print(DELIMITER);

            out.print(a.getState());
            out.print(DELIMITER);

            out.print(a.getZip() + "\n");
            
        }
        out.flush();
        out.close();
    }

    public int getAddressCount() {
        return addressBook.size();

    }

    @Override
    public Address removeAddress(int addressId) {
        return addressBook.remove(addressId);
    }

    @Override
    public List<Address> getAddressId(int addressId) {
        return addressBook
                .stream()
                .filter(id -> id.getAddressId().equals(addressId))
                .collect(Collectors.toList());

    }

    @Override
    public void addAddress(Address address) {
        addressBook.add(address);

    }

    @Override
    public void getAddressByLastName(String lastName) {
        addressBook
                .stream()
                .filter(last -> last.getLastName().equalsIgnoreCase(lastName))
                .forEach((Address a) -> {
                    con.print(a.getFirstName() + " ");
                    con.print(a.getStreet() + " ");
                    con.print(a.getState() + " ");
                    con.print(a.getZip() + " ");
                    con.print("=====================================");

                });

    }

    @Override
    public void getAddressByCity(String city) {

        addressBook
                .stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))//c represents city
                .forEach((Address a) -> {
                    con.print(a.getFirstName() + " ");
                    con.print(a.getLastName() + " ");
                    con.print(a.getStreet() + " ");
                    con.print(a.getState() + " ");
                    con.print(a.getZip() + " ");
                    con.print("=====================================");

                });
    }

    @Override
    public void getAddressByState(String state) {
        addressBook
                .stream()
                .filter(s -> s.getState().equalsIgnoreCase(state))//s represents state
                .forEach((Address a) -> {
                    con.print(a.getFirstName() + " ");
                    con.print(a.getLastName() + " ");
                    con.print(a.getStreet() + " ");
                    con.print(a.getCity() + " ");
                    con.print(a.getZip() + " ");
                    con.print("=====================================");

                });
    }

    @Override
    public void getAddressByZip(String zip) {
        addressBook
                .stream()
                .filter(z -> z.getZip().equalsIgnoreCase(zip)) //z represents zip
                .forEach((Address a) -> {
                    con.print(a.getFirstName() + " ");
                    con.print(a.getLastName() + " ");
                    con.print(a.getStreet() + " ");
                    con.print(a.getState() + " ");
                    con.print("=====================================");

                });
    }

    @Override
    public List<Address> list() {
        return addressBook;

    }

    @Override
    public List<Address> editAddress(Address address) {
        return addressBook;

    }

    @Override
    public void removeAddress(Address testAddress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}

    

