/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class AddressBookDAO {

    public static final String ADDRESS_FILE = "address.txt";
    public static final String DELIMITER = "::";
    private int addressID = 0;
    private ConsoleIO con = new ConsoleIO();

    private HashMap<Integer, Address> addressMap = new HashMap<Integer, Address>();

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

            // Put currentAddress into the map using address ID as the key
            addressMap.put(Integer.parseInt((currentTokens[0])), currentAddress);
        }
    }

    public void encode() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        Set<Integer> keySet = addressMap.keySet();
        for (Integer i : keySet) {

            out.print((addressMap.get(i)).getAddressId());
            out.print(DELIMITER);

            out.print((addressMap.get(i)).getFirstName());
            out.print(DELIMITER);

            out.print((addressMap.get(i)).getLastName());
            out.print(DELIMITER);

            out.print((addressMap.get(i)).getStreet());
            out.print(DELIMITER);

            out.print((addressMap.get(i)).getCity());
            out.print(DELIMITER);

            out.print((addressMap.get(i)).getState());
            out.print(DELIMITER);

            out.print((addressMap.get(i)).getZip() + "\n");

        }
        out.flush();
        out.close();
    }

    public Integer[] getAddressIDCount() {
        Set<Integer> keySet = addressMap.keySet();
        Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;

    }

    public int getAddressCount() {
        return addressMap.size();

    }

    public Address removeAddress(Integer addressId) {
        return addressMap.remove(addressId);
    }

    public Address getAddress(Integer addressId) {
        return addressMap.get(addressId);
    }

    public Address addAddress(Integer addressId, Address address) {

        Address newAddress = new Address();

        return addressMap.put(addressId, address);

    }

    public void findByLastName(String lastName) {
        Set<Integer> keySet = addressMap.keySet();

        for (Integer i : keySet) {

            if ((addressMap.get(i)).getLastName().equals(lastName)) {
                con.print("ID: " + i);
                con.print("Name: " + (addressMap.get(i)).getFirstName() + " "
                        + (addressMap.get(i)).getLastName());
                con.print((addressMap.get(i)).getStreet() + " " + (addressMap.get(i)).getCity()
                        + " " + (addressMap.get(i)).getState() + " " + (addressMap.get(i)).getZip());

            }
        }
    }

    public Address editAddress(Integer addressId, Address address) throws IOException {
        return addressMap.put(addressId, address);

    }
}
