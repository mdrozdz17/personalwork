
import java.util.Random;
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
public class LuckySevens {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int die1; // declare dice1
        int die2; // declare dice2
        int money; // How much $ was won or lost
        int mostMoneyHeld; // Most money held by the player at one point in time
        int rollCountMax; // Roll Count Max when user had the most money
        int rollCountTotal; // Total number of rolls when depletion was hit

        // Ask the user how many dollars they want to bet
        System.out.println("How many dollars do you have to bet?");
        money = sc.nextInt();

        // Variables Initialized
        mostMoneyHeld = money;
        rollCountMax = 0;
        rollCountTotal = 0;

        // Looping until all money is depleted 
        while (money > 0) {
            rollCountTotal++;

            // Rolls the dice randomly between 1 and 6
            Random rGen = new Random();
            die1 = rGen.nextInt(6) + 1;
            die2 = rGen.nextInt(6) + 1;

            // Winnings or Losings
            if (die1 + die2 == 7) {
                money += 4; // win $4
            } else {
                money -= 1; // lose $1
            }
            // If any totals are not the most than remember that value.
            if (money > mostMoneyHeld) {
                mostMoneyHeld = money;
                rollCountMax = rollCountTotal;

            }
        }

        // Display the results
        System.out.println("You are broke after " + rollCountTotal + " rolls");
        System.out.println(" You should have quit after " + rollCountMax
                + " rolls when you had $" + mostMoneyHeld + ".");

    }
}
