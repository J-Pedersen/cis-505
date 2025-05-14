package Module_10.GradeBookApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
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

    @Override
    public void start(Stage primaryStage) {
        // ============================
        // ===== INITIALIZE INPUTS ====
        // ============================
        firstNameField = new TextField(); // TextField for first name input
        lastNameField = new TextField(); // TextField for last name input
        courseField = new TextField(); // TextField for course input

        gradeComboBox = new ComboBox<>(); // ComboBox for grade selection
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F"); // Add grade options to ComboBox
        gradeComboBox.setPrefWidth(10); // Set preferred width for ComboBox

        // ============================
        // ==== INITIALIZE BUTTONS ====
        // ============================
        Button saveButton = new Button("Save"); // Button to save student data
        Button clearButton = new Button("Clear"); // Button to clear input fields
        Button viewButton = new Button("View Grades"); // Button to view grades
        
        // NOTE these buttons will not be visible until the user clicks the "View Grades" button
        Button updateButton = new Button("Update"); // Button to update student data
        Button exportButton = new Button("Export CSV"); // Button to export CSV file

        // CSS classes for individual button styles
        saveButton.getStyleClass().add("save-button"); // Add CSS class for save button
        clearButton.getStyleClass().add("clear-button"); // Add CSS class for clear button
        viewButton.getStyleClass().add("view-button"); // Add CSS class for view button
        updateButton.getStyleClass().add("update-button"); // Add CSS class for update button
        exportButton.getStyleClass().add("export-button"); // Add CSS class for export button

        // button widths
        double buttonWidth = 150; // Set button width
        saveButton.setPrefWidth(buttonWidth); // Set preferred width for save button
        clearButton.setPrefWidth(buttonWidth); // Set preferred width for clear button
        viewButton.setPrefWidth(buttonWidth); // Set preferred width for view button
        updateButton.setPrefWidth(buttonWidth); // Set preferred width for update button
        exportButton.setPrefWidth(buttonWidth); // Set preferred width for export button

        // =========================================
        // ========== UI INPUTS LAYOUT =============
        // =========================================
        GridPane formGrid = new GridPane(); // Create a GridPane for layout
        formGrid.setHgap(10); // Horizontal spacing between columns
        formGrid.setVgap(10); // Vertical spacing between rows
        formGrid.addRow(0, new Label("First Name"), firstNameField); // Add first name label and field
        formGrid.addRow(1, new Label("Last Name"), lastNameField); // Add last name label and field
        formGrid.addRow(2, new Label("Course"), courseField); // Add course label and field
        formGrid.addRow(3, new Label("Grade"), gradeComboBox); // Add grade label and ComboBox

        // ============================================
        // =========== BUTTONS LAYOUT =================
        // ============================================
        VBox buttonColumn = new VBox(10, saveButton, clearButton, viewButton); // Vertical spacing between buttons
        buttonColumn.setAlignment(Pos.TOP_RIGHT); // Align buttons to the bottom right
        HBox.setMargin(buttonColumn, new Insets(0, 0, 10, 0)); // margin to separate buttons from form

        // ==========================================
        // ========== FORM and BUTTONS HBOX =========
        // ==========================================
        HBox formAndButtons = new HBox(20, formGrid, buttonColumn); // spacing between form and button column
        VBox.setMargin(formAndButtons, new Insets(5, 0, 35, 0)); // space between upper section and the table

        // ===========================
        // ========= TABLE ===========
        // ===========================
        tableView = new TableView<>(); // Create a TableView to display student data
        tableView.setPrefHeight(800); // Set preferred height for TableView
        setupTableColumns(); // Call method to set up table columns

        // =================================
        // ===== VERTICAL APP LAYOUT  ======
        // =================================
        VBox layout = new VBox(15, formAndButtons, tableView); // vertical spacing between form/buttons and table
        layout.setPadding(new Insets(15)); // Set padding around the layout

        // =====================
        // ======= SCENE =======
        // =====================
        Scene scene = new Scene(layout, 500, 420); // Create a Scene with specified dimensions
        scene.getStylesheets().add(getClass().getResource("gradebook.css").toExternalForm()); // Add CSS stylesheet

        primaryStage.setTitle("Grade Book App"); // Set the title of the app window
        primaryStage.setMaximized(true); // Maximize the window
        primaryStage.setScene(scene); // Set the scene for the primary stage
        primaryStage.show(); // Show the primary stage
    } // End of start method

    // =====================================
    // ======== TABLE COLUMNS SETUP ========
    // =====================================
    private void setupTableColumns() {
        TableColumn<Student, String> firstNameCol = new TableColumn<>("First Name"); // Create a column for first name
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName")); // Set cell value factory for first name column

        TableColumn<Student, String> lastNameCol = new TableColumn<>("Last Name"); // Create a column for last name
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName")); // Set cell value factory for last name column

        TableColumn<Student, String> courseCol = new TableColumn<>("Course"); // Create a column for course
        courseCol.setCellValueFactory(new PropertyValueFactory<>("course")); // Set cell value factory for course column

        TableColumn<Student, String> gradeCol = new TableColumn<>("Grade"); // Create a column for grade
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade")); // Set cell value factory for grade column

        tableView.getColumns().addAll(firstNameCol, lastNameCol, courseCol, gradeCol); // Add columns to the TableView

        // Set table column widths
        firstNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.29)); // Bind first name column width to 29% of TableView width
        lastNameCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.29)); // Bind last name column width to 29% of TableView width
        courseCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.24)); // Bind course column width to 24% of TableView width
        gradeCol.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20)); // Bind grade column width to 16% of TableView width
    } // End of setupTableColumns method

    // ======================
    // === MAIN METHOD ======
    // ======================
    public static void main(String[] args) { 
        launch(args); // Launch the JavaFX application
    } // End of main method
} // End of PedersenGradeBookApp class