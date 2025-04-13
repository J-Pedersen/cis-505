package Module_5.ExpenseTracker;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// TransactionIO class
public class TransactionIO {

    private static final String FILE_NAME = "expenses.txt"; // File name for storing transactions
    private static File file = new File(FILE_NAME); // File object

    // Method to create a new file if it doesn't exist
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null; // PrintWriter object for writing to the file

        // Check if the file exists, if not create a new one
        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(file, true)); // Append mode
        } else {
            output = new PrintWriter(FILE_NAME); // Create a new file
        } // End of if else statements

        // For loop to write each transaction to the file
        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " "); // Write date to file
            output.print(tran.getDescription() + " "); // Write description to file
            output.println(tran.getAmount()); // Write amount to file
        } // End of for loop

        output.close(); // Close the PrintWriter
    } // End of bulkInsert method

    // Method to read all transactions from the file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>(); // ArrayList to store transactions

        // Check if the file exists, if not return an empty list
        if (!file.exists()) {
            return transactions; // Return empty list if file doesn't exist
        } // End of if statement

        Scanner input = new Scanner(file); // Scanner object for reading the file

        // While loop to read each line from the file
        while (input.hasNext()) {
            String date = input.next(); // Read date from file
            String description = input.next(); // Read description from file
            double amount = input.nextDouble(); // Read amount from file

            Transaction tran = new Transaction(date, description, amount); // Create a new Transaction object
            transactions.add(tran); // Add transaction to the list
        } // End of while loop

        input.close(); // Close the Scanner
        return transactions; // Return the list of transactions
    } // End of findAll method
} // End of TransactionIO class