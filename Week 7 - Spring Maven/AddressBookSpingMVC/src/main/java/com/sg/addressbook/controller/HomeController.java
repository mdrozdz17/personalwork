/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.controller;

import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.State;
import com.sg.addressbook.model.Address;
import java.util.List;
import javafx.scene.input.TouchPoint;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeController {
        private AddressBookDao dao;

    @Inject
    public HomeController(AddressBookDao dao) {
        this.dao = dao;
    }
   
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHomePage(Model model){
       // model.addAttribute("state", State.values());
        model.addAttribute("state",State.values());
        return "home";
    }
    // - Retrieve a contact (GET)
//        - /contact/{contactId}
//        - Response Body: Contact in JSON  
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Address getContact(@PathVariable("id") int id) {
        return dao.getAddressById(id);
    }

//- Create a contact (POST)
//      - /contact
//       - RequestBody - JSON object of our Contact
    // - ResponseBody - JSON object of our Contact
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Address createContact(@Valid @RequestBody Address address) {
        dao.addAddress(address);
        return address;
    }

//- Delete a contact (DELETE)
//        - contact/{contactId}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") int id) {
        dao.removeAddress(id);
    }

//- Update a contact (PUT)
//        - contact/{contactId}
//        - RequestBody: JSON object of our Contact, with the contactId
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putContact(@PathVariable("id") int id, @Valid @RequestBody Address address) {
        address.setAddressId(id);
        dao.updateAddress(address);
    }
    
//- Retrieve ALL contacts (GET)
//        - /Contacts
//        -ResponseBody: Array of Contacts, in JSON form
    @RequestMapping(value="/contacts", method=RequestMethod.GET)
    @ResponseBody public List<Address> getAllContacts(){
        return dao.getAllAddresses();
    }

}

