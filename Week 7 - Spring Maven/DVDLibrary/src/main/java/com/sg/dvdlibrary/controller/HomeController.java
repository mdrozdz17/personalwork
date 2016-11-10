/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.Rating;
import com.sg.dvdlibrary.model.DVD;
import java.util.List;
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
        // Our DAO for the controller - will be wired up for dependency injection
    private DvdLibraryDao dao;

    @Inject
    public HomeController(DvdLibraryDao dao) {
        this.dao = dao;
    }
    
     @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        model.addAttribute("mpaaRating", Rating.values());
        return "home";
    }

// - Retrieve a dvd (GET)
//        - /dvd/{dvdId}
//        - Response Body: DVD in JSON  
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DVD getDVD(@PathVariable("id") int id) {
        return dao.getDVDById(id);
    }

//- Create a Dvd (POST)
//      - /contact
//       - RequestBody - JSON object of our Contact
    // - ResponseBody - JSON object of our Contact
    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DVD createDVD(@Valid @RequestBody DVD dvd) {
        dao.addDVD(dvd);
        return dvd;
    }

//- Delete a DVD (DELETE)
//        - dvd/{dvdId}
//        - Note: No RequestBody, no ResponseBody
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable("id") int id) {
        dao.removeDVD(id);
    }

//- Update a DVD (PUT)
//        - dvd/{dvdId}
//        - RequestBody: JSON object of our Contact, with the contactId
    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDVD(@PathVariable("id") int id, @Valid @RequestBody DVD dvd) {
        dvd.setDvdId(id);
        dao.updateDVD(dvd);
    }
    
//- Retrieve ALL contacts (GET)
//        - /dvd
//        -ResponseBody: Array of Contacts, in JSON form
    @RequestMapping(value="/dvd", method=RequestMethod.GET)
    @ResponseBody public List<DVD> getAllDVDS(){
        return dao.getAllDVDS();
    }

}
  

