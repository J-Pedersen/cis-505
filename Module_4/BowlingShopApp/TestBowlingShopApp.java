package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

import java.util.Scanner;

// TestBowlingShopApp class
public class TestBowlingShopApp {
    public static void displayMenu() { // Display menu options
        System.out.println("\nMENU OPTIONS");
        System.out.println("  1. <b> Bowling Balls");
        System.out.println("  2. <a> Bowling Bags");
        System.out.println("  3. <s> Bowling Shoes");
        System.out.println("  4. <x> To exit");
        System.out.print("\nPlease choose an option: ");
    } // End of displayMenu method

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        String userEntry; // User's menu entry
        
        System.out.println("Welcome to the Bowling Shop\n"); // Welcome message
        do { 
            displayMenu(); // Display menu options
            userEntry = scanner.nextLine().trim().toLowerCase(); // Get user input
            if (!userEntry.equals("x")) { // Check if user did not choose to exit
                GenericQueue<Product> products = ProductDB.getProducts(userEntry); // Get products based on user entry
                
                if (products.size() > 0) { // Check if there are products in the queue
                    System.out.println("\n--Product Listing--");
                    while (products.size() > 0) { // While there are products in the queue
                        System.out.println(products.dequeue() + "\n"); // Display product details
                    } // End of while
                } else { // If no products found
                    System.out.println("\nInvalid selection!\nPlease enter <b> <a> <s> or <x>"); // Error message for invalid selection
                } // End of else
            } // End of if
        } // End of do
        while (!userEntry.equals("x")); // Continue until user enters 'x'
        System.out.println("\nEnd of Line..."); // End message
        scanner.close(); // Close the scanner
    } // End of main method
} // End of TestBowlingShopApp class