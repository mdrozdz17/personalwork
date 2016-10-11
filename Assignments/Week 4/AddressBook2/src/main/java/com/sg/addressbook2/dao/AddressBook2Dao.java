/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook2.dao;

import com.sg.addressbook2.dto.Address;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBook2Dao {
    
        public void decode() throws FileNotFoundException;
        public void encode() throws IOException;
        public int getAddressCount();
        public Address removeAddress(int addressId);
        public List<Address> getAddressId(int addressId);
        public void addAddress(Address address);
        public void getAddressByLastName(String lastName);
        public void getAddressByCity(String city);
        public void getAddressByState(String state);
        public void getAddressByZip(String zip);
        public List<Address> list();
        public List<Address> editAddress(Address address);
        public void removeAddress(Address testAddress);
        
        
        

    
}
