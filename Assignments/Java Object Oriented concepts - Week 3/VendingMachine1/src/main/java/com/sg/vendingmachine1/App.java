/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine1;



import java.io.IOException;
import com.sg.vendingmachine1.ops.ItemController;
/**
 *
 * @author apprentice
 * 
 */
public class App {
    public static void main(String[] args){
        
        ItemController ic = new ItemController();
        
        ic.run();
        
    }
}
    


