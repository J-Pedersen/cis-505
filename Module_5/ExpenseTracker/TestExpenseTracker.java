package Module_5.ExpenseTracker;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// TestExpenseTracker class
public class TestExpenseTracker {
 
    // Method to display the menu options
    public static String menu() {
        // Display the menu options
        return "\nMENU OPTIONS\n"
             + "   1. View Transactions\n"
             + "   2. Add Transactions\n"
             + "   3. View Expense\n\n"
             + "Please choose an option: ";
    } // End of menu method

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object for user input
        String continueChoice = "y"; // Variable to control the loop
 
        System.out.println("Welcome to the Expense Tracker");
 
        // Display the menu and prompt for user input
        while (continueChoice.equalsIgnoreCase("y")) {
            int input = ValidatorIO.getInt(sc, menu()); // Get user input for menu option
 
            // Check the user input and perform the corresponding action
            if (input == 1) {
                System.out.println("\nMONTHLY EXPENSES\n");
                // Display the transactions
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll(); // Read all transactions from the file
 
                    // Check if the transactions list is empty
                    for (Transaction transaction : transactions) {
                        System.out.println("Date: " + transaction.getDate()); // Display the date of the transaction
                        System.out.println("Description: " + transaction.getDescription()); // Display the description of the transaction
                        System.out.printf("Amount: $%,6.2f\n\n", transaction.getAmount()); // Display the amount of the transaction
                    } // End of for loop
                } catch (IOException e) {
                    System.out.println("Exception: " + e.getMessage()); // Handle any IO exceptions
                } // End of try catch block
 
                continueChoice = ValidatorIO.getString(sc, "Continue? (y/n): "); // Ask if the user wants to continue
            } // End of if statement
 
            // Check if the user wants to add more transactions
            else if (input == 2) {
                String c = "y"; // Variable to control the loop for adding transactions
                ArrayList<Transaction> transactions = new ArrayList<>(); // ArrayList to store transactions
                
                // Prompt for user input to add transactions
                while (c.equalsIgnoreCase("y")) {
                    String description = ValidatorIO.getString(sc, "\nEnter the description: "); // Get the description of the transaction
                    double amount = ValidatorIO.getDouble(sc, "Enter the amount: "); // Get the amount of the transaction
 
                    Transaction transaction = new Transaction(description, amount); // Create a new Transaction object
                    transactions.add(transaction); // Add the transaction to the list
 
                    c = ValidatorIO.getString(sc, "\nAdd another transaction? (y/n): "); // Ask if the user wants to add another transaction
                } // End of while loop
 
                // Write the transactions to the file
                try {
                    TransactionIO.bulkInsert(transactions); // Call the method to write transactions to the file
                } catch (IOException e) {
                    System.out.println("Exception: " + e.getMessage()); // Handle any IO exceptions
                } // End of try catch block
 
                continueChoice = ValidatorIO.getString(sc, "\nContinue? (y/n): "); // Ask if the user wants to continue
            } // End of else if statement
 
            // Check if the user wants to view the total monthly expense
            else if (input == 3) {
                double monthlyExpense = 0; // Variable to store the total monthly expense
 
                // Display the total monthly expense
                try {
                    ArrayList<Transaction> transactions = TransactionIO.findAll(); // Read all transactions from the file
 
                    // Calculate the total monthly expense
                    for (Transaction transaction : transactions) {
                        monthlyExpense += transaction.getAmount(); // Add the amount of each transaction to the total
                    } // End of for loop
 
                    // Display the total monthly expense
                    System.out.printf("\nYour total monthly expense is $%,.2f\n", monthlyExpense);
 
                } catch (IOException e) {
                    System.out.println("Exception: " + e.getMessage()); // Handle any IO exceptions
                } // End of try catch block
 
                continueChoice = ValidatorIO.getString(sc, "\nContinue? (y/n): "); // Ask if the user wants to continue
            } // End of else if statement

            // Check if the user input is invalid
            else {
                System.out.println("\nInvalid menu option. Please try again."); // Display error message
            } // End of else statement
        } // End of while loop
 
        System.out.println("\nProgram terminated by the user..."); // Display app closing message
        sc.close(); // Close the Scanner object
    } // End of main method
 
} // End of TestExpenseTracker class