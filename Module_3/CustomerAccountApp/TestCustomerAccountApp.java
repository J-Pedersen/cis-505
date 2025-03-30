package Module_3.CustomerAccountApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

import java.util.Scanner;

public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for customer ID number
        System.out.print("Enter customer number (1007-1009): ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Get the customer from CustomerDB
        Customer customer = CustomerDB.getCustomer(customerId);
        
        // Create an Account object
        Account account = new Account();
        
        char choice; // Variable to store menu choice
        char continueChoice; // Variable to store continue choice

        do { // Display menu and get user choice
            account.displayMenu(); // Display account menu
            System.out.print("  Enter an option>: ");
            choice = scanner.next().charAt(0); // Get user choice
            
            if (choice == 'b' || choice == 'B') { // Check balance
                System.out.printf("\nCurrent Balance: $%,6.2f%n", account.getBalance());
            } else if (choice == 'd' || choice == 'D') { // Deposit money
                System.out.print("\nEnter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
            } else if (choice == 'w' || choice == 'W') { // Withdraw money
                System.out.print("\nEnter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
            } else { // Invalid option
                System.out.println("\nError: Invalid option");
            }

            System.out.print("\nContinue? (y/n): "); // Ask if user wants to continue
            continueChoice = scanner.next().charAt(0); // Get user choice
            scanner.nextLine(); // Consume newline
            
        } while (continueChoice == 'y' || continueChoice == 'Y'); // Continue loop if user chooses 'y' or 'Y'
        
        // Display customer details and account balance
        System.out.println("\n--Customer Details--");
        System.out.println(customer);
        System.out.printf("\nBalance as of %s: $%,6.2f%n", account.getTransactionDate(), account.getBalance());
        System.out.println("\nEnd of line...");

        scanner.close(); // Close the scanner
    } // End of main method
} // End of TestCustomerAccountApp class