
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class Factorizer {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int number = 0; // initialize number variable
        int factor; // define variable for input

        //Ask user what number they want to factor
        System.out.println("What number would you like to factor");
        
        // Tell the user what the factors of their input is
        factor = sc.nextInt();
        System.out.println("The factors of " + factor + " are:");
        
        // Define variable i = 1. Keep counting until number is 1 less than user inputed number.

        for (int i = 1; i < factor; i++) {
            
            // If number has no remainder than print number and keep counting 
            // until you are at 1 less than user input.

            if (factor % i == 0) {
                System.out.println(i);
                number = number + i;

            }
        }
        
        // If input number = 1 and itself than the number is Perfect otherwise it is not.
        if (factor == number) {
            System.out.println("Number is Perfect!");
        } else {
            System.out.println("Number is not Perfect!");

        }
        
        // If input number = 1 than the number is Prime otherwise it is not.

        if (number == 1) {
            System.out.println("Number is Prime!");
        } else {
            System.out.println("Number is not Prime!");

        }
    }

}
