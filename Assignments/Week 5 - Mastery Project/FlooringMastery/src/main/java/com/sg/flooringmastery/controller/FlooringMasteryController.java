/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.TaxDao;
import com.sg.flooringmastery.models.Order;
import com.sg.flooringmastery.models.Product;
import com.sg.flooringmastery.models.Tax;
import com.sg.flooringmastery.ui.ConsoleIO;
import com.sg.flooringmastery.ui.FlooringMasteryUI;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.nio.file.Files.list;
import java.text.ParseException;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class FlooringMasteryController {

    private ConsoleIO con = new ConsoleIO();
    private FlooringMasteryUI myUI = new FlooringMasteryUI();
    Order myOrder = new Order();
    private OrderDao odao = new OrderDao();
    private TaxDao tdao = new TaxDao();
    private ProductDao pdao = new ProductDao();

    public void run() throws IOException, ParseException {
        String date = myUI.promptForDate();
        boolean keepGoing = true;
        int menuSelection = 0;
         try {
        odao.loadData(date);
        while (keepGoing) {
            myUI.printMenu();
            menuSelection = con.readInt("Please select from the above choices.", 1, 6);

            switch (menuSelection) {
                case 1:
                    con.print("Set Date for Order");
                    // method goes here
                    break;
                case 2:
                    con.print("Add order");
                    addOrder();
                    break;
                case 3:
                    con.print("Display all orders");
                    displayOrders();
                    break;
                case 4:
                    con.print("Edit specific order");
                    editOrder();
                    break;
                case 5:
                    con.print("Remove an order");
                    removeOrder();
                    break;
                case 6:
                    con.print("Exit");
                    keepGoing = false;
                    break;
                default:
                    con.print("Unknown Command");
            }
        }

        con.print("Thanks for visiting. Have a good day");
         odao.saveData();
         } catch (FileNotFoundException ex) {
         con.print("Error loading Order");
          } catch (IOException ex) {
          con.print("Error saving order to file");

    }
    }

    private void addOrder() throws ParseException {
        con.print("**** ADD AN ORDER ****");
        con.print("Please enter order date (MM-DD-YYYY): ");
        String Date = myUI.promptForDate();
        
        String customerName = con.readString("Please enter customer name");
        // need more here:
        
        List<Tax> stateTax = TaxDao.listAllTax(); // checking listAllTax method in Tax Dao
        con.readString("Please enter a state");
        
        stateTax
                .stream()
                .forEach(t -> {
                   con.print(t.getState());
                    
                });
                
        List<Product> product = ProductDao.listAllProducts(); // create listAllProducts method DAO
        con.print("Please select flooring product type");
        
        product
                .stream()
                .forEach(p -> {
                    con.print(p.getProductType());
                });
        
        double area = con.readDouble("Please enter the floor area in square feet: ");
        while(1>area){
            area = con.readDouble("Sorry, The minimum order is 1 square Foot. Please re-enter the area");
        }
        double laborCost = laborCostPerSqFt * area;
        
        
        String state = "";
                state = identifyState(state); // identify state method
                
        String productType = "";
        productType = identifyProductType(productType);
        
        

        Order newOrder = myUI.promptForOrderInfo();
        String answer;
        boolean yn;
        con.print(newOrder.toString());
        answer = con.readString("Is this info correct? (y/n)");

        while (true) {
            if (answer.equalsIgnoreCase("y")) {
                odao.addOrder(newOrder); 
                yn = true;
                break;
            } else if (answer.equalsIgnoreCase("n")) {
                yn = false;
                break;

            }
        }
    }

    private void editOrder() throws ParseException {

        con.print("**** UPDATE AN ORDER ****");
        int orderNumber = con.readInt("Please enter the orderNumber");
        
        List<Order> orderId = odao.listOrderNumber(orderNumber);
        
        if(orderId.isEmpty()) {
            con.print("Sorry there are no orders with that Order Number");
        } else {
            
            Order editOrder = orderId.get(0);
            
        con.print("Please enter order date (MM-DD-YYYY): ");
        // finish this
        }
        
    
        
        
        String date = myUI.promptForDate();
        int targetNumber = myUI.promptForOrderNumber();
        //   OrderList = myOrder.getAllOrders()
        //  Order targetOrder = new Order();
        con.print("Please Enter to keep existing info...");
        String customerName = con.readString("CUSTOMER NAME (" + myOrder.getCustomerName() + "):");
        String state = con.readString("STATE (" + myOrder.getState() + "):");
        String productType = con.readString("PRODUCT TYPE (" + myOrder.getProductType() + "):");
        String areaString = con.readString("AREA (" + myOrder.getArea() + "):");

        if (!customerName.isEmpty()) {
            myOrder.setCustomerName(customerName);
        }

        if (!state.isEmpty()) {
            myOrder.setState(state);
        }

        if (!productType.isEmpty()) {
            myOrder.setProductType(productType);
        }

        if (!areaString.isEmpty()) {
            try {
                double area = Double.parseDouble(areaString);
            } catch (NumberFormatException ex) {
                con.print("Please enter a valid number for the area");
                double area = con.readDouble("AREA ( " + myOrder.getArea() + "):");
                if (area > 0 && area < 100000) {
                    myOrder.setArea(area);

                }
            }
        }
        odao.updateOrder(myOrder);
    }

    private void removeOrder() throws IOException, ParseException {
        boolean yn;
        con.print("**** REMOVE AN ORDER ****");
        int orderNumber = con.readInt("Please enter the Order Number");
        
        List<Order> orderId = odao.listOrderNumber(orderNumber);
        
        if (orderId.isEmpty()){
            con.print("There are no orders with this Order Number");
        } else {
       String  answer = con.readString("Are you sure you want to delete this order (y/n)");

        while (true) {
            if (answer.equalsIgnoreCase("y")) {
                odao.removeOrder(orderId.get(0));
                yn = true;
                con.print("This order has been deleted");
                break;
            } else if (answer.equalsIgnoreCase("n")) {
                yn = false;
                break;

            }
        }
          

    }
    }

    private void orderList() throws ParseException, FileNotFoundException { // Should be complete
        con.print("**** CURRENT ORDERS ****");
        String date = myUI.promptForDate();
        odao.loadData(date);
        myUI.printOrders();
    }
    
    private String identifyState(String state) {
        
        List<Tax> listTax = TaxDao.listTax(state); // list Tax method in Tax DAO
        state = listTax.get(0).getState(); //Get State starting at index 0 for state.
        return state;
    }
    
       private String identifyProductType(String productType) {
        
        List<Product> listProduct = ProductDao.listProduct(productType); // list Product method in Product DAO
        productType = listProduct.get(0).getProductType(); //Get State starting at index 0 for state.
        return productType;
    }
        
        private void displayOrders() {
            
            List<Order> ordersComplete = odao.listAllOrders();
            ordersComplete
                    .stream()
                    .forEach((Order o) -> {
                        con.print(o.toString() + " ");
                        con.print(o.getCustomerName() + " ");
                        //con.print(o.getState() + " ");
                        //con.print(o.getTaxRate() + " ");
                        //con.print(o.getProductType() + " ");
            
        });
            
        }
        

    }


