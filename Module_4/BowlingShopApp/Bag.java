package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

// Bag class
public class Bag extends Product {
    private String type = ""; // Type of bag
    
    // No argument constructor
    public Bag() {
        this.type = "";
    } // End of no argument constructor

    // Getter for type
    public String getType() {
        return type; // Getter for type
    } // End of getter for type
    
    // Setter for type
    public void setType(String type) {
        this.type = type; // Setter for type
    } // End of setter for type
    
    @Override // Override toString method to include bag type
    public String toString() {
        return super.toString() + "\nType: " + type; // Call super class toString and append type
    } // End of toString method
} // End of Bag class