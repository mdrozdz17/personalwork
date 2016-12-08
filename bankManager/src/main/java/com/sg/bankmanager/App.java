/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bankmanager;

import com.sg.bankmanager.controller.AccountsController;

/**
 *
 * @author apprentice
 */
public class App {
        public static void main(String[] args) {
        AccountsController controller = new AccountsController();
        controller.run();
    }
}
 

