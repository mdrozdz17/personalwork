/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface ContactListDao {

    // C - Create
    public Contact addContact(Contact contact);
    // R - Read - get one object (ID)
    public Contact getContactById(int contactId);
    // R - Read - get by name
    public List<Contact> getAllContactsByName(String searchByName);
    // R - Read - get all objects (All Contacts)
    public List<Contact> getAllContacts();
    // U - Update
    public void updateContact(Contact contact);
    // D - Delete
    public void removeContact(int contactId);
    
    // Search will allow us ot search by any field
    // Our map may look something like this
    // FIRST_NAME = "Eric"
    // LAST_NAME =
    // COMPANY = "TSG"
    // EMAIL 
    // PHONE
    public List<Contact> searchContacts(Map<SearchTerm,String> criteria);

}
