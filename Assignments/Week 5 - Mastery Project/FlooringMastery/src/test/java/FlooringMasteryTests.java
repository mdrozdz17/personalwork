/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.flooringmastery.dao.OrderDao;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryTests {
    
    OrderDao testDao = new OrderDao();
    
    public FlooringMasteryTests() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testAgaisntEmptyDAO() {
       // Assert.assertEquals("Expected order count does not match after adding 1 order", 0, testDao.g);
    }
    
    
}
