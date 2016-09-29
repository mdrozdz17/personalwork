/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.webaddressesarray;

import java.net.URL;
import java.util.Scanner;

class Address
{
	String street;
	String city;
	String state;
	int zip;
}

public class WebAddressesArray
{
	public static void main(String[] args) throws Exception
	{
            // Using 
		URL addys = new URL("http://www.writeurl.com/publish/khr5dz2u9878dqwtl5pk");

		Address[] addybook = new Address[6];

	        Scanner sc = new Scanner( addys.openStream() );

		for ( int i=0; i< addybook.length; i++ )
		{
			addybook[i] = new Address();
			addybook[i].street = sc.nextLine();
			addybook[i].city   = sc.nextLine();
			addybook[i].state  = sc.next();
			addybook[i].zip    = sc.nextInt();
			sc.skip("\n");
		}
		sc.close();
		
		for ( int i=0; i< 6; i++ )
		{
			System.out.println((i+1) + ". " + addybook[i].street + ", " + addybook[i].city + ", " + addybook[i].state + "  " + addybook[i].zip);
		}
	}
}
