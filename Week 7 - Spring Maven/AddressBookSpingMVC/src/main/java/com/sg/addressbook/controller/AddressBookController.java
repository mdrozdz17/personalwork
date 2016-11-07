/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbookspringmvc.controller;

import com.sg.addressbookspringmvc.dao.AddressBookDao;
import com.sg.addressbookspringmvc.model.Address;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeControllerNoAjax {
    // We need a DAO
    private AddressBookDao dao;
    
    // Annotation-driven constructor injection
    @Inject
    public HomeControllerNoAjax(AddressBookDao dao){
        this.dao = dao;
    }
    
    // Display new address form - to be used in adding a address
    @RequestMapping(value="displayNewAddressForm", method=RequestMethod.GET)
    public String displayNewAddressForm(@Valid @ModelAttribute("address") Address address, BindingResult result) {
       
        return "displayNewAddressForm";
    }
     
    
    // Add a new address
    @RequestMapping(value="/addNewAddress", method=RequestMethod.POST)
    public String addNewAddress(HttpServletRequest req, Model model ) {
        // Get the data submitted from the form
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String street = req.getParameter("street");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");


        // Create a new address and set the fields
        Address addressToAdd = new Address();
        addressToAdd.setFirstName(firstName);
        addressToAdd.setLastName(lastName);
        addressToAdd.setStreet(street);
        addressToAdd.setCity(city);
        addressToAdd.setState(state);
        addressToAdd.setZip(zip);

        // Add the address to the DAO
        dao.addAddress(addressToAdd);
        
        //Put the address to the model
       model.addAttribute("address",addressToAdd);
        // Refresh our address list with the new address
        return "redirect:displayAddressBook";
    }
    
    // Display the Edit form
    // We will get the id from the HttpServletRequest
    // We will get the Contact and put it in the Model
    // We will then display the selected address into in the Edit form
    
    @RequestMapping(value="/displayEditAddressForm", method=RequestMethod.GET)
    public String displayEditAddressForm(HttpServletRequest req, Model model){
        // Get the address id
        int addressId = Integer.parseInt(req.getParameter("addressId"));
        
        // Get the address from the Dao
        Address addressToEdit = dao.getAddressById(addressId);
        
        // Put the address on the Model
        model.addAttribute("address", addressToEdit);
        
        // Return the logical view
        return "editAddressForm";
    }
    
    // Edit a address
    @RequestMapping(value="/editAddress", method=RequestMethod.POST)
    public String editAddress(@Valid @ModelAttribute("address") Address address, BindingResult result){
        // If there are errors, display the form with those error messages
        if (result.hasErrors()){
            return "editAddressForm";
        }
        // Otherwise...
        // update our address in our DAO
        dao.updateAddress(address);
        // refresh address list
        return "redirect:displayAddressBook";
    }
    
    // Delete a address
    @RequestMapping(value="/deleteAddress", method=RequestMethod.GET)
    public String deleteAddress(HttpServletRequest req){
       // Get the id of the address
       int addressId = Integer.parseInt(req.getParameter("addressId"));
       // DAO to delete the address
       dao.removeAddress(addressId);
       // Refresh the address list
       return "redirect:displayAddressBook";
    }
    
    // Display addresss
    
    // The endpoint returns the name of the view
    
    // The RequestMapping, name of method, and view match in this case
    // THIS IS NOT A REQUIREMENT!
    
    // This method takes a Model as a paramter because it will get a list of all 
    // Contact objects from the Dao. We'll put it in a Model to pass on the 
    // view. We will use JSTL to print the address information in the JSP.
    @RequestMapping(value="/displayAddressBook", method=RequestMethod.GET)
    public String displayAddressBook(Model model){
        // Get all address
        List<Address> allAddresses = dao.getAllAddresses();
        // attach the address to Model for Spring MVC to pass along to the view
        model.addAttribute("addressBook",allAddresses);
        // return the logical view
        return "displayAddressBook";
    }
}
