package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Player {
    private final String name;
    private final String team;
    private final String role;
    private final int matches;
    private final int runs;
    private final double average;
    private final double strikeRate;
    private final int wickets;

    public Player(String name, String team, String role, int matches, int runs, double average, double strikeRate, int wickets) {
        this.name = name;
        this.team = team;
        this.role = role;
        this.matches = matches;
        this.runs = runs;
        this.average = average;
        this.strikeRate = strikeRate;
        this.wickets = wickets;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getRole() {
        return role;
    }

    public int getMatches() {
        return matches;
    }

    public int getRuns() {
        return runs;
    }

    public double getAverage() {
        return average;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getWickets() {
        return wickets;
    }

    @Override
    public String toString() {

        return "Player{" +
                "name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", role='" + role + '\'' +
                ", matches=" + matches +
                ", runs=" + runs +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", wickets=" + wickets +
                '}';
    }
}

class Team {
    private String teamName;
    private List<Player> players;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}

public class IPLApplication2 {
    private static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        loadDataFromCSV("src/main/resources/IPL_2021-data.csv");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            Logging.logInfo("\nMenu:");
            Logging.logInfo("1. Bowlers with at least 40 wickets for a given team");
            Logging.logInfo("2. Details of the highest wicket-taker and highest run-scorer for a given team");
            Logging.logInfo("3. Top 3 run-scorers and top 3 wicket-takers of the season");
            Logging.logInfo("4. Generate match fixtures");
            Logging.logInfo("5. Exit");
            Logging.logInfo("Enter my choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Logging.logInfo("Enter team name: ");
                    String teamName = scanner.nextLine();
                    Logging.logInfo("Enter minimum wickets: ");
                    int minWickets = scanner.nextInt();
                    List<Player> bowlers = findBowlersWithMinimumWickets(teamName, minWickets);
                    Logging.logInfo("Bowlers with at least " + minWickets + " wickets for " + teamName + ":");
                    for (Player bowler : bowlers) {
                        Logging.logInfo(bowler.getName() + " - " + bowler.getWickets() + " wickets");
                    }
                    break;
                case 2:
                    Logging.logInfo("Enter team name: ");
                    teamName = scanner.nextLine();
                    displayHighestWicketTakerAndRunScorer(teamName);
                    break;
                case 3:
                    displayTop3RunScorersAndWicketTakers();
                    break;
                case 4:
                    generateMatchFixtures();
                    break;
                case 5:
                    Logging.logInfo("Exiting the application. Goodbye!");
                    break;
                default:
                    Logging.logInfo("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void loadDataFromCSV(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
           reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String team = data[1];
                String role = data[2];
                int matches = Integer.parseInt(data[3]);
                int runs = Integer.parseInt(data[4]);
                double average = Double.parseDouble(data[5]);
                double strikeRate = Double.parseDouble(data[6]);
                int wickets = Integer.parseInt(data[7]);

                Player player = new Player(name, team, role, matches, runs, average, strikeRate, wickets);
                addToTeam(player);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static void addToTeam(Player player) {
        boolean teamExists = false;
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(player.getTeam())) {
                teamExists = true;
                team.addPlayer(player);
                break;
            }
        }

        if (!teamExists) {
            Team newTeam = new Team(player.getTeam());
            newTeam.addPlayer(player);
            teams.add(newTeam);
        }
    }

    private static List<Player> findBowlersWithMinimumWickets(String teamName, int minWickets) {
        List<Player> result = new ArrayList<>();
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                for (Player player : team.getPlayers()) {
                    if (player.getRole().equalsIgnoreCase("BOWLER") && player.getWickets() >= minWickets) {
                        result.add(player);
                    }
                }
                break;
            }
        }
        return result;
    }

    private static void displayHighestWicketTakerAndRunScorer(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                List<Player> players = team.getPlayers();
                players.sort(Comparator.comparingInt(Player::getWickets).reversed());

                Logging.logInfo("Highest Wicket-Taker: " + players.get(0).getName() +
                        " - " + players.get(0).getWickets() + " wickets");

                players.sort(Comparator.comparingInt(Player::getRuns).reversed());

                Logging.logInfo("Highest Run-Scorer: " + players.get(0).getName() +
                        " - " + players.get(0).getRuns() + " runs");

                break;
            }
        }
    }

    private static void displayTop3RunScorersAndWicketTakers() {
        List<Player> allPlayers = new ArrayList<>();
        for (Team team : teams) {
            allPlayers.addAll(team.getPlayers());
        }

        allPlayers.sort(Comparator.comparingInt(Player::getRuns).reversed());
        Logging.logInfo("Top 3 Run-Scorers of the Season:");
        for (int i = 0; i < Math.min(3, allPlayers.size()); i++) {
            Logging.logInfo((i + 1) + ". " + allPlayers.get(i).getName() +
                    " - " + allPlayers.get(i).getRuns() + " runs");
        }

        allPlayers.sort(Comparator.comparingInt(Player::getWickets).reversed());
        Logging.logInfo("\nTop 3 Wicket-Takers of the Season:");
        for (int i = 0; i < Math.min(3, allPlayers.size()); i++) {
            Logging.logInfo((i + 1) + ". " + allPlayers.get(i).getName() +
                    " - " + allPlayers.get(i).getWickets() + " wickets");
        }
    }

    private static void generateMatchFixtures() {
        List<String> teamNames = new ArrayList<>();
        for (Team team : teams) {
            teamNames.add(team.getTeamName());
        }

        Collections.shuffle(teamNames);

        Logging.logInfo("\nMatch Fixtures:");

        for (int i = 0; i < teamNames.size(); i += 2) {
            String team1 = teamNames.get(i);
            String team2 = teamNames.get(i + 1);
            Logging.logInfo(team1 + " vs " + team2);
        }
    }


}
