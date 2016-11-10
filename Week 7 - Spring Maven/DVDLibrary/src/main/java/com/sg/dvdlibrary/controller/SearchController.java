/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.Rating;
import com.sg.dvdlibrary.dao.SearchTerm;
import com.sg.dvdlibrary.model.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class SearchController {
    private DvdLibraryDao dao;
    
    @Inject
    public SearchController(DvdLibraryDao dao) {
        this.dao=dao;
    }
    
    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String displaySearchPage(Model model) {
        model.addAttribute("mpaaRating", Rating.values());
        return "search";
    }
        
    @RequestMapping(value="search/dvd",method=RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchDVDS(@RequestBody Map<String, String> searchMap) {
        Map<SearchTerm, String> criteriaMap = new HashMap<>();

        String currentTerm = searchMap.get("title");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }

        currentTerm = searchMap.get("releaseDate");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RELEASE_DATE, currentTerm);
        }

        currentTerm = searchMap.get("mpaaRating");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.MPAA_RATING, currentTerm);
        }

        currentTerm = searchMap.get("directorsName");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTORS_NAME, currentTerm);
        }

        currentTerm = searchMap.get("studio");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STUDIO, currentTerm);
        }
        
         currentTerm = searchMap.get("userRating");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.USER_RATING, currentTerm);
        }

        return dao.searchDVD(criteriaMap);
    }
}
    
    
    

