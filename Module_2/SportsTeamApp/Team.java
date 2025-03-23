package Module_2.SportsTeamApp;

/*
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: Comprehensive Version (12th ed.). Pearson Education, Inc.
 * Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
 * Pedersen, J. (2025). CIS 505 Intermediate Java Programming.Bellevue University.
 */

// Team class to represent a sports team
class Team {
    private String teamName; // Team name
    private String[] players; // Array to hold player names
    private int playerCount; // Count of players in the team

    // Team Constructor
    public Team(String teamName) {
        this.teamName = teamName; // Set the team name
        this.players = new String[20]; // Maximum of 20 players per team
        this.playerCount = 0; // Initialize player count to 0
    }

    // Method to add a player
    public void addPlayer(String player) {
        if (playerCount < players.length) { // Check if there's room for more players
            players[playerCount] = player; // Add player to the array
            playerCount++; // Increment the player count
        } else {
            System.out.println("Sorry, This Team is Full. More Than 20 Players Cannot be Added to a Team.");
        }
    }

    // Method to get players
    public String[] getPlayers() {
        return players; // Return the array of players
    }

    // Method to get player count
    public int getPlayerCount() {
        return playerCount; // Return the count of players
    }

    // Method to get team name
    public String getTeamName() {
        return teamName; // Return the team name
    }
}
