/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.webaddresses;

/**
 *
 * @author apprentice
 */
import java.net.URL;
import java.util.Scanner;

class Address
{
	String street;
	String city;
	String state;
	int zip;
}


public class WebAddresses {
    
	public static void main(String[] args) throws Exception
	{
		URL addys = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");
		Scanner sc = new Scanner( addys.openStream() );

		Address uno = new Address();
		uno.street = sc.nextLine();
		uno.city   = sc.nextLine();
		uno.state  = sc.next();
		uno.zip    = sc.nextInt();
		sc.skip("\n");

		Address dos = new Address();
		dos.street = sc.nextLine();
		dos.city   = sc.nextLine();
		dos.state  = sc.next();
		dos.zip    = sc.nextInt();
		sc.skip("\n");

		Address tre = new Address();
		tre.street = sc.nextLine();
		tre.city   = sc.nextLine();
		tre.state  = sc.next();
		tre.zip    = sc.nextInt();
		sc.skip("\n");
                
                Address four = new Address();
		four.street = sc.nextLine();
		four.city   = sc.nextLine();
		four.state  = sc.next();
		four.zip    = sc.nextInt();
		sc.skip("\n");
                
                Address five = new Address();
		five.street = sc.nextLine();
		five.city   = sc.nextLine();
		five.state  = sc.next();
		five.zip    = sc.nextInt();
		sc.skip("\n");
		
		sc.close();
		
		System.out.println(uno.street + ", " + uno.city + ", " + uno.state + "  " + uno.zip);
		System.out.println(dos.street + ", " + dos.city + ", " + dos.state + "  " + dos.zip);
		System.out.println(tre.street + ", " + tre.city + ", " + tre.state + "  " + tre.zip);
                System.out.println(four.street + ", " + four.city + ", " + four.state + "  " + four.zip);
                System.out.println(five.street + ", " + five.city + ", " + five.state + "  " + five.zip);
	}
}
