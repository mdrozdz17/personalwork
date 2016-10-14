/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.ui.ConsoleIO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class OrderDao {

    public static final String ORDERS_FILE = "order.txt";
    public static final String DELIMITER = "::";
    private ConsoleIO con = new ConsoleIO();
    private HashMap<Integer, Order> ordersAll = new HashMap();
    private int orderNumber = 0;
    List<Order> orders = new ArrayList<>();

    //@Override
    public void loadData(String date) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ORDERS_FILE)));
        String[] currentTokens;
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Order currentOrder = new Order();

            currentOrder.setOrderNumber(Integer.parseInt(currentTokens[0]));
            currentOrder.setCustomerName(currentTokens[1]);
            currentOrder.setState(currentTokens[2]);
            currentOrder.setTaxRate(Double.parseDouble(currentTokens[3]));
            currentOrder.setProductType(currentTokens[4]);
            currentOrder.setArea(Double.parseDouble(currentTokens[5]));
            currentOrder.setMaterialCostPerSqFt(Double.parseDouble(currentTokens[6]));
            currentOrder.setLaborCostPerSqFt(Double.parseDouble(currentTokens[7]));
            currentOrder.setMaterialCost(Double.parseDouble(currentTokens[8]));
            currentOrder.setLaborCost(Double.parseDouble(currentTokens[9]));
            currentOrder.setTax(Double.parseDouble(currentTokens[10]));
            currentOrder.setTotalCost(Double.parseDouble(currentTokens[11]));

            orders.add(currentOrder);

        }

    }

    // @Override
    public void saveData() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ORDERS_FILE));
        for (Order o : orders) {

            out.print(o.getOrderNumber());
            out.print(DELIMITER);

            out.print(o.getCustomerName());
            out.print(DELIMITER);

            out.print(o.getState());
            out.print(DELIMITER);

            out.print(o.getTaxRate());
            out.print(DELIMITER);

            out.print(o.getProductType());
            out.print(DELIMITER);

            out.print(o.getArea());
            out.print(DELIMITER);

            out.print(o.getMaterialCostPerSqFt());
            out.print(DELIMITER);

            out.print(o.getLaborCostPerSqFt());
            out.print(DELIMITER);

            out.print(o.getMaterialCost());
            out.print(DELIMITER);

            out.print(o.getLaborCost());
            out.print(DELIMITER);

            out.print(o.getTax());
            out.print(DELIMITER);

            out.print(o.getTotalCost());
            out.println("");

        }
        out.flush();
        out.close();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Integer addOrderHash(Order order) { // For Hash
        String date = order.getDate();
        order.setOrderNumber(orderNumber);
        ordersAll.put(orderNumber, order);
        orderNumber++;
        return orderNumber - 1;
    }

    public List listAllOrders() { // forHash

        List<Order> ordersComplete = ordersAll
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return ordersComplete;

    }


    public List<Order> getAllOrders() {
        return orders;
    }

    public List<Order> updateOrder(Order order) {
        return orders;
    }

    public void findOrder(Integer orderNumber) {
        orders
                .stream()
                .filter(o -> o.getOrderNumber().equals(orderNumber))
                .forEach((Order o) -> {
                    con.print(o.getCustomerName() + " ");
                    // find more orders....

                });

    }

    public Integer removeOrder(Order order) {
        int customerNumber = order.getOrderNumber();

        String date = ordersAll.get(customerNumber).getDate();
        ordersAll.remove(customerNumber);

        return customerNumber;

    }

    public List<Order> listOrderNumber(int orderNumber) {
               List<Order> ordersComplete = ordersAll
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return ordersComplete;

    }

}
