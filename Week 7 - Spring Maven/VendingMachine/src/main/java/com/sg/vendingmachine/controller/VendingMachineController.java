/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.model.Item;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
public class VendingMachineController {
  private VendingMachineDao dao;  
  
  @Inject
  public VendingMachineController(VendingMachineDao dao){
      this.dao = dao;
  }
  
    @RequestMapping(value="displayNewItemFormNoAjax", method=RequestMethod.GET)
    public String displayNewItemFormNoAjax(){
        return "newItemFormNoAjax";
    }
    
    @RequestMapping(value="/displayEditItemFormNoAjax", method=RequestMethod.GET)
    public String displayEditItemFormNoAjax(HttpServletRequest req, Model model){
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        
        Item itemToEdit = dao.getItemById(itemId);
        
        model.addAttribute("item",itemToEdit);
        // Return the logical view name
        return "editItemFormNoAjax";
        
    }
    
    @RequestMapping(value="/editItemNoAjax", method=RequestMethod.POST)
    public String editItemNoAjax(@Valid @ModelAttribute("item") Item item, BindingResult result){
        // If there are errors, display the form with those error messages
        if (result.hasErrors()){
            return "editItemFormNoAjax";
        }
      
        dao.updateItem(item);
       
        return "redirect:displayInventoryListNoAjax";
    }
    
  
    @RequestMapping(value="/deleteItemNoAjax",method=RequestMethod.GET)
    public String deleteItemNoAjax(HttpServletRequest req){
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        dao.removeItem(itemId);
        return "redirect:displayInventoryListNoAjax";
    }
    
    
    
    
    // The RequestMapping, name of method, and view match in this case.
    // THIS IS NOT A REQUIREMENT!!
    
    @RequestMapping(value="/displayInventoryListNoAjax", method=RequestMethod.GET)
    public String displayInventoryListNoAjax(Model model){
        List<Item> allItems = dao.getAllItems();
        model.addAttribute("itemList",allItems);
        // return the logical view
        return "displayInventoryListNoAjax";
    }
    
     // Purely for testing purposes
    @RequestMapping(value = "loadInventory", method = RequestMethod.POST)
    public String loadInventory() {
        Item i1 = new Item();
        i1.setCost(0.85);
        i1.setName("Chips");
        i1.setNumInInventory(5);

        dao.addItem(i1);

         Item i2 = new Item();
        i2.setCost(0.95);
        i2.setName("Candy");
        i2.setNumInInventory(3);

        dao.addItem(i2);

           Item i3 = new Item();
        i3.setCost(1.05);
        i3.setName("HoneyBun");
        i3.setNumInInventory(4);

        dao.addItem(i3);
        
        return "redirect:displayInventoryListNoAjax";
    }
}
