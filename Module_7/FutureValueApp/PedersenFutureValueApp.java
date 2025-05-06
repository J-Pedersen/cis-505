package Module_7.FutureValueApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// PedersenFutureValueApp Class
public class PedersenFutureValueApp extends Application {

    // =======
    // Labels
    // =======
    private Label lblMonthlyPayment = new Label("Monthly Payment:"); // Label for monthly payment input.
    private Label lblInterestRate = new Label("Interest Rate:"); // Label for interest rate input.
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1"); // Label for interest rate format.
    private Label lblYears = new Label("Years:"); // Label for years input.
    private Label lblFutureValue = new Label("Future Value:"); // Label for future value output.

    // =======
    // Inputs
    // =======
    private TextField tfMonthlyPayment = new TextField(); // Create a TextField for monthly payment.
    private TextField tfInterestRate = new TextField(); // Create a TextField for interest rate.
    private ComboBox<Integer> cbYears = new ComboBox<>(); // Create a ComboBox for years.

    // =======
    // Output
    // =======
    private TextArea taFutureValue = new TextArea(); // Create a TextArea to display the future value.

    // ========
    // Buttons
    // ========
    private Button btnCalculate = new Button("Calculate"); // Create a button to calculate the future value.
    private Button btnClear = new Button("Clear"); // Create a button to clear the input fields.

    @Override
    public void start(Stage primaryStage) {
        // =======
        // Layout
        // =======
        GridPane pane = new GridPane(); // Create a new GridPane layout.
        pane.setAlignment(Pos.CENTER); // Set the alignment of the pane to center.
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); // Set the padding of the pane.
        pane.setHgap(5.5); // Set the horizontal gap between elements in the pane.
        pane.setVgap(5.5); // Set the vertical gap between elements in the pane.

        // =============
        // Input Sizing
        // =============
        double inputWidth = 200; // Set the width of the input fields.
        tfMonthlyPayment.setPrefWidth(inputWidth); // Set the preferred width of the Monthly Payment text field.
        tfInterestRate.setPrefWidth(inputWidth); // Set the preferred width of the Interest Rate text field.
        cbYears.setPrefWidth(inputWidth); // Set the preferred width of the Years ComboBox.

        GridPane.setHalignment(tfMonthlyPayment, HPos.RIGHT); // Align the TextField to the right.
        GridPane.setHalignment(tfInterestRate, HPos.RIGHT); // Align the TextField to the right.
        GridPane.setHalignment(cbYears, HPos.RIGHT); // Align the ComboBox to the right.

        // =============
        // Label Widths
        // =============
        lblMonthlyPayment.setMinWidth(130); // Set the minimum width of the Monthly Payment label.
        lblInterestRate.setMinWidth(130); // Set the minimum width of the Interest Rate label.
        lblYears.setMinWidth(130); // Set the minimum width of the Years label.

        // ================
        // Add to GridPane
        // ================
        pane.add(lblMonthlyPayment, 0, 0); // Add the label to the grid pane.
        pane.add(tfMonthlyPayment, 1, 0); // Add the text field to the grid pane.

        pane.add(lblInterestRate, 0, 1); // Add the label to the grid pane.
        pane.add(tfInterestRate, 1, 1); // Add the text field to the grid pane.

        lblInterestRateFormat.setTextFill(Color.RED); // Set the label text color to red.
        pane.add(lblInterestRateFormat, 1, 2); // Add the label to the grid pane.
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); // Align the label to the right.

        pane.add(lblYears, 0, 3); // Add the label to the grid pane.
        cbYears.getItems().addAll(1, 2, 3, 4, 5, 10, 20); // Add years to the ComboBox.
        pane.add(cbYears, 1, 3); // Add the ComboBox to the grid pane.

        // HBox for Buttons
        HBox actionBtnContainer = new HBox(); // Create a new HBox container.
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30)); // Set the containers padding.
        actionBtnContainer.setSpacing(10); // Set the containers spacing.
        actionBtnContainer.getChildren().add(btnClear); // Add the clear button to the container.
        actionBtnContainer.getChildren().add(btnCalculate); // Add the calculate button to the container.
        pane.add(actionBtnContainer, 1, 4); // Add the container to the grid pane.

        // Future Value Output
        pane.add(lblFutureValue, 0, 5); // Add the label to the grid pane.
        pane.add(taFutureValue, 0, 6, 2, 1); // Add the text area to the grid pane.

        // ======
        // Stage
        // ======
        primaryStage.setTitle("Pedersen Future Value App"); // Set the title of the stage.
        Scene scene = new Scene(pane, 340, 360); // Create a new scene with the grid pane.
        primaryStage.setScene(scene); // Set the scene to the stage.
        primaryStage.show(); // Show the stage.
    } // End start method

    public static void main(String[] args) {
        launch(args); // Launch the application.
    } // End main method
} // End PedersenFutureValueApp class