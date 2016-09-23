/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.storingdatainafile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */

class Car
{
	String Make;
	String Model;
	int Year;
	String License;
}
public class StoringDataInAFile {
    
    public static void main(String[] args) throws Exception {
        
        URL auto = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");
        
    
    
    Car[] carType = new Car[5];
   
    		 Scanner sc = new Scanner( auto.openStream() );


		for ( int i=0; i< carType.length; i++ )
		{
			carType[i] = new Car();
			carType[i].Make = sc.nextLine();
			carType[i].Model   = sc.nextLine();
			carType[i].Year  = sc.nextInt();
			carType[i].License = sc.nextLine();
			sc.skip("\n");
		}
		sc.close();
		
		for ( int i=0; i< 5; i++ )
		{
			System.out.println((i+1) + ". " + carType[i].Make + ", " + carType[i].Model + ", " + carType[i].Year + "  " + carType[i].License);
		}
	}
}

    

