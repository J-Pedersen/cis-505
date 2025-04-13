package Module_5.ExpenseTracker;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Transaction class
public class Transaction {
    private String date; // Date of the transaction
    private String description; // Description of the transaction
    private double amount; // Amount of the transaction

    // DateTimeFormatter to format the date
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    // No-arg constructor
    public Transaction() {
        this.date = LocalDate.now().format(FORMATTER); // Set date
        this.description = ""; // Initialize description
        this.amount = 0.0; // Initialize amount
    } // End of no-arg constructor

    // 2-arg constructor
    public Transaction(String description, double amount) {
        this.date = LocalDate.now().format(FORMATTER); // Set date
        this.description = description; // Set description
        this.amount = amount; // Set amount
    } // End of 2-arg constructor

    // 3-arg constructor
    public Transaction(String date, String description, double amount) {
        this.date = LocalDate.now().format(FORMATTER); // Set date
        this.description = description; // Set description
        this.amount = amount; // Set amount
    } // End of 3-arg constructor

    // Date getter method
    public String getDate() {
        return date; // Return the date of the transaction
    } // End of date getter method

    // Date setter method
    public void setDate(String date) {
        this.date = date; // Set the date of the transaction
    } // End of date setter method

    // Description getter method
    public String getDescription() {
        return description; // Return the description of the transaction
    } // End of description getter method

    // Description setter method
    public void setDescription(String description) {
        this.description = description; // Set the description of the transaction
    } // End of description setter method

    // Amount getter method
    public double getAmount() {
        return amount; // Return the amount of the transaction
    } // End of amount getter method

    // Amount setter method
    public void setAmount(double amount) {
        this.amount = amount; // Set the amount of the transaction
    } // End of amount setter method

    // Override toString method
    @Override
    // toString method to return a string representation of the transaction
    public String toString() {
        return "Date: " + date + "\n" +
               "Description: " + description + "\n" +
               "Amount: $" + String.format("%.2f", amount);
    } // End of toString method
} // End of Transaction class