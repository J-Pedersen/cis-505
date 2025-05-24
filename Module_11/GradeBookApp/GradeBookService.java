package Module_11.GradeBookApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import javafx.collections.*;

// GradeBookService Class
public class GradeBookService {
    
    private final String fileName; // File name for the CSV file

    // Constructor for GradeBookService
    public GradeBookService(String fileName) {
        this.fileName = fileName; // Initialize file name
    } // End of constructor

    // Method to save a new student entry
    public void saveStudent(Student student) throws IOException {
        File file = new File(fileName); // Create a new file object
        boolean newFile = file.length() == 0; // Check if the file is empty

        // Create parent directories if they do not exist
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            // Append to the file
            if (newFile) {
                writer.write("firstName,lastName,course,grade\n"); // Write header if new file
            } // End of if statement

            writer.write(String.format("%s,%s,%s,%s\n", // Write student data to the file
                    student.getFirstName(), // Get first name
                    student.getLastName(), // Get last name
                    student.getCourse(), // Get course name
                    student.getGrade())); // Get grade received
        } // End of try-with-resources block
    } // End of saveStudent method

    // Method to update a student entry
    public void updateStudent(Student updatedStudent) {
        
        List<Student> all = readAll(); // Read existing records

        // Find the student to update
        for (int i = 0; i < all.size(); i++) {
            Student s = all.get(i); // Get current student
            // Check if the current student matches the updated student
            if (s.getFirstName().equals(updatedStudent.getFirstName()) &&
                s.getLastName().equals(updatedStudent.getLastName()) &&
                s.getCourse().equals(updatedStudent.getCourse())) {
                all.set(i, updatedStudent); // Replace with updated
                break; // Exit loop after updating
            } // End of if statement
        } // End of for loop
 
        writeAll(all); // Overwrite CSV with updated list
    } // End of updateStudent method

    // Method to delete a student entry
    public void deleteStudent(Student studentToDelete) {

        List<Student> students = readAll(); // Read existing records
    
        // Filter out the student to delete
        List<Student> updatedList = students.stream()
            .filter(s -> !(s.getFirstName().equals(studentToDelete.getFirstName()) &&
                           s.getLastName().equals(studentToDelete.getLastName()) &&
                           s.getCourse().equals(studentToDelete.getCourse()) &&
                           s.getGrade().equals(studentToDelete.getGrade())))
            .collect(Collectors.toList()); // Collect remaining students
    
        writeAll(updatedList); // Overwrite CSV with updated list
    } // End of deleteStudent method

    // Method to Load all student records from the CSV file
    public ObservableList<Student> loadStudents() throws IOException {
        // Read all lines from the CSV file and convert to ObservableList
        ObservableList<Student> students = FXCollections.observableArrayList();
        List<String> lines = Files.readAllLines(Paths.get(fileName)); // Read all lines from the file
        // Skip the header line and parse each line into a Student object
        for (String line : lines) {
            // Skip the header line
            if (!line.startsWith("firstName")) {
                String[] parts = line.split(","); // Split line by comma
                // Check if the line has the correct number of parts
                if (parts.length == 4) {
                    students.add(new Student(parts[0], parts[1], parts[2], parts[3])); // Create new Student object
                } // End of if statement
            } // End of if statement
        } // End of for loop
        return students; // Return the list of students
    } // End of loadStudents method

    // Method to read all student records from the CSV file
    private List<Student> readAll() {
        // Read all lines from the CSV file and convert to List<Student>
        List<Student> students = new ArrayList<>();
        // Read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line; // Variable to hold each line
            // Read each line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (!line.startsWith("firstName")) {
                    String[] tokens = line.split(","); // Split line by comma
                    // Check if the line has the correct number of tokens
                    if (tokens.length == 4) {
                        // Create a new Student object and add to the list
                        Student student = new Student(tokens[0], tokens[1], tokens[2], tokens[3]);
                        students.add(student); // Add student to the list
                    } // End of if statement
                } // End of if statement
            } // End of while loop
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an error occurs
        } // End of try-with-resources block
        return students; // Return the list of students
    } // End of readAll method

    // Method to write all student records to the CSV file
    private void writeAll(List<Student> students) {
        // Write all student records to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("firstName,lastName,course,grade\n"); // Write header
            // Write each student record
            for (Student student : students) {
                writer.write(String.format("%s,%s,%s,%s\n", // Format the student data
                        student.getFirstName(), // Get first name
                        student.getLastName(), // Get last name
                        student.getCourse(), // Get course name
                        student.getGrade())); // Get grade received
            } // End of for loop
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an error occurs
        } // End of try-with-resources block
    } // End of writeAll method
} // End of GradeBookService class