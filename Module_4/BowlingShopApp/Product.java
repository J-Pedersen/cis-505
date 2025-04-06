package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

// Product class
public class Product {
    private String code = ""; // Product code
    private String description = ""; // Product description
    private double price = 0.0; // Product price
    
    // No argument constructor
    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0;
    } // End of no argument constructor

    // Getter for code
    public String getCode() {
        return code; // Getter for code
    } // End of getter for code

    // Setter for code
    public void setCode(String code) {
        this.code = code; // Setter for code
    } // End of setter for code
    
    // Getter for description
    public String getDescription() {
        return description; // Getter for description
    } // End of getter for description

    // Setter for description
    public void setDescription(String description) {
        this.description = description; // Setter for description
    } // End of setter for description
    
    // Getter for price
    public double getPrice() {
        return price; // Getter for price
    } // End of getter for price

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    } // End of setter for price

    @Override // Override toString method to include product details
    public String toString() {
        return String.format("Code: %s\nDescription: %s\nPrice: $%,.2f", code, description, price);
    } // End of toString method
} // End of Product class