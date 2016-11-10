/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.model.Address;
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
public class AddressBookController {
    // We need a DAO
    private AddressBookDao dao;
    
    // Annotation-driven constructor injection
    @Inject
    public AddressBookController(AddressBookDao dao){
        this.dao = dao;
    }
    
    // Display new address form - to be used in adding a address
    @RequestMapping(value="displayNewAddressForm", method=RequestMethod.GET)
    public String displayNewAddressForm(Model model) {
        Address address = new Address();
        model.addAttribute("address", address);
        return "displayNewAddressForm";
    }
     
    
    // Add a new address
    @RequestMapping(value="/addNewAddress", method=RequestMethod.POST)
    public String addNewAddress(HttpServletRequest req, @Valid @ModelAttribute("address") Address address, BindingResult result ) {
        // Get the data submitted from the form
      //  String firstName = req.getParameter("firstName");
      //  String lastName = req.getParameter("lastName");
       // String street = req.getParameter("street");
       // String city = req.getParameter("city");
       // String state = req.getParameter("state");
       // String zip = req.getParameter("zip");
        if (result.hasErrors()) {
            return "displayNewAddressForm";
        }

        // Create a new address and set the fields
       // Address addressToAdd = new Address();
      //  addressToAdd.setFirstName(firstName);
      //  addressToAdd.setLastName(lastName);
      //  addressToAdd.setStreet(street);
      //  addressToAdd.setCity(city);
      //  addressToAdd.setState(state);
     //  addressToAdd.setZip(zip);

        // Add the address to the DAO
        dao.addAddress(address);
        
        //Put the address to the model
      
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
    @RequestMapping(value = "loadContacts", method = RequestMethod.POST)
    public String loadContacts() {
        Address a1 = new Address();
        a1.setFirstName("Matt");
        a1.setLastName("Drozdz");
        a1.setStreet("133 Osprey Drive");
        a1.setCity("Portsmouth");
        a1.setState("NH - New Hampshire");
        a1.setZip("03801");

        dao.addAddress(a1);
        
        Address a2 = new Address();
        a2.setFirstName("Jena");
        a2.setLastName("Drozdz");
        a2.setStreet("133 Osprey Drive");
        a2.setCity("Portsmouth");
        a2.setState("NH - New Hampshire");
        a2.setZip("03801");

        dao.addAddress(a2);
        
        Address a3 = new Address();
        a3.setFirstName("William");
        a3.setLastName("Macks");
        a3.setStreet("164 Tuttle Lane");
        a3.setCity("Greenland");
        a3.setState("NH - New Hampshire");
        a3.setZip("03840");

        dao.addAddress(a3);

   
        return "redirect:displayAddressBook";
    }
}