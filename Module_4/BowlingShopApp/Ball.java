package Module_4.BowlingShopApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

// Ball class
public class Ball extends Product {
    private String color = ""; // Color of the ball
    
    // No argument constructor
    public Ball() {
        this.color = "";
    } // End of no argument constructor
    
    // Getter for color
    public String getColor() {
        return color; // Getter for color
    } // End of getter for color

    // Setter for color
    public void setColor(String color) {
        this.color = color; // Setter for color
    } // End of setter for color
    
    @Override // Override toString method to include ball color
    public String toString() {
        return super.toString() + "\nColor: " + color; // Call super class toString and append color
    } // End of toString method
} // End of Ball class
