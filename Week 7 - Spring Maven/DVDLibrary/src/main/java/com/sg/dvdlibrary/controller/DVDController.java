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
    public DVDController(DvdLibraryDao dao) throws FileNotFoundException {
        this.dao = dao;

    }

    // Display New DVD Form
    @RequestMapping(value = "displayNewDVDForm", method = RequestMethod.GET)
    public String displayNewDVDForm(Model model) {
        DVD dvd = new DVD();
        model.addAttribute("dvd", dvd);

        return "displayNewDVDForm";
    }

    // Add a new DVD Form
    @RequestMapping(value = "/addNewDvd", method = RequestMethod.POST)
    public String addNewDvd(HttpServletRequest req, @Valid @ModelAttribute("dvd") DVD dvd, BindingResult result) throws IOException {

        // Get the data submitted from the form
        //  String title = req.getParameter("title");
        // String releaseDate = req.getParameter("releaseDate");
        //  String mpaaRating = req.getParameter("mpaaRating");
        //   String directorsName = req.getParameter("directorsName");
        //   String studio = req.getParameter("studio");
        //    String userRating = req.getParameter("userRating");
        // String date = req.getParameter("date");
        if (result.hasErrors()) {
            return "displayNewDVDForm";

            // Create a new DVD and set the fields
            //  DVD dvdToAdd = new DVD();
            //  dvdToAdd.setTitle(title);
            //  dvdToAdd.setReleaseDate(releaseDate);
            //  dvdToAdd.setMpaaRating(mpaaRating);
            //  dvdToAdd.setDirectorsName(directorsName);
            //  dvdToAdd.setStudio(studio);
            //   dvdToAdd.setUserRating(userRating);
            // dvdToAdd.setDate(date);
            // Add the DVD to the DAO
        }
        dao.addDVD(dvd);

        return "redirect:displayDVDLibrary";
    }

    // EditDVDForm
    @RequestMapping(value = "/displayEditDVDForm", method = RequestMethod.GET)
    public String displayEditDVDLibraryForm(HttpServletRequest req, Model model) {
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
    @RequestMapping(value = "/editDVD", method = RequestMethod.POST)
    public String editDVD(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result) {
        // If there are errors, display the form with those error messages
        if (result.hasErrors()) {
            return "editDVDForm";
        }
        // Otherwise...
        // update our DVD in our DAO
        dao.updateDVD(dvd);
        // refresh DVD list
        return "redirect:displayDVDLibrary";
    }

    // Delete a DVD
    @RequestMapping(value = "/deleteDVD", method = RequestMethod.GET)
    public String deleteDVD(HttpServletRequest req) {
        // Get the id of the DVD
        int dvdId = Integer.parseInt(req.getParameter("dvdId"));
        // DAO to delete the DVD
        dao.removeDVD(dvdId);
        // Refresh the DVD list
        return "redirect:displayDVDLibrary";
    }

    @RequestMapping(value = "/displayDVDLibrary", method = RequestMethod.GET)
    public String displayDVDLibrary(Model model) throws FileNotFoundException {
        // Get all DVD
        List<DVD> allDVD = dao.getAllDVDS();
        // attach the DVD to Model for Spring MVC to pass along to the view
        model.addAttribute("dvdLibrary", allDVD);

        // return the logical view
        return "displayDVDLibrary";
    }
    
       // Purely for testing purposes
    @RequestMapping(value = "loadDVDS", method = RequestMethod.POST)
    public String loadDVDS() {
        DVD dvd1 = new DVD();
        dvd1.setTitle("Space Jam");
        dvd1.setReleaseDate("1996");
        dvd1.setMpaaRating("PG");
        dvd1.setDirectorsName("Joe Pytka");
        dvd1.setStudio("Warner Bros");
        dvd1.setUserRating("7/10");

        dao.addDVD(dvd1);
        
          DVD dvd2 = new DVD();
        dvd2.setTitle("Rush Hour");
        dvd2.setReleaseDate("1998");
        dvd2.setMpaaRating("PG-13");
        dvd2.setDirectorsName("Brett Ratner");
        dvd2.setStudio("New Line Cinema");
        dvd2.setUserRating("8/10");

        dao.addDVD(dvd2);
        
             DVD dvd3 = new DVD();
        dvd3.setTitle("Rush Hour 2");
        dvd3.setReleaseDate("2001");
        dvd3.setMpaaRating("PG-13");
        dvd3.setDirectorsName("Brett Ratner");
        dvd3.setStudio("New Line Cinema");
        dvd3.setUserRating("9/10");

        dao.addDVD(dvd3);
        
            DVD dvd4 = new DVD();
        dvd4.setTitle("Home Alone");
        dvd4.setReleaseDate("1991");
        dvd4.setMpaaRating("PG");
        dvd4.setDirectorsName("Chris Columbus");
        dvd4.setStudio("Hughes Entertainment");
        dvd4.setUserRating("8/10");

        dao.addDVD(dvd4);

        


        return "redirect:displayDVDLibrary";
    }

}
