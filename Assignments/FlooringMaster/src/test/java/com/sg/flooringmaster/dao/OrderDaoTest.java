package com.sg.flooringmaster.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sg.flooringmaster.model.Order;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class OrderDaoTest {

    OrderDao testDao;

    Order[] ordersForTesting = {
        new Order(1, "Matt", "OH", 6.25, "Wood", 90.00, 5.15, 4.75, 515.00, 475.00, 61.88, 1051.88),
        new Order(2, "Jena", "PA", 6.75, "Tile", 80.00, 5.15, 4.75, 515.00, 475.00, 61.88, 1051.88),
        new Order(3, "Grayson", "MI", 5.75, "Carpet", 75.00, 5.15, 4.75, 515.00, 475.00, 61.88, 1051.88)
    };

    public OrderDaoTest() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        testDao = (OrderDao) ctx.getBean("daoInMemImpl");
    }

    @Test
    public void addOneToEmptyDaoTest() {
        // Step 1: Make an Order
        Order Matt = new Order(1, "Matt", "OH", 6.25, "Wood", 100.00, 5.15, 4.75, 515.0, 475.00, 61.88, 1051.88);

        // Step 2: Add order to dao
        testDao.addOrder(Matt);

        // Step 3: get order out of dao by OrderNumber
        Order hopefullyMatt = testDao.readOrder(Matt.getId());

        //Step 4:
        assertEquals("Order stored, vs. order retrieved does not match",
                Matt, hopefullyMatt);
    }

    @Test
    public void testAgaisntEmptyDao() {
        String date = "";
        assertEquals("Expected order count does not match after adding one pet.", 0, testDao.readAllOrders(date).size());

    }

    @Test
    public void testAddOneOrder() {
        Order orderToAdd = ordersForTesting[0];
        testDao.addOrder(orderToAdd);
        assertEquals("Expected Order count does not match after adding one pet.", 1, testDao.getOrderCount());
        assertEquals("Returned Order does not match expected.", orderToAdd, testDao.readOrder(orderToAdd.getId()));
        assertNotNull("List of all pets should not be null.", testDao.getOrderCount());
        assertEquals("Expected Order count of 'all Orders' does not match after adding one order.", 1, testDao.getOrderCount());
        // assertFalse("Returned Orders in readAllOrders does not match expected.", testDao.readAllOrders(date).contains(orderToAdd));

    }

    @Test
    public void testAddAndRemoveOrder() {
        String date = "";
        List<Order> order = new ArrayList();
        testDao.addOrder(ordersForTesting[0]);
        testDao.removeOrder(ordersForTesting[0], ordersForTesting[0].getDate());

        assertEquals("Expected 0 orders after adding/removing same order twice. ", 0, testDao.readAllOrders(date).size());
        assertEquals("Expected order count of all orders should be zero when adding/removing a single order.", 0, testDao.readAllOrders(date).size());

    }

    @Test
    public void testAddAndRemoveMultipleOrders() {
        String date = "";
        for (Order order : ordersForTesting) {
            testDao.addOrder(order);
        }

        int ordersAdded = ordersForTesting.length;
        for (int i = 0; i < ordersForTesting.length; i += 2) {
            testDao.removeOrder(ordersForTesting[i], ordersForTesting[i].getDate());
            ordersAdded--;

        }

        assertEquals("Expected pet count does not match after adding two pets.", ordersAdded, testDao.getOrderCount());
        assertNotNull("List of all pets should not be null.", testDao.getOrderCount());
        assertEquals("Expected pet count of 'all pets' does not match after adding & removing several pets.",
                ordersAdded, testDao.getOrderCount());

        for (int i = 0; i < ordersForTesting.length; i++) {
            if (i % 2 == 1) {
                assertEquals("Returned pet does not match expected.", ordersForTesting[i], testDao.readOrder(ordersForTesting[i].getId()));
            } else {
                assertNull("Pet should be removed and return null.", testDao.readOrder(ordersForTesting[i].getId()));
            }
        }

    }
}
