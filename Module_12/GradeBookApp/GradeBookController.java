package Module_12.GradeBookApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

// GradeBookController Class
public class GradeBookController {
    private final GradeBookService service; // Service to handle data operations

    // Constructor for GradeBookController
    public GradeBookController(GradeBookService service) {
        this.service = service; // Initialize service
    } // End of constructor

    // Method to save a new entry
    public String saveEntry(TextField firstNameField, TextField lastNameField, TextField courseField, ComboBox<String> gradeComboBox) {
        String first = firstNameField.getText().trim(); // Get first name from the field
        String last = lastNameField.getText().trim(); // Get last name from the field
        String course = courseField.getText().trim(); // Get course name from the field
        String grade = gradeComboBox.getValue(); // Get selected grade from the combo box
    
        // Validate that all fields are filled
        if (first.isEmpty() || last.isEmpty() || course.isEmpty() || grade == null) {
            return "Please complete all fields."; // Return error message if any field is empty
        } // End of if statement
    
        Student student = new Student(first, last, course, grade); // Create a new Student object with the provided data
        // Check if the student already exists in the service
        try {
            service.saveStudent(student); // Save the student entry using the service
            clearForm(firstNameField, lastNameField, courseField, gradeComboBox); // Clear form fields after saving
            return "Grade entry saved."; // Return success message
        } catch (Exception e) {
            return "Failed to save entry."; // Show error if saving fails
        } // End of try-catch block
    } // End of saveEntry method

    // Method to clear form fields
    public void clearForm(TextField first, TextField last, TextField course, ComboBox<String> grade) {
        first.clear(); // Clear first name field
        last.clear(); // Clear last name field
        course.clear(); // Clear course name field
        grade.setValue(null); // Clear selected grade
    } // End of clearForm method

    // Method to display entries in the table view
    public void displayEntries(TableView<Student> tableView) {
        // Clear existing items in the table view
        try {
            ObservableList<Student> students = service.loadStudents(); // Load students from the service
            tableView.setItems(students); // Set the items in the table view
        } catch (Exception e) {
            showAlert("Error", "Could not read grades file."); // Show error if file cannot be read
        } // End of try-catch block
    } // End of displayEntries method

    // Reset the application to its default state
    public void resetApp(TextField firstNameField, TextField lastNameField,
                        TextField courseField, ComboBox<String> gradeComboBox,
                        HBox exportButtonContainer, TableView<Student> tableView,
                        StackPane saveUpdatePane, Button saveButton,
                        Student[] selectedStudent) {
        // Clear all fields and reset the application state
        clearForm(firstNameField, lastNameField, courseField, gradeComboBox);
        exportButtonContainer.setVisible(false); // Hide export button container
        tableView.getItems().clear(); // Clear table view items
        saveUpdatePane.getChildren().clear(); // Clear the save/update pane
        saveUpdatePane.getChildren().add(saveButton); // Add the save button back to the pane
        selectedStudent[0] = null; // Reset selected student reference
    } // End of resetApp method

    // Method to update an entry from the table view
    public void updateEntry(Student updatedStudent) {
        service.updateStudent(updatedStudent); // Update the student entry using the service
    } // End of updateEntry method

    // Method to update a selected student in the table view and CSV file
    public void updateSelectedStudent(Student student, TextField firstNameField, TextField lastNameField,
                                    TextField courseField, ComboBox<String> gradeComboBox,
                                    TableView<Student> tableView, StackPane saveUpdatePane,
                                    Button saveButton, Student[] selectedStudent) {
        student.setFirstName(firstNameField.getText()); // Update first name
        student.setLastName(lastNameField.getText()); // Update last name
        student.setCourse(courseField.getText()); // Update course name
        student.setGrade(gradeComboBox.getValue()); // Update selected grade

        tableView.refresh(); // Refresh the table view to show updated data
        updateEntry(student); // Save to file
        clearForm(firstNameField, lastNameField, courseField, gradeComboBox); // Clear form fields

        saveUpdatePane.getChildren().clear(); // Clear the save/update pane
        saveUpdatePane.getChildren().add(saveButton); // Add the save button back to the pane
        selectedStudent[0] = null; // Reset selected student reference
    } // End of updateSelectedStudent method

    // Method to delete a selected student from the table view and CSV file
    public void deleteSelectedStudent(Student selectedStudent, TableView<Student> tableView) {
        // Check if a student is selected
        if (selectedStudent != null) {
            tableView.getItems().remove(selectedStudent); // Remove from table view
            service.deleteStudent(selectedStudent); // Remove from CSV file
        } // End of if statement
    } // End of deleteSelectedStudent method

    // Method to export the table data to a CSV file
    public void exportTableToCSV(ObservableList<Student> students, File file) throws IOException {
        // Check if the file is valid
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Write CSV header
            writer.write("First Name,Last Name,Course,Grade\n");
            
            // Write each student record
            for (Student s : students) {
                writer.write(String.format("%s,%s,%s,%s\n", // Format the student data
                    s.getFirstName(), // Get first name
                    s.getLastName(), // Get last name
                    s.getCourse(), // Get course name
                    s.getGrade())); // Get grade received
            } // End of for loop
        } // End of try-with-resources block
    } // End of exportTableToCSV method
 
    // Method to set up the table columns for displaying student data
    public void setupTableColumns(TableView<Student> tableView) {
        TableColumn<Student, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        
        TableColumn<Student, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Student, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course"));

        TableColumn<Student, String> gradeCol = new TableColumn<>("Grade");
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.getColumns().add(firstNameCol); // Add first name column
        tableView.getColumns().add(lastNameCol); // Add last name column
        tableView.getColumns().add(courseCol); // Add course column
        tableView.getColumns().add(gradeCol); // Add grade column

        // Set column widths relative to table width
        firstNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.29));
        lastNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.29));
        courseCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.24));
        gradeCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
    }

    // Method to show an alert dialog with a message
    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg); // Create an information alert
        alert.setTitle(title); // Set the title of the alert
        alert.setHeaderText(null); // No header text
        alert.showAndWait(); // Show the alert and wait for user response
    } // End of showAlert method

} // End of GradeBookController class