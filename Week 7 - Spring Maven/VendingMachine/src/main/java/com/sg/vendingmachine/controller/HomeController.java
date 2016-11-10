/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author apprentice
 */

 @Controller
public class HomeController {
        // Our DAO for the controller - will be wired up for dependency injection
    private VendingMachineDao dao;

    @Inject
    public HomeController(VendingMachineDao dao) {
        this.dao = dao;
    }
    
     @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "home";
    }

}
  

