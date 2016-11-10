/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;


import com.sg.addressbook.model.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface AddressBookDao {

    // C - Create
    public Address addAddress(Address address);
    // R - Read - get one object (ID)
    public Address getAddressById(int addressId);
    // R - Read - get by name
    public List<Address> getAllAddressesByName(String searchByName);
    // R - Read - get all objects (All Contacts)
    public List<Address> getAllAddresses();
    // U - Update
    public void updateAddress(Address address);
    // D - Delete
    public void removeAddress(int addressId);
    
    // Search will allow us ot search by any field
    // Our map may look something like this
    // FIRST_NAME = "Eric"
    // LAST_NAME =
    // COMPANY = "TSG"
    // EMAIL 
    // PHONE
    public List<Address> searchAddress(Map<SearchTerm,String> criteria);

}
