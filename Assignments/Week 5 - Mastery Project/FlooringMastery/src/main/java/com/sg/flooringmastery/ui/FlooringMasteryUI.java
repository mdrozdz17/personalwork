/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.TaxDao;
import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.Tax;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryUI {

    private ConsoleIO con = new ConsoleIO();
    private OrderDao odao = new OrderDao();
    private TaxDao tdao = new TaxDao();
    private ProductDao pdao = new ProductDao();
    Order myOrder = new Order();

    int promptMenuChoice;

    public void printMenu() {
        con.print("===================Main Menu===========================");
        con.print("1. Set Date for Order");
        con.print("2. Add Order");
        con.print("3. Display all Orders");
        con.print("4. Edit an Order");
        con.print("5. Remove an Order");
        con.print("6. Exit");

    }

    public void promptForOrderNumber() {
        int orderNumber = con.readInt("Please enther the order id");

        List<Order> orderId = odao.listOrderNumber(orderNumber);

        if (orderId.isEmpty()) {
            con.print("There are no orders with this id");
        } else {
            orderId
                    .stream()
                    .forEach((Order o) -> {
                        con.print(Integer.toString(o.getOrderNumber()));
                        con.print(o.getDate());
                        con.print(o.getCustomerName());
                        con.print(o.getState());
                        con.print(Double.toString(o.getTaxRate()));
                        con.print(o.getProductType());
                        con.print(Double.toString(o.getArea()));
                        con.print(Double.toString(o.getMaterialCostPerSqFt()));
                        con.print(Double.toString(o.getLaborCostPerSqFt()));
                        con.print(Double.toString(o.getMaterialCost()));
                        con.print(Double.toString(o.getLaborCost()));
                        con.print(Double.toString(o.getTax()));
                        con.print(Double.toString(o.getTotalCost()));

                    });
        }

    }

    public Order promptForOrderInfo() {
        String customerName = con.readString("Please enter your First and Last Name");
        String state = con.readString("Please enter your State");
        String productType = con.readString("Please enter your Product Type");
        Double area = con.readDouble("Please enter the area");
        Order currentOrder = new Order();
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setProductType(productType);
        currentOrder.setArea(area);
        tdao.getTaxByState(state);

        return currentOrder;
    }

    public void promptForCustomerName(String date) {
        //  List<Order> list = odao.loadData(date);

    }

    public String promptForDate() throws ParseException {

        boolean valid = false;
        String orderDate = "";

        while (!valid);
        try {

            //MM must be capalized for month and "dd" and "yyyy" must be lowercase 
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            sdf.setLenient(false); // Default is true, must set to false to match MM-DD-YYYY pattern above
            Date date = sdf.parse(con.scannerNextLine()); // create local variable Date to parse date from String
            Format dateFormat = new SimpleDateFormat("MM-dd-yyyy");
            orderDate = dateFormat.format(date); //format an object to produce the date as a String

            valid = true;
        } catch (ParseException ex) {
            con.print("Invalid Date Format. Please enter the order date (MM-DD-YYYY):");
        }

        return orderDate;

    }

    public String promptForState(ArrayList<Tax> taxList) {
        String input = con.readString("Please enter your State".toLowerCase());

        boolean valid = true;
        for (Tax tax : taxList) {
            if (tax.getState().equals(input)) {
                valid = true;
            }
            while (!valid) {
                input = con.readString("Our Services are not currently offered in that state"
                        + " please re-enter a state or type q to quit");

            }
        }
        return input;
    }

    public String promptForProduct(ArrayList<Product> productList) {
        String input = con.readString("Please enter the Product Type you want to use ".toLowerCase());

        boolean valid = true;
        for (Product product : productList) {
            if (product.getProductType().equals(input)) {
                valid = true;
            }
            while (!valid) {
                input = con.readString("Sorry we currently do not over that product type"
                        + " please re-enter a valid product type or type q to quit");

            }
        }
        return input;
    }

    public void printOrders() {
        myOrder.toString();

    }
}
