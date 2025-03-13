package Module_1.FanApp;

// Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.

// TestFanApp.java
public class TestFanApp {
    public static void main(String[] args) {
        // Create the default fan
        Fan defaultFan = new Fan();

        // Create a custom fan
        Fan customFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display the fan details
        System.out.println(defaultFan);
        System.out.println(customFan);
    }
}
