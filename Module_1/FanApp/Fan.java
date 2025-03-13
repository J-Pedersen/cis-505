package Module_1.FanApp;

// Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.

// Fan.java
public class Fan {
    // Constants for fan speeds
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private fields
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // No-argument constructor (default values)
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6.0;
        this.color = "white";
    }

    // Argument constructor
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    // Accessor and mutator methods (getters and setters)
    // Getter and Setter for Speed
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Getter and Setter for On
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    // Getter and Setter for Radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Getter and Setter for Color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Override toString method
    // Returns a string representation of the fan
    // If the fan is on, it returns the speed, color, and radius
    // If the fan is off, it returns the color and radius
    @Override
    public String toString() {
        if (on) {
            return "The fan speed is set to " + speed + " with a color of " + color + " and radius of " + radius;
        } else {
            return "The fan is " + color + " with a radius of " + radius + " and the fan is off";
        }
    }
}
