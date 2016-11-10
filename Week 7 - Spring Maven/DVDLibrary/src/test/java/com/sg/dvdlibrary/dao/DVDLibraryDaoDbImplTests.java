/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class DVDLibraryDaoDbImplTests {

    private DvdLibraryDao dao;

    public DVDLibraryDaoDbImplTests() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (DvdLibraryDao) ctx.getBean("dvdLibraryInDb");
        //Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from dvds");

    }

    @After
    public void tearDown() {

    }

    @Test
    public void addGetDeleteDVD() {
        //Creating new DVD
        DVD newDVD = new DVD();

        newDVD.setTitle("Rush Hour");
        newDVD.setReleaseDate("1998");
        newDVD.setMpaaRating("PG-13");
        newDVD.setDirectorsName("Brett Ratner");
        newDVD.setStudio("New Line Cinema");
        newDVD.setUserRating("9/10");

        // Add Dvd to Dao
        dao.addDVD(newDVD);

        // Get DVD out of Dao by DVD ID
        DVD myDVD = dao.getDVDById(newDVD.getDvdId());

        //assertEquals("DVD stored, vs. DVD retrieved does not match", myDVD, newDVD);
        // Make sure newDVD Stored Matches what is in the Database
        
        assertEquals(myDVD.getDvdId(), newDVD.getDvdId());
        assertEquals(myDVD.getTitle(), newDVD.getTitle());
        assertEquals(myDVD.getReleaseDate(), newDVD.getReleaseDate());
        assertEquals(myDVD.getMpaaRating(), newDVD.getMpaaRating());
        assertEquals(myDVD.getDirectorsName(), newDVD.getDirectorsName());
        assertEquals(myDVD.getStudio(), newDVD.getStudio());
        assertEquals(myDVD.getUserRating(), newDVD.getUserRating());

        // Remove DVD from Dao
        dao.removeDVD(newDVD.getDvdId());

        // Result must be null in order to ensure DVD was successfully moved
        assertNull(dao.getDVDById(newDVD.getDvdId()));

    }

    @Test
    public void addUpdateDVD() {
        // Create new DVD
        DVD newDVD = new DVD();

        newDVD.setTitle("Rush Hour 2");
        newDVD.setReleaseDate("2001");
        newDVD.setMpaaRating("PG-13");
        newDVD.setDirectorsName("Brett Ratner");
        newDVD.setStudio("New Line Cinema");
        newDVD.setUserRating("9/10");

        dao.addDVD(newDVD);

        // set new User Rating
        newDVD.setUserRating("10/10");

        // Update from 9/10 to 10/10
        dao.updateDVD(newDVD);

        DVD myDVD = dao.getDVDById(newDVD.getDvdId());

        assertEquals(myDVD, newDVD);
    }

    @Test
    public void getAllDVDs() {
        DVD newDVD = new DVD();

        newDVD.setTitle("Rush Hour");
        newDVD.setReleaseDate("1998");
        newDVD.setMpaaRating("PG-13");
        newDVD.setDirectorsName("Brett Ratner");
        newDVD.setStudio("New Line Cinema");
        newDVD.setUserRating("9/10");

        dao.addDVD(newDVD);

        DVD newDVD2 = new DVD();

        newDVD2.setTitle("Rush Hour 2");
        newDVD2.setReleaseDate("2001");
        newDVD2.setMpaaRating("PG-13");
        newDVD2.setDirectorsName("Brett Ratner");
        newDVD2.setStudio("New Line Cinema");
        newDVD2.setUserRating("9/10");

        dao.addDVD(newDVD2);

        List<DVD> dvdList = dao.getAllDVDS();

        // Ensure that there are 2 DVDs stored.
        assertEquals(dvdList.size(), 2);

    }

    @Test
    public void searchDVDs() {
        DVD newDVD = new DVD();

        newDVD.setTitle("Rush Hour");
        newDVD.setReleaseDate("1998");
        newDVD.setMpaaRating("PG-13");
        newDVD.setDirectorsName("Brett Ratner");
        newDVD.setStudio("New Line Cinema");
        newDVD.setUserRating("9/10");

        dao.addDVD(newDVD);

        DVD newDVD2 = new DVD();

        newDVD2.setTitle("Rush Hour 2");
        newDVD2.setReleaseDate("2001");
        newDVD2.setMpaaRating("PG-13");
        newDVD2.setDirectorsName("Brett Ratner");
        newDVD2.setStudio("New Line Cinema");
        newDVD2.setUserRating("9/10");

        dao.addDVD(newDVD2);

        DVD newDVD3 = new DVD();

        newDVD3.setTitle("Home Alone");
        newDVD3.setReleaseDate("1991");
        newDVD3.setMpaaRating("PG");
        newDVD3.setDirectorsName("Chris Columbus");
        newDVD3.setStudio("Hughes Entertainment");
        newDVD3.setUserRating("8/10");

        dao.addDVD(newDVD3);

        /*
        //Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.DIRECTORS_NAME, "Brett Ratner");
        List<DVD> dvdList = dao.searchDVD(criteria);
        assertEquals(2, dvdList.size());
//        assertEquals(newDVD2, dvdList.get(0));

        // New Search Criteria - look for Chris Columbus from Home Alone
        criteria.put(SearchTerm.DIRECTORS_NAME, "Chris Columbus");
        dvdList = dao.searchDVD(criteria);
        assertEquals(1, dvdList.size());

        // Add Studio to search criteria
        criteria.put(SearchTerm.STUDIO, "Hughes Entertainment");
        dvdList = dao.searchDVD(criteria);
        assertEquals(1, dvdList.size()); // value should be 1 since Hughes Entertainment
        // is only in 1 DVD
        assertEquals(newDVD3, dvdList.get(0));

        // Change Studio to Hughes Entertainment, should get 1 back
        criteria.put(SearchTerm.STUDIO, "Hughes Entertainment");
        dvdList = dao.searchDVD(criteria);
        assertEquals(1, dvdList.size());

        // Change Studio to Hughes Entertainment, should get nothing back
        criteria.put(SearchTerm.STUDIO, "Hollywood");
        dvdList = dao.searchDVD(criteria);
        assertEquals(0, dvdList.size());
*/
    }
}
