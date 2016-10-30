/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistmvc.controller;

import com.sg.contactlistmvc.dao.ContactListDao;
import com.sg.contactlistmvc.model.Contact;
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
    private ContactListDao dao;
    
    // Annotation-driven constructor injection
    @Inject
    public HomeControllerNoAjax(ContactListDao dao){
        this.dao = dao;
    }
    
    // Display new contact form - to be used in adding a contact
    @RequestMapping(value="displayNewContactFormNoAjax", method=RequestMethod.GET)
    public String displayNewContactFormNoAjax() {
        return "displayNewContactFormNoAjax";
    }
    
    // Add a new contact
    @RequestMapping(value="/addNewContactNoAjax", method=RequestMethod.POST)
    public String addNewContactNoAjax(HttpServletRequest req) {
        // Get the data submitted from the form
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String company = req.getParameter("company");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        // Create a new contact and set the fields
        Contact contactToAdd = new Contact();
        contactToAdd.setFirstName(firstName);
        contactToAdd.setLastName(lastName);
        contactToAdd.setCompany(company);
        contactToAdd.setEmail(email);
        contactToAdd.setPhone(phone);
        // Add the contact to the DAO
        dao.addContact(contactToAdd);
        // Refresh our contact list with the new contact
        return "redirect:displayContactListNoAjax";
    }
    
    // Display the Edit form
    // We will get the id from the HttpServletRequest
    // We will get the Contact and put it in the Model
    // We will then display the selected contacts into in the Edit form
    
    @RequestMapping(value="/displayEditContactFormNoAjax", method=RequestMethod.GET)
    public String displayEditContactFormNoAjax(HttpServletRequest req, Model model){
        // Get the contact id
        int contactId = Integer.parseInt(req.getParameter("contactId"));
        
        // Get the contact from the Dao
        Contact contactToEdit = dao.getContactById(contactId);
        
        // Put the contact on the Model
        model.addAttribute("contact", contactToEdit);
        
        // Return the logical view
        return "editContactFormNoAjax";
    }
    
    // Edit a contact
    @RequestMapping(value="/editContactNoAjax", method=RequestMethod.POST)
    public String editContactNoAjax(@Valid @ModelAttribute("contact") Contact contact, BindingResult result){
        // If there are errors, display the form with those error messages
        if (result.hasErrors()){
            return "editContactFormNoAjax";
        }
        // Otherwise...
        // update our contact in our DAO
        dao.updateContact(contact);
        // refresh contact list
        return "redirect:displayContactListNoAjax";
    }
    
    // Delete a contact
    @RequestMapping(value="/deleteContactNoAjax", method=RequestMethod.GET)
    public String deleteContactNoAjax(HttpServletRequest req){
       // Get the id of the contact
       int contactId = Integer.parseInt(req.getParameter("contactId"));
       // DAO to delete the contact
       dao.removeContact(contactId);
       // Refresh the contact list
       return "redirect:displayContactListNoAjax";
    }
    
    // Display contacts
    
    // The endpoint returns the name of the view
    
    // The RequestMapping, name of method, and view match in this case
    // THIS IS NOT A REQUIREMENT!
    
    // This method takes a Model as a paramter because it will get a list of all 
    // Contact objects from the Dao. We'll put it in a Model to pass on the 
    // view. We will use JSTL to print the contact information in the JSP.
    @RequestMapping(value="/displayContactListNoAjax", method=RequestMethod.GET)
    public String displayContactListNoAjax(Model model){
        // Get all contacts
        List<Contact> allContacts = dao.getAllContacts();
        // attach the contacts to Model for Spring MVC to pass along to the view
        model.addAttribute("contactList",allContacts);
        // return the logical view
        return "displayContactListNoAjax";
    }
}
