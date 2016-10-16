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
// implementing my OrderDao interface 
public class OrderDaoFileImpl implements OrderDao {
    // Puts "ORDERS_" in Orders folder
    private static final String ORDERS_FILE = "Orders/Orders_";
    private static final String DELIMITER = "::";
    private List<Order> orders = new ArrayList();
    private Integer nextId = 1;

    public OrderDaoFileImpl() {

    }

    @Override
    public Order addOrder(Order order) {

        order.setId(nextId); // set ID to 1

        orders.add(order);

        nextId++; // Increment ID count as order is added
        
        // Save orderData and set date via SimpleDataFormat - setDate method
        saveOrderData(setDate()); 

        return order;
    }

    @Override
    public Order readOrder(Integer id) {
        //readOrder by ID (customerNumber);
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

            Order o = (Order) litr.next(); //litr.next returns the next element in the list

            if (o.getId() == order.getId()) {

                litr.set(order); //.set replaces last element return by litr.next

            }
        }
        saveOrderData(date);
    }
    
    @Override
     public int getOrderCount() {
        return orders.size(); // used for testing to get ArrayList size

    }

    @Override
    public List<Order> findOrder(String date, int id) {

        orders = readOrderData(date);
        // lambdas and streams to find order by date and id
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

         saveOrderData(date);
    }

   @Override
    public List<Order> readAllOrders(String date) {
        orders = readOrderData(date);

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

   
    public void saveOrderData(String date) {

        try {
            PrintWriter out = new PrintWriter(new FileWriter(ORDERS_FILE + date + ".txt"));

            for (Order order : orders) {

                if (order.getDate().equals(date)) {

                    out.print(order.getId());
                    out.print(DELIMITER);

                    out.print(order.getCustomerName());
                    out.print(DELIMITER);

                    out.print(order.getStateName());
                    out.print(DELIMITER);

                    out.print(order.getStateTaxes());
                    out.print(DELIMITER);

                    out.print(order.getProductType());
                    out.print(DELIMITER);

                    out.print(order.getArea());
                    out.print(DELIMITER);

                    out.print(order.getMaterialCost());
                    out.print(DELIMITER);

                    out.print(order.getLaborCost());
                    out.print(DELIMITER);

                    out.print(order.getMaterialTotal());
                    out.print(DELIMITER);

                    out.print(order.getLaborTotal());
                    out.print(DELIMITER);

                    out.print(order.getTax());
                    out.print(DELIMITER);

                    out.print(order.getTotalCost());
                    out.println("");

                }

            }

            out.flush();
            out.close();

        } catch (IOException ex) {
        }
    }

   
    public List<Order> readOrderData(String date) {

        List<Order> tempOrders = new ArrayList();

        String fileName = ORDERS_FILE + date + ".txt";
        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
            String[] currentTokens;
            while (sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                currentTokens = currentLine.split(DELIMITER);

                Order currentOrder = new Order();

                currentOrder.setId(Integer.parseInt(currentTokens[0]));
                currentOrder.setCustomerName(currentTokens[1]);
                currentOrder.setStateName(currentTokens[2]);
                currentOrder.setStateTaxes(Double.parseDouble(currentTokens[3]));
                currentOrder.setProductType(currentTokens[4]);
                currentOrder.setArea(Double.parseDouble(currentTokens[5]));
                currentOrder.setMaterialCost(Double.parseDouble(currentTokens[6]));
                currentOrder.setLaborCost(Double.parseDouble(currentTokens[7]));
                currentOrder.setMaterialTotal(Double.parseDouble(currentTokens[8]));
                currentOrder.setLaborTotal(Double.parseDouble(currentTokens[9]));
                currentOrder.setTax(Double.parseDouble(currentTokens[10]));
                currentOrder.setTotalCost(Double.parseDouble(currentTokens[11]));
                currentOrder.setDate(date); //search for date when reading file
                tempOrders.add(currentOrder);

            }

        } catch (FileNotFoundException ex) {
        }

        return tempOrders;
    }
    @Override
    public void load(String date) {
        readOrderData(date);
        // do nothing - for interfaces
    }
    @Override
    public void save(String date) {
        saveOrderData(date);
        // do nothing - for interfaces

    }


}
