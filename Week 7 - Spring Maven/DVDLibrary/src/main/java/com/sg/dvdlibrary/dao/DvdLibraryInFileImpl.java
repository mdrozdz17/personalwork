/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.DVD;
import com.sg.dvdlibrary.model.DVDTitleCount;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author apprentice
 */
public class DvdLibraryInFileImpl implements DvdLibraryDao {

    private Map<Integer, DVD> dvdMap = new HashMap<>();
    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";
    private static int dvdIdCounter = 0;

   public DvdLibraryInFileImpl() throws FileNotFoundException, IOException {
     decode();
  
    }
    
    @Override
    public DVD addDVD(DVD dvd) {
        try {
            // We need to keep track of the ID manually right now
            // In our DB implementation, the database will assign the ID
            dvd.setDvdId(dvdIdCounter);
            // Once we assign the ID, we need to increment the counter for the next dvd
            dvdIdCounter++;
            // add our dvd to the map
            dvdMap.put(dvd.getDvdId(), dvd);
            encode();
            
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryInFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            dvdMap.put(dvd.getDvdId(), dvd);
            encode();
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryInFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeDVD(int dvdId) {
        try {
            dvdMap.remove(dvdId);
            encode();
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryInFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public List<DVD> searchDVD(Map<SearchTerm, String> criteria) {
        try {
            decode();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DvdLibraryInFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Get all the things we're searching fro into individual variables
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
                : (c) -> c.getTitle().equalsIgnoreCase(titleCriteria);

        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getReleaseDate().equalsIgnoreCase(releaseDateCriteria);

        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getMpaaRating().equalsIgnoreCase(mpaaRatingCriteria);

        directorsNameMatches = (directorsNameCriteria == null || directorsNameCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getDirectorsName().equalsIgnoreCase(directorsNameCriteria);

        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStudio().equalsIgnoreCase(studioCriteria);

        userRatingMatches = (userRatingCriteria == null || userRatingCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getUserRating().equalsIgnoreCase(userRatingCriteria);

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
        try {
            // Scanner sc = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
            Scanner sc = new Scanner(new BufferedReader(new FileReader(new ClassPathResource(DVD_FILE).getFile())));
            String[] currentTokens;
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);
                
                DVD currentDVD = new DVD();
                
                currentDVD.setDvdId(Integer.parseInt((currentTokens[0])));
                currentDVD.setTitle(currentTokens[1]);
                currentDVD.setReleaseDate(currentTokens[2]);
                currentDVD.setMpaaRating(currentTokens[3]);
                currentDVD.setDirectorsName(currentTokens[4]);
                currentDVD.setStudio(currentTokens[5]);
                currentDVD.setUserRating(currentTokens[6]);
                
                dvdMap.put(Integer.parseInt((currentTokens[0])), currentDVD);
            }
        } catch (IOException ex) {
            Logger.getLogger(DvdLibraryInFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   
    @Override
    public void encode() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(new ClassPathResource (DVD_FILE).getFile()));
        // Scanner sc = new Scanner(new BufferedReader(new FileReader(new ClassPathResource(DVD_FILE).getFile())));
            Set<Integer> keySet = dvdMap.keySet();
            for (Integer i : keySet) {
                
                out.print((dvdMap.get(i)).getDvdId());
                out.print(DELIMITER);
                
                out.print((dvdMap.get(i)).getTitle());
                out.print(DELIMITER);
                
                out.print((dvdMap.get(i)).getReleaseDate());
                out.print(DELIMITER);
                
                out.print((dvdMap.get(i)).getMpaaRating());
                out.print(DELIMITER);
                
                out.print((dvdMap.get(i)).getDirectorsName());
                out.print(DELIMITER);
                
                out.print((dvdMap.get(i)).getStudio());
                out.print(DELIMITER);
                
                out.print((dvdMap.get(i)).getUserRating());
                out.println("");
                
            }
            out.flush();
            out.close();
        }

    @Override
    public List<DVDTitleCount> getDVDTitleCounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

