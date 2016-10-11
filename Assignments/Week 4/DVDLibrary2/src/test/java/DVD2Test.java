/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.dvdlibrary.dao.DVDLibrary2DAO;
import com.sg.dvdlibrary.dao.DvdLibraryImpl;
import com.sg.dvdlibrary.models.DVD;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class DVD2Test {
    DvdLibraryImpl testDao = new DvdLibraryImpl();
    
    public DVD2Test() {
    }
    
    @Test
    public void testHashMapSize() {
        //Arrange
        int expectedRecordCount = 0;
        //Act
        int actualRecordCount = testDao.getDvdCount();
        
        //Assert
        assertEquals(expectedRecordCount, actualRecordCount);
    }
    
       @Test
    public void testAddRemoveAddress() {
        //Arrange
        int startingRecordCount = testDao.getDvdCount();
        DVD testDvd = new DVD();
        testDvd.setTitle("Rush Hour");
        testDvd.setMpaaRating("PG-13");
        testDvd.setDirectorsName("Bill");
        testDvd.setStudio("Hollywood");
        testDvd.setUserRating("Great Movie!");
        
  
        //Act for adding address
        testDao.addDvd(startingRecordCount, testDvd);
        
        //Assert
        assertEquals(startingRecordCount + 1, testDao.getDvdCount());
        
        //Act for removing address
        testDao.removeDvd(startingRecordCount);
        
        // Assert for testing address was removed. If 2 addresses were defined above
        // Than I would would startingRecordCount -1 
        assertEquals(startingRecordCount, testDao.getDvdCount());

        
    }
}

    
