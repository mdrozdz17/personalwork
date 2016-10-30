/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryInFileImpl;
import com.sg.dvdlibrary.model.DVD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
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
public class DVDController {
     // We need a DAO
    private DvdLibraryDao dao;
    private DvdLibraryInFileImpl dao1;
    // Annotation-driven constructor injection
    @Inject
    public DVDController(DvdLibraryDao dao) throws FileNotFoundException{
        this.dao = dao;
        

    }
    
    @RequestMapping(value="displayNewDVDForm", method=RequestMethod.GET)
    public String displayNewDVDForm() {
       
        return "displayNewDVDForm";
    }
     
    
    // Add a new DVD
    @RequestMapping(value="/addNewDvd", method=RequestMethod.POST)
    public String addNewDvd(HttpServletRequest req) throws IOException {
        // Get the data submitted from the form
        String title = req.getParameter("title");
        String releaseDate = req.getParameter("releaseDate");
        String mpaaRating = req.getParameter("mpaaRating");
        String directorsName = req.getParameter("directorsName");
        String studio = req.getParameter("studio");
        String userRating = req.getParameter("userRating");
       // String date = req.getParameter("date");



        // Create a new DVD and set the fields
        DVD dvdToAdd = new DVD();
        dvdToAdd.setTitle(title);
        dvdToAdd.setReleaseDate(releaseDate);
        dvdToAdd.setMpaaRating(mpaaRating);
        dvdToAdd.setDirectorsName(directorsName);
        dvdToAdd.setStudio(studio);
        dvdToAdd.setUserRating(userRating);
       // dvdToAdd.setDate(date);


        // Add the DVD to the DAO
        dao.addDVD(dvdToAdd);
        
        return "redirect:displayDVDLibrary";
    }
    
    // Display the Edit form
    // We will get the id from the HttpServletRequest
    // We will get the Contact and put it in the Model
    // We will then display the selected DVD into in the Edit form
    
    @RequestMapping(value="/displayEditDVDForm", method=RequestMethod.GET)
    public String displayEditDVDLibraryForm(HttpServletRequest req, Model model){
        // Get the DVD id
        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        
        // Get the DVD from the Dao
        DVD dvdToEdit = dao.getDVDById(dvdId);
        
        // Put the DVD on the Model
        model.addAttribute("dvd", dvdToEdit);
        
        // Return the logical view
        return "editDVDForm";
    }
    
    // Edit a DVD
    @RequestMapping(value="/editDVD", method=RequestMethod.POST)
    public String editDVD(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result){
        // If there are errors, display the form with those error messages
        if (result.hasErrors()){
            return "editDVDForm";
        }
        // Otherwise...
        // update our DVD in our DAO
        dao.updateDVD(dvd);
        // refresh DVD list
        return "redirect:displayDVDLibrary";
    }
    
    // Delete a DVD
    @RequestMapping(value="/deleteDVD", method=RequestMethod.GET)
    public String deleteDVD(HttpServletRequest req){
       // Get the id of the DVD
       int dvdId = Integer.parseInt(req.getParameter("dvdId"));
       // DAO to delete the DVD
       dao.removeDVD(dvdId);
       // Refresh the DVD list
       return "redirect:displayDVDLibrary";
    }
    
    @RequestMapping(value="/displayDVDLibrary", method=RequestMethod.GET)
    public String displayDVDLibrary(Model model) throws FileNotFoundException{
        // Get all DVD
        List<DVD> allDVD = dao.getAllDVDS();
        // attach the DVD to Model for Spring MVC to pass along to the view
        model.addAttribute("dvdLibrary",allDVD);
         
        // return the logical view
        return "displayDVDLibrary";
    }
}

  