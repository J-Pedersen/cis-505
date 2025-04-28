package Module_8.EnhancedFutureValueApp;

/* 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
*/

// FinanceCalculator Class
public class FinanceCalculator {

    private static final int MONTHS_IN_YEAR = 12; // Constant for the number of months in a year.

    // Method to calculate the future value of an investment.
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) {
        int months = years * MONTHS_IN_YEAR; // Calculate the total number of months.
        double interestRate = 1 + (rate / 100); // Convert the interest rate to a decimal.
        double presentValue = monthlyPayment * months; // Calculate the present value.
        double futureValue = presentValue * Math.pow(interestRate, months); // Calculate the future value.

        return futureValue; // Return the calculated future value.
    } // End of calculateFutureValue method
} // End of FinanceCalculator class