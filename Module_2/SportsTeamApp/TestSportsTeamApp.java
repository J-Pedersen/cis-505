package Module_2.SportsTeamApp;

/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */


import java.util.Scanner; // Import the Scanner class for user input

public class TestSportsTeamApp {
    public static void main(String[] args) {
        
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Welcome to the Sports Team App\n");

        while (true) {
            // Prompt for Team Name
            System.out.print("\nEnter team name: ");
            String teamName = scanner.nextLine(); // Read the team name from user input
            
            Team team = new Team(teamName);
            
            // Prompt for Player Names
            System.out.print("\nEnter player names:\n  hint: Use Commas for Multiple Players; no spaces>: ");
            String playerNames = scanner.nextLine(); // Read the player names from user input
            
            String[] playersArray = playerNames.split(","); // Split the player names by commas to create an array
            for (String player : playersArray) { // Iterate through the array of player names
                team.addPlayer(player); // Add each player to the team
            }
            
            // Display Team Summary
            System.out.println("\n--Team Summary--");
            System.out.println("Number of players in team: " + team.getPlayerCount()); // Display the number of players in the team
            System.out.print("Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) { // Iterate through the players in the team
                System.out.print(team.getPlayers()[i] + ","); // Display each player's name
            }

            System.out.println();
            
            // Prompt for Continuing to Add Another Team
            System.out.print("\nContinue? (y/n): ");
            String choice = scanner.nextLine(); // Read the user's choice to continue or not
            if (!choice.equalsIgnoreCase("y")) { // If the choice is not 'y' (case-insensitive), exit the loop
                System.out.print("\n\nEnd of Line...");
                break; // Exit the loop and end the program
            }
        }
        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

