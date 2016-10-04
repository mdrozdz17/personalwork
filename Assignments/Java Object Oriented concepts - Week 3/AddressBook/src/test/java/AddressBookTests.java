/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.addressbook.Address;
import com.sg.addressbook.AddressBookDAO;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookTests {
    
    public AddressBookTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testone() {
        AddressBookDAO ab = new AddressBookDAO();
       int id = 1;
       Address currentAddress = new Address();
       String street = "133 Osprey Drive";
       String city = "Portsmouth";
       String state = "NH";
       String zip = "03801";
       
       int result = ab.getAddressCount();
       
       assertEquals(3, result);
       
       
    }
}
