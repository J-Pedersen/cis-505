package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

// Shoe class
public class Shoe extends Product {
    private double size = 0; // Shoe size
    
    // No argument constructor
    public Shoe() {
        this.size = 0;
    } // End of no argument constructor
    
    // Getter for size
    public double getSize() {
        return size; // Getter for size
    } // End of getter for size

    // Setter for size
    public void setSize(double size) {
        this.size = size; // Setter for size
    } // End of setter for size
    
    @Override // Override toString method to include shoe size
    public String toString() {
        return super.toString() + "\nSize: " + size; // Call super class toString and append size
    } // End of toString method
} // End of Shoe class