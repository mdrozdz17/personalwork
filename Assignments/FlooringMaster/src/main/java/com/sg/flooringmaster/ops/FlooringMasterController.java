/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster.ops;

import com.sg.flooringmaster.dao.OrderDao;
import com.sg.flooringmaster.dao.OrderDaoFileImpl;
import com.sg.flooringmaster.dao.ProductDao;
import com.sg.flooringmaster.dao.TaxDao;
import com.sg.flooringmaster.model.Order;
import com.sg.flooringmaster.ui.ConsoleIO;
import com.sg.flooringmaster.ui.FlooringMasteryUI;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class FlooringMasterController {

    private ConsoleIO con = new ConsoleIO();
   // private OrderDaoFileImpl orderDao = new OrderDaoFileImpl();
    private OrderDao orderDao; // This is for Dependency Injection
    private TaxDao taxDao;
    private ProductDao productDao;
    //private TaxDao taxDao = new TaxDao();
    //private ProductDao productDao = new ProductDao();
    private FlooringMasterBusinessLogic myBL = new FlooringMasterBusinessLogic();
    private FlooringMasteryUI myUI = new FlooringMasteryUI();

    
   public FlooringMasterController(OrderDao orderDao, TaxDao taxDao, ProductDao productDao) {
       this.orderDao = orderDao;
       this.productDao = productDao;
       this.taxDao = taxDao;
    
}

    public void run() {
        String date = orderDao.setDate();
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {

            myUI.printMenu();
            menuSelection = con.readInt("Please select from the above choices.", 1, 6);

            switch (menuSelection) {
                case 1:
                    con.print("Display Orders");
                    displayOrders();
                    break;
                case 2:
                    con.print("Add Orders");
                    addOrders();
                    break;
                case 3:
                    con.print("Update Orders");
                    updateOrder();
                    break;
                case 4:
                    con.print("Remove Orders");
                    removeOrder();
                    break;
                case 5:
                    con.print("Save data");
                 orderDao.save(date);
                 con.print("Order successfully saved");
                case 6:
                    keepGoing = false;
                    break;

            }
        }

        con.print("Thanks for Visiting. Have a good day");
    }

    private void displayOrders() {

        boolean displayOrders = true;
        boolean isValid = true;

        while (displayOrders) {

            String getDate = con.printString("Enter a date for the order you want to lookup (MM-DD-YYYY)");

            // isValid = confirmation("ENTER (1) TO PROCEED OR (2) TO START OVER");
            if (isValid == true) {
                List<Order> foundOrders = orderDao.readAllOrders(getDate);

                displayOrders = myUI.validateOrder(foundOrders);

                for (Order o : foundOrders) {
                             con.print(o.toString());
                             con.print("=======================================");
                }

            }
            displayOrders = myUI.confirmation("To view a different date enter (1) if not enter (2)");
        }
    }

    private void addOrders() {

        boolean addAnOrder = true;
        while (addAnOrder) {

            String name = con.printString("Enter a Customer Name");

            int state = con.readInt("Enter a State (1)OH (2)PA (3)MI (4)IN", 1, 4);
            int product = con.readInt("Enter a Product Type (1)CARPET (2)LAMINATE (3)TILE (4)WOOD", 1, 4);
            
            double area = con.readDouble("Enter the desired area of the product in square feet. The Area must be at least 1 and less than 100000.");
            if (area < 0) {
             con.print("Nice try - but area's can not be negative. Returning to the main menu");
             break;
            }
            if (area > 100000) {
                con.print("That Area is too high. Returning to the main menu");
                break;
            }

            double costOfProduct = productDao.readProductId(product).getCost();
            double costOfLabor = productDao.readProductId(product).getLaborCost();
            String stateName = taxDao.readTaxId(state).getStateName();
            double stateTaxRate = taxDao.readTaxId(state).getTaxRate();
            String productType = productDao.readProductId(product).getProductType();

            Order placeOrder = new Order();
            placeOrder.setCustomerName(name);
            placeOrder.setStateName(stateName);
            placeOrder.setStateTaxes(stateTaxRate);
            placeOrder.setProductType(productType);
            placeOrder.setArea(area);
            placeOrder.setMaterialCost(costOfProduct);
            placeOrder.setLaborCost(costOfLabor);
            placeOrder.setLaborTotal(myBL.laborTotal(area, costOfLabor));
            placeOrder.setMaterialTotal(myBL.materialTotal(area, costOfProduct));
            placeOrder.setTax(myBL.tax(area, stateTaxRate, costOfLabor, costOfProduct));
            placeOrder.setTotalCost(myBL.total(stateTaxRate, costOfLabor, costOfProduct));
            placeOrder.setDate(this.orderDao.setDate());

            orderDao.addOrder(placeOrder);

            addAnOrder = myUI.confirmation("Press (1) to save order or (2) to cancel order");
            if (addAnOrder == true) {
                con.print("Order has been placed");

            } else {
                con.print("Order Cancelled");
            }
            addAnOrder = myUI.returnToMenu("Enter (1) to return to the main menu and (2) to continue adding orders");
        }
    }

    private void removeOrder() {
         boolean displayOrders = true;

        boolean remove = true;

        while (remove) {

            String searchDate = con.printString("Enter the date of the order (MM-DD-YYYY)");
            List<Order> foundOrders = orderDao.readAllOrders(searchDate);


            remove = myUI.confirmation("If " + searchDate + " Is correct enter (1) if not enter (2)");
            if (remove == false) { // If false prompt user to re-enter date or exit to main menu
                remove = myUI.confirmation("To retry enter (1) to exit to main menu enter (2)");
            } else {

                int id = con.readInt("Enter the Order Number");
                if (remove == true) {
                    // if id matches id
                    Order orderId = orderDao.readOrder(id);

                    remove = myUI.confirmation("Enter (1) to confirm deletion OR (2) to cancel");
                    if (remove == true) {

                        orderDao.removeOrder(orderId, searchDate);
                        con.print("Order has been successfully removed");
                    }
                    remove = myUI.confirmation("Enter (1) to delete another order or (2) to go back to the menu");
                } else {

                    List<Order> deleteOrder = orderDao.findOrder(searchDate, id);

                    remove = myUI.validateOrder(deleteOrder);

                }
            }
        }
    }

    private void updateOrder() {

        boolean update = true;

        while (update) {

            String enterDate = con.printString("Enter date of the order to lookup (MM-DD-YYYY)");

            //update = myUI.confirmation("IF " + enterDate + " IS CORRECT ENTER(1) IF NOT ENTER(2)");
            // if (update == false) {
            //    update = myUI.confirmation("IF YOU'D LIKE TO CONTINUE ENTER(1) IF NOT ENTER(2)");
            // } else {
            
            // To update an order a user must enter date and it must match in order for the order to be found
            List<Order> foundOrders = orderDao.readAllOrders(enterDate);
            
            // if search is empty returns cannot find order
            update = myUI.validateOrder(foundOrders);

            if (update == true) {

                int id = con.readInt("Enter the order number of the order you want to update");

                if (id == 0) {
                    con.print("Sorry 0 is not a valid order number. Please re-enter the order information you are looking for.");
                } else {
                    List<Order> foundId = orderDao.findOrder(enterDate, id);

                    update = myUI.validateOrder(foundId);

                    if (update == true) {

                        Order orderId = orderDao.readOrder(id);

                        editOrder(orderId, enterDate);
                        update = myUI.confirmation("Enter (1)to edit another order and (2) go back to the menu");
                    }

                }
            }
        }
    }

    private void editOrder(Order editOrder, String date) {
        int id = con.readInt("Please re-confirm your Order Number");
       Order order = orderDao.readOrder(id);
       
        
        
        con.print("Press Enter to Keep Existing Info...");
        String name = con.printString("Enter New Name (" + order.getCustomerName() + "):");
        String state = con.printString("Enter a State ((1)OH (2)PA (3)MI (4)IN  (" + order.getStateName()+ "):");
        String product = con.printString("Enter a Product Type ((1)CARPET (2)LAMINATE (3)TILE (4)WOOD (" + order.getProductType() + "):");
        String area = con.printString("Enter the desired area of product in square feet (" + order.getArea() + "):");


        if (!name.isEmpty()) {
            editOrder.setCustomerName(name);
            orderDao.editOrder(editOrder, date);

            if (!state.isEmpty()) {
                int stateId = Integer.parseInt(state);
                String stateName = taxDao.readTaxId(stateId).getStateName();
                editOrder.setStateName(stateName);
                orderDao.editOrder(editOrder, date);
            }

            if (!product.isEmpty()) {
                int productId = Integer.parseInt(product);
                String productName = productDao.readProductId(productId).getProductType();
                editOrder.setProductType(productName);
                orderDao.editOrder(editOrder, date);
            }
            if (!area.isEmpty()) {
                double newArea = Double.parseDouble(area);
                editOrder.setArea(newArea);
                orderDao.editOrder(editOrder, date);
            }

            double newArea = editOrder.getArea();
            double laborCost = editOrder.getLaborCost();
            double productCost = editOrder.getMaterialCost();
            double taxRate = editOrder.getStateTaxes();

            editOrder.setLaborTotal(myBL.laborTotal(newArea, laborCost));
            editOrder.setMaterialTotal(myBL.materialTotal(newArea, productCost));
            editOrder.setTax(myBL.tax(newArea, taxRate, laborCost, productCost));
            editOrder.setTotalCost(myBL.total(taxRate, laborCost, productCost));
            orderDao.editOrder(editOrder, date);
        }
    }

}
