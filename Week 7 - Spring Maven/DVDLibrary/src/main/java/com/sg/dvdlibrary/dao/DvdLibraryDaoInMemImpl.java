/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.DVD;
import com.sg.dvdlibrary.model.DVDTitleCount;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class DvdLibraryDaoInMemImpl implements DvdLibraryDao {

    private Map<Integer, DVD> dvdMap = new HashMap<>();
    private static int dvdIdCounter = 0;

    @Override
    public DVD addDVD(DVD dvd) {
        // We need to keep track of the ID manually right now
        // In our DB implementation, the database will assign the ID
        dvd.setDvdId(dvdIdCounter);
        // Once we assign the ID, we need to increment the counter for the next dvd
        dvdIdCounter++;
        // add our dvd to the map
        dvdMap.put(dvd.getDvdId(), dvd);
        // We need to return the dvd per the interface
        return dvd;
    }

    @Override
    public DVD getDVDById(int dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public List<DVD> getAllDVDSByTitle(String searchByName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DVD> getAllDVDS() {
        List<DVD> allDVDS = new ArrayList<>(dvdMap.values());
        return allDVDS;
    }

    @Override
    public void updateDVD(DVD dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public void removeDVD(int dvdId) {
        dvdMap.remove(dvdId);
    }

    @Override
    public List<DVD> searchDVD(Map<SearchTerm, String> criteria) {
        // Get all the things we're searching for into individual variables
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String mpaaRatingCriteria = criteria.get(SearchTerm.MPAA_RATING);
        String directorsNameCriteria = criteria.get(SearchTerm.DIRECTORS_NAME);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        String userRatingCriteria = criteria.get(SearchTerm.USER_RATING);

        // Declare predicate conditions - to be used by our filters
        Predicate<DVD> titleMatches;
        Predicate<DVD> releaseDateMatches;
        Predicate<DVD> mpaaRatingMatches;
        Predicate<DVD> directorsNameMatches;
        Predicate<DVD> studioMatches;
        Predicate<DVD> userRatingMatches;

        // Default Predicate
        Predicate<DVD> truePredicate = (c) -> {
            return true;
        };

        titleMatches = (titleCriteria == null || titleCriteria.isEmpty()) 
                ? truePredicate
                : (c) -> c.getTitle().toLowerCase().startsWith(titleCriteria.toLowerCase());

        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getReleaseDate().toLowerCase().startsWith(releaseDateCriteria.toLowerCase());

        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getMpaaRating().toLowerCase().startsWith(mpaaRatingCriteria.toLowerCase());

        directorsNameMatches = (directorsNameCriteria == null || directorsNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getDirectorsName().toLowerCase().startsWith(directorsNameCriteria.toLowerCase());

        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStudio().toLowerCase().startsWith(studioCriteria.toLowerCase());

        userRatingMatches = (userRatingCriteria == null || userRatingCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getUserRating().toLowerCase().startsWith(userRatingCriteria.toLowerCase());

        // Return the list of contacts that match the given criteria 
        // We will filters and join them with AND
        return dvdMap.values().stream()
                .filter(titleMatches
                        .and(releaseDateMatches)
                        .and(mpaaRatingMatches)
                        .and(directorsNameMatches)
                        .and(studioMatches)
                        .and(userRatingMatches))
                .collect(Collectors.toList());

    }

    @Override
    public void decode() throws FileNotFoundException {
        // do nothing for in-memory implementation 
    }

    @Override
    public void encode() throws IOException {
        // do nothing for in-memory implementation 
    }

    @Override
    public List<DVDTitleCount> getDVDTitleCounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
