package Module_6.ComposerApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.util.Scanner;
import java.util.List;

// TestComposerApp Class
public class TestComposerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        MemComposerDao dao = new MemComposerDao(); // Create a new MemComposerDao object
        int option; // Variable to store user option

        System.out.println("Welcome to the Composer App");

        // Display menu options and prompt user for input
        do {
            System.out.println("\nMENU OPTIONS");
            System.out.println("  1. View Composers");
            System.out.println("  2. Find Composer");
            System.out.println("  3. Add Composer");
            System.out.println("  4. Exit");
            System.out.print("\nPlease choose an option: ");
            option = scanner.nextInt(); // Read user input
            scanner.nextLine(); // Consume the newline character

            // Process user input based on the selected option
            switch (option) {
                case 1: // Display all composers
                    List<Composer> composers = dao.findAll(); // Get the list of composers
                    System.out.println("\n\n--DISPLAYING COMPOSERS--");
                    // Loop through the list of composers and print each one
                    for (Composer c : composers) {
                        System.out.println(c + "\n"); // Print composer details
                    } // End for loop
                    System.out.println("");
                    break; // End case 1

                case 2: // Find a composer by ID
                    System.out.print("\nEnter an id: ");
                    int id = scanner.nextInt(); // Read user input for ID
                    scanner.nextLine(); // Consume the newline character
                    Composer composer = dao.findBy(id); // Find the composer by ID
                    // Check if the composer was found
                    if (composer != null) {
                        System.out.println("\n\n--DISPLAYING COMPOSER--");
                        System.out.println(composer); // Print composer details
                    } else {
                        System.out.println("\nComposer not found.");
                    } // End if Else statements
                    break; // End case 2

                case 3: // Add a new composer
                    System.out.print("\nEnter an id: ");
                    int newId = scanner.nextInt(); // Read user input for new ID
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter a name: ");
                    String name = scanner.nextLine(); // Read user input for name
                    System.out.print("Enter a genre: ");
                    String genre = scanner.nextLine(); // Read user input for genre
                    dao.insert(new Composer(newId, name, genre)); // Insert the new composer
                    break; // End case 3

                case 4: // Exit the program
                    System.out.println("\nProgram terminated by the user...");
                    break; // End case 4

                default: // Invalid option
                    System.out.println("\nInvalid option.");
            } // End switch statement
        } while (option != 4); // Continue until user chooses to exit

        scanner.close(); // Close the scanner
    } // End main method
} // End of TestComposerApp class