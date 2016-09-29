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
public class AddressbookDAO {

    public static final String ADDRESS_FILE = "address.txt";
    public static final String DELIMITER = "::";

    private HashMap<String, Address> addresses = new HashMap<>();

    public void loadAddresses() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Address currentAddress = new Address(currentTokens[0]);
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreet(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            // currentAddress.setZip(currentTokens[5]);
            currentAddress.setAddressId(currentTokens[6]);

        }
        sc.close();

    }

    public void writeRoster() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE));
 String [] keys = this.getAllAddressIds(); //method call from controller
    }
    
     public String[] getAllAddressIds() {
        // return a String array containing all of the keys from our student map
        // NOTE FOR APPRENTICES: We have to specify that this is Set of String.
        // This is necessary because we said above that all keys in our map must
        // be Strings.
        Set<String> keySet = addresses.keySet();
        // NOTE TO APPRENTICES: In order to return a String array of the keys
        // in the keySet, we must create an array big enough to hold all the
        // keys and then pass it into toArray.  toArray will then fill the
        // array up and return it to us.  We then just return it to the code that
        // called us.
        String[] keyArray = new String[keySet.size()];
        keyArray =  keySet.toArray(keyArray);
        return keyArray;

}
}
