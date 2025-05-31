package Module_12.GradeBookApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

// Student Class
public class Student {
    private String firstName; // First name of the student
    private String lastName; // Last name of the student
    private String course; // Course name
    private String grade; // Grade received

    // Constructor for Student class
    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName; // Initialize first name
        this.lastName = lastName; // Initialize last name
        this.course = course; // Initialize course name
        this.grade = grade; // Initialize grade received
    } // End of Student constructor

    // Getters for Student class
    public String getFirstName() { return firstName; } // Getter for first name
    public String getLastName() { return lastName; } // Getter for last name
    public String getCourse() { return course; } // Getter for course name
    public String getGrade() { return grade; } // Getter for grade received

    // Setters for Student class
    public void setFirstName(String firstName) { this.firstName = firstName; } // Setter for first name
    public void setLastName(String lastName) { this.lastName = lastName; } // Setter for last name
    public void setCourse(String course) { this.course = course; } // Setter for course name
    public void setGrade(String grade) { this.grade = grade; } // Setter for grade received

    @Override
    public String toString() { // Override toString method for custom string representation
        return firstName + " " + lastName + " | " + course + " | " + grade; // String representation of the Student object
    } // End of toString method
} // End of Student class
