/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.addressbook2.dto.Address;
import com.sg.addressbook2.dao.AddressBook2DAO;
import java.util.HashMap;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBook2Tests {

    AddressBook2DAO testDao = new AddressBook2DAO();
    //HashMap not needed as instance of the DAO calls the values that are stored
    // in the HashMap

    public AddressBook2Tests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testHashMapSize() {
        //Arrange
        int expectedRecordCount = 0;
        //Act
        int actualRecordCount = testDao.getAddressCount();

        //Assert
        assertEquals(expectedRecordCount, actualRecordCount);
    }

    @Test
    public void testAddRemoveAddress() {
        //Arrange
        int startingRecordCount = testDao.getAddressCount();
        Address testAddress = new Address();
        testAddress.setStreet("133 Osprey Drive");
        testAddress.setCity("Portsmouth");
        testAddress.setState("NH");
        testAddress.setZip("03801");

        //Act for adding address
        testDao.addAddress(testAddress);

        //Assert
        assertEquals(startingRecordCount + 1, testDao.getAddressCount());

        //Act for removing address
        testDao.removeAddress(startingRecordCount);

        // Assert for testing address was removed. If 2 addresses were defined above
        // Than I would would startingRecordCount -1 
        assertEquals(startingRecordCount, testDao.getAddressCount());

    }

    @Test
  public void testEdit() {

        System.out.println("Running test case edit added address");
        //Arrange
        int startingRecordCount = testDao.getAddressCount();
        Address testAddress = new Address();
        testAddress.setStreet("133 Osprey Drive");
        testAddress.setCity("Portsmouth");
        testAddress.setState("NH");
        testAddress.setZip("03801");
        
        // Act for Editing Address
        testDao.editAddress(testAddress);
        
        // Assert
          assertEquals(startingRecordCount, testDao.getAddressCount());
        
        

        
  }
}
