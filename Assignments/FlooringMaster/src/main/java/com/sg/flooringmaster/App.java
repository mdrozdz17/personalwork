/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmaster;

import com.sg.flooringmaster.ops.FlooringMasterController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class App {
        public static void main(String[] args)  {
        
       ApplicationContext ctx = new
       ClassPathXmlApplicationContext("applicationContext.xml");        

      // FlooringMasterController controller = (FlooringMasterController) ctx.getBean("FlooringMasterControllerInMem");
       FlooringMasterController controller = (FlooringMasterController) ctx.getBean("FlooringMasterControllerFileIO");

        controller.run();
    }
    
}
