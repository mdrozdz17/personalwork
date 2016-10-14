/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.model.Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class OrderDaoInMemImpl implements OrderDao {

    private List<Order> orders = new ArrayList();
    private Integer nextId = 1;

    @Override
    public Order addOrder(Order order) {

        order.setId(nextId);

        orders.add(order);

        nextId++;

        return order;
    }

    @Override
    public Order readOrder(Integer id) {

        for (Order order : orders) {
            if (Objects.equals(order.getId(), id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void editOrder(Order order, String date) {

        ListIterator litr = orders.listIterator();
        while (litr.hasNext()) {

            Order o = (Order) litr.next();

            if (o.getId() == order.getId()) {

                litr.set(order);

            }
        }
      
    }
    
       @Override
     public int getOrderCount() {
        return orders.size();

    }

    @Override
    public List<Order> findOrder(String date, int id) {

       

        List<Order> results = orders
                .stream()
                .filter(d -> d.getDate().equalsIgnoreCase(date) && d.getId().equals(id))
                .collect(Collectors.toList());

        return results;
    }

    @Override
    public void removeOrder(Order order, String date) {

        for (Order o : orders) {
            if (o.getId().equals(order.getId())) {
                orders.remove(o);
                break;
            }
        }

        
    }

    @Override
    public List<Order> readAllOrders(String date) {

        List<Order> results = orders
                .stream()
                .filter(s -> s.getDate().equals(date))
                .collect(Collectors.toList());

        return new ArrayList(results);
    }

    @Override
    public String setDate() {

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        return dateFormat.format(new Date());

    }
    
    @Override
    public void load(String date) {
        // do nothing for in-memory implementation        
    }

    @Override
    public void save(String date) {
        // do nothing for in-memory implementation
    }


}
