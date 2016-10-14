/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.dao;

import com.sg.flooringmaster.model.Order;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface OrderDao {
    
public Order addOrder(Order order);

public Order readOrder(Integer id);

public void editOrder(Order order, String date);

public List<Order> findOrder(String date, int id);

public void removeOrder(Order order, String date);

public List<Order> readAllOrders(String date);

public String setDate();

public int getOrderCount();

 public void load(String date);
    
 public void save(String date);
 
 







    
}
