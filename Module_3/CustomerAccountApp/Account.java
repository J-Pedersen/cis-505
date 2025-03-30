package Module_3.CustomerAccountApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    // Private data field
    private double balance = 200;

    // Accessor method for balance
    public double getBalance() {
        return balance;
    } // End of getBalance method

    // Method to deposit amount
    public void deposit(double amt) {
        balance += amt;
    } // End of deposit method

    // Method to withdraw amount
    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        } else {
            System.out.println("Insufficient balance.");
        }
    } // End of withdraw method

    // Method to display the account menu
    public void displayMenu() {
        System.out.println("\nAccount Menu");
        System.out.println("Enter <D/d> for deposit ");
        System.out.println("Enter <W/w> for withdraw");
        System.out.println("Enter <B/b> for balance");
    } // End of displayMenu method

    // Method to get the current transaction date
    public String getTransactionDate() { // Get the current date
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        return sdf.format(new Date()); // Return the formatted date
    } // End of getTransactionDate method
} // End of Account class