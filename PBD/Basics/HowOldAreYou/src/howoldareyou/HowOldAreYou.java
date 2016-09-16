/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package howoldareyou;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name;
        int age;

        Scanner sc = new Scanner(System.in);
        System.out.println("Hey, what's your name?");
        name = sc.nextLine();

        System.out.println("Ok, " + name + " how old are you?");
        age = sc.nextInt();

        if (age < 16) {
            System.out.println("You can't drive");

        } else if (age < 18) {
            System.out.println("You can't vote");
        } else if (age < 25) {
            System.out.println("You can't rent a car");
        } else if (age >= 25) {
            System.out.println("You can do anything that's legal");
        }

    }

}
