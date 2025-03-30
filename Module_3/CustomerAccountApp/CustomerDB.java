package Module_3.CustomerAccountApp;

/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

public class CustomerDB {
    // Method to get customer details based on ID
    public static Customer getCustomer(Integer id) {
        if (id == 1007) {
            return new Customer("Jennifer Patterson", "8422 Grover Ave.", "Bellevue", "68123");
        } else if (id == 1008) {
            return new Customer("Freddy Kruger", "1428 Elm St.", "Springfield", "45501");
        } else if (id == 1009) {
            return new Customer("Peter Griffin", "31 Spooner St.", "Quahog", "12345");
        } else {
            return new Customer(); // Return default customer
        }
    } // End of getCustomer method
} // End of CustomerDB class

