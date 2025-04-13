package Module_5.ExpenseTracker;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.util.Scanner;

// ValidatorIO class
public class ValidatorIO {
 
    // getInt method to validate integer input
    public static int getInt(Scanner sc, String prompt) {
        int input = 0; // Variable to store user input
        boolean isValid = false; // Flag to check if input is valid

        // Loop until valid input is received
        while (!isValid) {
            System.out.print(prompt); // Display the prompt

            // Check if the next input is an integer
            if (sc.hasNextInt()) {
                input = sc.nextInt(); // Read the integer input
                isValid = true; // Set the flag to true to exit the loop
            } else {
                System.out.println("\nError! Invalid integer value.");
            } // End of if else statements
            sc.nextLine(); // Clear the buffer
        } // End of while loop

        return input; // Return the valid integer input
    } // End of getInt method

    // getDouble method to validate double input
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0.0; // Variable to store user input
        boolean isValid = false; // Flag to check if input is valid

        // Loop until valid input is received
        while (!isValid) {
            System.out.print(prompt); // Display the prompt

            // Check if the next input is a double
            if (sc.hasNextDouble()) {
                input = sc.nextDouble(); // Read the double input
                isValid = true; // Set the flag to true to exit the loop
            } else {
                System.out.println("\n\nError! Invalid decimal value.\n");
            } // End of if else statements
            sc.nextLine(); // Clear the buffer
        } // End of while loop

        return input; // Return the valid double input
    } // End of getDouble method

    // getString method to read string input
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt); // Display the prompt
        return sc.next(); // Read and return the string input
    } // End of getString method
} // End of ValidatorIO class
