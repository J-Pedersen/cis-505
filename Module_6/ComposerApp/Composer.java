package Module_6.ComposerApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

// Composer Class
public class Composer {
    private int id;
    private String name;
    private String genre;

    // No-argument constructor
    public Composer() {
        this.id = 0; // Initialize ID to 0
        this.name = ""; // Initialize name to an empty string
        this.genre = ""; // Initialize genre to an empty string
    } // End no-argument constructor

    // Argument constructor
    public Composer(int id, String name, String genre) {
        this.id = id; // Set the ID
        this.name = name; // Set the name
        this.genre = genre; // Set the genre
    } // End argument constructor

    // Get ID method
    public int getId() {
        return id; // Return the ID
    } // End getId method

    // Set ID method
    public String getName() {
        return name; // Return the name
    } // End getName method

    // Set Name method
    public String getGenre() {
        return genre; // Return the genre
    } // End getGenre method

    @Override
    // toString method to return a string representation of the composer
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nGenre: " + genre; // Format the output string
    } // End toString method
} // End of Composer class