/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookspringmvc.dao;


import com.sg.addressbookspringmvc.model.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoInMemImpl implements AddressBookDao {

    private Map<Integer, Address> addressMap = new HashMap<>();

    // We need to track our IDs. This will simulate auto-incrementing.
    private static int addressIdCounter = 0;

    @Override
    public Address addAddress(Address address) {
        // We need to keep track of the ID manually right now
        // In our DB implementation, the database will assign the ID
        address.setAddressId(addressIdCounter);
        // Once we assign the ID, we need to increment the counter for thext contact
        addressIdCounter++;
        // add our contact to the map
        addressMap.put(address.getAddressId(), address);
        // We need to return the countact per the interface
        return address;
    }

    @Override
    public Address getAddressById(int addressId) {
        // Get the contact from the Hashmap which uses the ID as it's key
        return addressMap.get(addressId);
    }

    @Override
    public List<Address> getAllAddressesByName(String searchByName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAllAddresses() {
        // We want all of our contacts, but do we really need the hashmap
        // Not really - we just need the list of contacts
        // The ID is still on the Address object, so values() would have what we need
        List<Address> allAddresss = new ArrayList<>(addressMap.values());
        return allAddresss;
    }

    @Override
    public void updateAddress(Address address) {
        // Updating a record on a hashmap is as simple as put with the Key and Value
        addressMap.put(address.getAddressId(), address);
    }

    @Override
    public void removeAddress(int addressId) {
        // remove the contact from the hashmap
        addressMap.remove(addressId);
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
        // Get all the things we're searching fro into individual variables
        String firstNameCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameCriteria = criteria.get(SearchTerm.LAST_NAME);
        String streetCriteria = criteria.get(SearchTerm.STREET);
        String cityCriteria = criteria.get(SearchTerm.CITY);
        String stateCriteria = criteria.get(SearchTerm.STATE);
        String zipCriteria = criteria.get(SearchTerm.ZIP);


        // Declare predicate conditions - to be used by our filters
        Predicate<Address> firstNameMatches;
        Predicate<Address> lastNameMatches;
        Predicate<Address> streetMatches;
        Predicate<Address> cityMatches;
        Predicate<Address> stateMatches;
        Predicate<Address> zipMatches;


        // Default Predicate
        Predicate<Address> truePredicate = (c) -> {return true; };
        
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
         
         
         streetMatches = (streetCriteria == null || streetCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getStreet().equalsIgnoreCase(streetCriteria);
         
         
         cityMatches = (cityCriteria == null || cityCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getCity().equalsIgnoreCase(cityCriteria);
         
         
         stateMatches = (stateCriteria == null || stateCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getState().equalsIgnoreCase(stateCriteria);
         
             zipMatches = (zipCriteria == null || zipCriteria.isEmpty()) ?
                truePredicate
                : (c) -> c.getZip().equalsIgnoreCase(zipCriteria);
         
         // Return the list of contacts that match the given criteria 
         // We will filters and join them with AND
         return addressMap.values().stream()
                 .filter(firstNameMatches
                 .and(lastNameMatches)
                 .and(streetMatches)
                 .and(cityMatches)
                 .and(stateMatches)
                 .and(zipMatches))
                 .collect(Collectors.toList());
    }
}

  