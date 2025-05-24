package Module_11.GradeBookApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

// PedersenGradeBookApp Class
public class PedersenGradeBookApp extends Application {

    // =============================
    // ======= IO VARIABLES ========
    // =============================
    private TextField firstNameField; // TextField for first name input
    private TextField lastNameField; // TextField for last name input
    private TextField courseField; // TextField for course input
    private ComboBox<String> gradeComboBox; // ComboBox for grade selection
    private TableView<Student> tableView; // TableView to display student data
    private GradeBookController controller; // Controller for handling logic
    private HBox exportButtonContainer; // Holds the export button (needs to be reset)
    private StackPane saveUpdatePane; // Container for switching between Save and Update buttons
    private Button saveButton; // Save button reference
    private final Student[] selectedStudent = new Student[1]; // Holds selected student

    @Override
    public void start(Stage primaryStage) {

        // Initialize service and controller
        GradeBookService service = new GradeBookService("Module_11/GradeBookApp/grades.csv");
        controller = new GradeBookController(service); // Create a new controller instance

        // ============================
        // ===== INITIALIZE INPUTS ====
        // ============================
        firstNameField = new TextField(); // TextField for first name input
        lastNameField = new TextField(); // TextField for last name input
        courseField = new TextField(); // TextField for course input

        gradeComboBox = new ComboBox<>(); // ComboBox for grade selection
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F"); // Add grade options to ComboBox
        gradeComboBox.setPrefWidth(100); // Set preferred width for ComboBox

        // ============================
        // ==== INITIALIZE BUTTONS ====
        // ============================
        saveButton = new Button("Save"); // Button to save student data
        Button clearButton = new Button("Clear"); // Button to clear input fields
        Button viewButton = new Button("View Grades"); // Button to view grades
        Button updateButton = new Button("Update"); // Button to update student data
        Button exportButton = new Button("Export CSV"); // Button to export CSV file
        Button deleteButton = new Button("Delete"); // Button to delete student data

        // ============================
        // ==== BUTTON CSS CLASSES ====
        // ============================
        saveButton.getStyleClass().add("save-button"); // Add CSS class for save button
        clearButton.getStyleClass().add("clear-button"); // Add CSS class for clear button
        viewButton.getStyleClass().add("view-button"); // Add CSS class for view button
        updateButton.getStyleClass().add("update-button"); // Add CSS class for update button
        exportButton.getStyleClass().add("export-button"); // Add CSS class for export button
        deleteButton.getStyleClass().add("delete-button"); // Add CSS class for delete button

        // ============================
        // ====== BUTTON WIDTHS =======
        // ============================
        double buttonWidth = 150; // Set button width
        double buttonWidthSmall = 100; // Set smaller button width
        saveButton.setPrefWidth(buttonWidth); // Set preferred width for save button
        clearButton.setPrefWidth(buttonWidth); // Set preferred width for clear button
        viewButton.setPrefWidth(buttonWidth); // Set preferred width for view button
        updateButton.setPrefWidth(buttonWidth); // Set preferred width for update button
        exportButton.setPrefWidth(buttonWidth); // Set preferred width for export button
        deleteButton.setPrefWidth(buttonWidthSmall); // Set preferred width for delete button

        // =======================================
        // === EXPORT AND DELETE BUTTON LAYOUT ===
        // =======================================
        exportButtonContainer = new HBox(exportButton); // HBox for export button
        exportButtonContainer.setAlignment(Pos.TOP_RIGHT); // Align export button
        exportButtonContainer.setVisible(false); // hidden
        deleteButton.setVisible(false); // hidden

        // =========================================
        // ========== FORM INPUTS LAYOUT ===========
        // =========================================
        GridPane formGrid = new GridPane(); // Create a GridPane for layout
        formGrid.setHgap(10); // Horizontal spacing between columns
        formGrid.setVgap(10); // Vertical spacing between rows
        formGrid.addRow(0, new Label("First Name"), firstNameField); // Add first name label and field
        formGrid.addRow(1, new Label("Last Name"), lastNameField); // Add last name label and field
        formGrid.addRow(2, new Label("Course"), courseField); // Add course label and field
        HBox gradeRow = new HBox(10, gradeComboBox, deleteButton); // HBox for grade selection and delete button
        formGrid.addRow(3, new Label("Grade"), gradeRow); // Add grade label and HBox for grade selection

        // ============================================
        // =========== BUTTONS LAYOUT =================
        // ============================================
        saveUpdatePane = new StackPane(); // StackPane to swap Save and Update buttons
        saveUpdatePane.getChildren().add(saveButton); // Default to saveButton
        saveUpdatePane.setPrefWidth(buttonWidth); // Set button area width

        // VBox to hold buttons
        VBox buttonColumn = new VBox(10, saveUpdatePane, clearButton, viewButton, exportButtonContainer); // Buttons layout
        buttonColumn.setAlignment(Pos.TOP_RIGHT); // Align buttons to top right
        HBox.setMargin(buttonColumn, new Insets(0, 0, 10, 0)); // margin to separate buttons from form

        // ==========================================
        // ========== FORM and BUTTONS LAYOUT =======
        // ==========================================
        FlowPane formAndButtons = new FlowPane(); // Automatically adjusts layout based on window width
        formAndButtons.setHgap(40); // Horizontal gap between form and button column
        formAndButtons.setVgap(20); // Vertical gap if it wraps
        formAndButtons.setPadding(new Insets(5, 0, 5, 0)); // space between upper section and the table
        formAndButtons.setAlignment(Pos.TOP_LEFT); // Align to top-left
        formAndButtons.getChildren().addAll(formGrid, buttonColumn); // Add both sections

        // ===========================
        // ======= TABLE LAYOUT ======
        // ===========================
        tableView = new TableView<>(); // Create a TableView to display student data
        tableView.setPrefHeight(800); // Set preferred height for TableView
        controller.setupTableColumns(tableView); // Call method to set up table columns

        // Add the table to the layout
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            // Listener for table selection changes
            if (newSel != null) {
                selectedStudent[0] = newSel; // Store selected student
        
                // Populate form
                firstNameField.setText(newSel.getFirstName());
                lastNameField.setText(newSel.getLastName());
                courseField.setText(newSel.getCourse());
                gradeComboBox.setValue(newSel.getGrade());
                gradeComboBox.getEditor().setText(newSel.getGrade());
        
                // Swap Save for Update button
                saveUpdatePane.getChildren().clear(); // Clear the pane
                saveUpdatePane.getChildren().add(updateButton); // Show update button
        
                deleteButton.setVisible(true); // Show delete button
            } else {
                
                selectedStudent[0] = null; // Reset selected student reference
        
                // Revert to Save button
                saveUpdatePane.getChildren().clear(); // Clear the pane
                saveUpdatePane.getChildren().add(saveButton); // Show save button
        
                // Hide delete button as nothing is selected
                deleteButton.setVisible(false);
            } // End of if-else statement
        }); // End of table selection listener

        // =================================
        // ===== VERTICAL APP LAYOUT  ======
        // =================================
        VBox layout = new VBox(15, formAndButtons, tableView); // vertical spacing between form/buttons and table
        layout.setPadding(new Insets(15)); // Set padding around the layout

        // ===========================
        // =====BUTTON ACTIONS =======
        // ===========================
        // Action for save button
        saveButton.setOnAction(e -> {
            controller.saveEntry(firstNameField, lastNameField, courseField, gradeComboBox); // Save the entry
            clearForm(); // Clear the form
        }); // End of save button action

        // Action for clear button
        clearButton.setOnAction(e -> {
            // Clear the form and reset the application state
            controller.resetApp(firstNameField, lastNameField, courseField, gradeComboBox,
                exportButtonContainer, tableView, saveUpdatePane,
                saveButton, selectedStudent);
            deleteButton.setVisible(false); // Hide delete button when clearing form
        }); // End of clear button action

        // Action for view button
        viewButton.setOnAction(e -> {
            controller.displayEntries(tableView); // Display grades in the table
            exportButtonContainer.setVisible(true); // Show the export button after table is loaded
        }); // End of view button action

        // Action for export button
        exportButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser(); // File chooser for saving
            fileChooser.setTitle("Save CSV File"); // Set file chooser title
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv")); // Set CSV filter
            fileChooser.setInitialFileName("exported_grades.csv"); // Default filename

            File selectedFile = fileChooser.showSaveDialog(primaryStage); // Show save dialog
            if (selectedFile != null) { // Check if a file is selected
                try {
                    controller.exportTableToCSV(tableView.getItems(), selectedFile); // Export data
                    new Alert(Alert.AlertType.INFORMATION, "CSV exported successfully.").showAndWait(); // Show success alert
                } catch (IOException ex) {
                    new Alert(Alert.AlertType.ERROR, "Error exporting CSV.").showAndWait(); // Show error alert
                    ex.printStackTrace(); // Print error
                } // End of try-catch block
            } // End of if statement for file selection
        }); // End of export button action

        // Action for update button
        updateButton.setOnAction(e -> {
            // Check if a student is selected
            if (selectedStudent[0] != null) {
                // Update the selected student with new data from the form
                controller.updateSelectedStudent(
                    selectedStudent[0],
                    firstNameField, lastNameField, courseField,
                    gradeComboBox, tableView, saveUpdatePane,
                    saveButton, selectedStudent
                ); // Call method to update student data
            } // End of if statement for selected student
        }); // End of update button action

        // Action for delete button
        deleteButton.setOnAction(e -> {
            if (selectedStudent[0] != null) {
                // Delete student from table and CSV
                controller.deleteSelectedStudent(selectedStudent[0], tableView);
        
                // Clear form fields
                controller.clearForm(firstNameField, lastNameField, courseField, gradeComboBox);
        
                // Reset selected student reference
                selectedStudent[0] = null;
        
                // Check if any students remain in the table
                if (!tableView.getItems().isEmpty()) {
                    tableView.getSelectionModel().clearSelection(); // Clear selection to trigger listener
                } else {
                    deleteButton.setVisible(false); // Hide delete button if no students left
                }
            }
        }); // End of delete button action

        // =====================
        // ======= SCENE =======
        // =====================
        Scene scene = new Scene(layout, 540, 420); // Create a Scene with specified dimensions
        scene.getStylesheets().add(getClass().getResource("GradeBook.css").toExternalForm()); // Add CSS stylesheet

        primaryStage.setTitle("Grade Book App"); // Set the title of the app window
        primaryStage.setMaximized(true); // Maximize the window
        primaryStage.setScene(scene); // Set the scene for the primary stage
        primaryStage.show(); // Show the primary stage
    } // End of start method

    // clearForm method to clear input fields
    private void clearForm() {
        controller.clearForm(firstNameField, lastNameField, courseField, gradeComboBox); // Delegate to controller
    } // End of clearForm method

    // ======================
    // === MAIN METHOD ======
    // ======================
    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    } // End of main method
} // End of PedersenGradeBookApp class