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
    private int addressID = 0;
    private ConsoleIO con = new ConsoleIO();

    private HashMap<Integer, Address> addressMap = new HashMap<Integer, Address>();

    public AddressbookDAO() {
   
    }

    public void decode() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
                    
            Address currentAddress = new Address();
            
            currentAddress.setAddressId(Integer.parseInt((currentTokens[0])));
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreet(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZip(Integer.parseInt((currentTokens[5])));

            
           // Put currentAddress into the map using address ID as the key
            addressMap.put(currentAddress.getAddressId(), currentAddress);  
        }
        sc.close();

    }


    public void encode() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        Integer[] keys = this.getAddressIDCount(); //method call from controller
        for (Integer key : keys) {
            Address currentAddress = this.getAddress(key);
            out.println(currentAddress.getAddressId() + DELIMITER
                    + currentAddress.getFirstName() + DELIMITER
                    + currentAddress.getLastName() + DELIMITER
                    + currentAddress.getCity() + DELIMITER
                    + currentAddress.getState() + DELIMITER
                    + currentAddress.getZip());
        }
                // force PrintWriter to write line to the file
            out.flush();
        
        // Clean up 
        out.close();
    }
        
    

    public Integer[] getAddressIDCount() {
        // return a String array containing all of the keys from our student map
        // NOTE FOR APPRENTICES: We have to specify that this is Set of String.
        // This is necessary because we said above that all keys in our map must
        // be Strings.
        Set<Integer> keySet = addressMap.keySet();
        // NOTE TO APPRENTICES: In order to return a String array of the keys
        // in the keySet, we must create an array big enough to hold all the
        // keys and then pass it into toArray.  toArray will then fill the
        // array up and return it to us.  We then just return it to the code that
        // called us.
       Integer[] keyArray = new Integer[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray; 

    }

   // In the controller we have a removeAddress method that calls this method
   // below to remove the Address when the user types in the last name
    public Address removeAddress(Integer addressId) {
        return addressMap.remove(addressId);
    }

    public Address getAddress(Integer addressId) {
        // NOTE FOR APPRENTICES: In this method we simply ask the Address map for
        // the Address associated with the given id and then return it.  No
        // more work than that is necessary.
        return addressMap.get(addressId);
    }

    public Address addAddress(Integer addressId, Address address) {

        Address newAddress = new Address();
        
        return addressMap.put(addressId, address);

      
    }

    public void findByLastName(String lastName) {
        Set<Integer> keySet = addressMap.keySet();
        
        for (Integer i: keySet) {
            
            if ((addressMap.get(i)).getLastName().equals(lastName)){
                con.print("ID: " + i);
                con.print("Name: " + (addressMap.get(i)).getFirstName() + " " +
                (addressMap.get(i)).getLastName());
                con.print((addressMap.get(i)).getStreet() + " " + (addressMap.get(i)).getCity()
                + " " + (addressMap.get(i)).getState()+ " " + (addressMap.get(i)).getZip());
                
                        
            }
        }
        
    }
    
    public String editAddress (Integer addressId, String address) throws IOException {
        
        String firstName = (addressMap.get(addressId)).getFirstName();
        String lastName = (addressMap.get(addressId)).getLastName();
        String street = (addressMap.get(addressId)).getStreet();
        String city = (addressMap.get(addressId)).getCity();
        String state = (addressMap.get(addressId)).getState();
        Integer zip = (addressMap.get(addressId)).getZip();

        
        Set<Integer> keySet = addressMap.keySet();
        
        for (Integer i : keySet){
            
            if (i == addressId)  {
                
                Address newAddress = new Address();
                newAddress.setFirstName(firstName);
                newAddress.setLastName(lastName);
                newAddress.setStreet(street);
                newAddress.setCity(city);
                newAddress.setState(state);
                newAddress.setZip(zip);

                addressMap.put(addressId, newAddress);
            }
        }
        encode();
        return (addressMap.get(addressId)).getStreet() + (addressMap.get(addressId)).getCity()
        + (addressMap.get(addressId)).getState();       

    }

}

