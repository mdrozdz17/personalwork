/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.dao;

import com.sg.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

/**
 *
 * @author apprentice
 */
public class ContactListDaoInMemImpl implements ContactListDao {

    private Map<Integer, Contact> contactMap = new HashMap<>();

    // We need to track our IDs. This will simulate auto-incrementing.
    private static int countactIdCounter = 0;

    @Override
    public Contact addContact(Contact contact) {
        // We need to keep track of the ID manually right now
        // In our DB implementation, the database will assign the ID
        contact.setContactId(countactIdCounter);
        // Once we assign the ID, we need to increment the counter for thext contact
        countactIdCounter++;
        // add our contact to the map
        contactMap.put(contact.getContactId(), contact);
        // We need to return the countact per the interface
        return contact;
    }

    @Override
    public Contact getContactById(int contactId) {
        // Get the contact from the Hashmap which uses the ID as it's key
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> getAllContactsByName(String searchByName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> getAllContacts() {
        // We want all of our contacts, but do we really need the hashmap
        // Not really - we just need the list of contacts
        // The ID is still on the Contact object, so values() would have what we need
        List<Contact> allContacts = new ArrayList<>(contactMap.values());
        return allContacts;
    }

    @Override
    public void updateContact(Contact contact) {
        // Updating a record on a hashmap is as simple as put with the Key and Value
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public void removeContact(int contactId) {
        // remove the contact from the hashmap
        contactMap.remove(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        // Get all the things we're searching fro into individual variables
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String companyCriteria = criteria.get(SearchTerm.COMPANY);
        String phoneCriteria = criteria.get(SearchTerm.PHONE);
        String emailCriteria = criteria.get(SearchTerm.EMAIL);

        // Declare predicate conditions - to be used by our filters
        Predicate<Contact> firstNameMatches;
        Predicate<Contact> lastNameMatches;
        Predicate<Contact> companyMatches;
        Predicate<Contact> phoneMatches;
        Predicate<Contact> emailMatches;

        // Default Predicate
        Predicate<Contact> truePredicate = (c) -> {return true; };
        
        // Assign values to predicates
        // If a given search term is empty, assign the default Predicate
        // Otherwise, assign the predicate that filters for that term
        
        // ? expression = ternary expression
        // boolean expression ? false true : false value
        // (Do we have nothing in first name criteria? Use default: Filter on firstNameCriteria
        firstNameMatches = (firstNameCriteria == null || firstNameCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getFirstName().equalsIgnoreCase(firstNameCriteria);
        
         lastNameMatches = (lastNameCriteria == null || lastNameCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getLastName().equalsIgnoreCase(lastNameCriteria);
         
         
         companyMatches = (companyCriteria == null || companyCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getCompany().equalsIgnoreCase(companyCriteria);
         
         
         phoneMatches = (phoneCriteria == null || phoneCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getPhone().equalsIgnoreCase(phoneCriteria);
         
         
         emailMatches = (emailCriteria == null || emailCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getEmail().equalsIgnoreCase(emailCriteria);
         
         // Return the list of contacts that match the given criteria 
         // We will filters and join them with AND
         return contactMap.values().stream()
                 .filter(firstNameMatches
                 .and(lastNameMatches)
                 .and(companyMatches)
                 .and(phoneMatches)
                 .and(emailMatches))
                 .collect(Collectors.toList());
    }

}
