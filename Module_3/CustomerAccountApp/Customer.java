package Module_3.CustomerAccountApp;

/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

public class Customer {
    // Private data fields
    private String name;
    private String address;
    private String city;
    private String zip;

    // No-argument constructor
    public Customer() {
        this.name = "";
        this.address = "";
        this.city = "";
        this.zip = "";
    } // End of no-argument constructor

    // Argument constructor
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    } // End of argument constructor

    // Accessor methods
    public String getName() {
        return name;
    } // End of getName method

    public String getAddress() {
        return address;
    } // End of getAddress method

    public String getCity() {
        return city;
    } // End of getCity method

    public String getZip() {
        return zip;
    } // End of getZip method

    // Override toString method
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
               "Address: " + address + "\n" +
               "City: " + city + "\n" +
               "Zip: " + zip;
    } // End of toString method
} // End of Customer class
