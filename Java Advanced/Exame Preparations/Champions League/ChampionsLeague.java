import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChampionsLeague {
    public static void main(String[] args) {
        TreeMap<String, TreeSet<String>> dataTeams = new TreeMap<>();
        TreeMap<String, Integer> dataWins = new TreeMap<>();

        Scanner console = new Scanner(System.in);
        String input = convertToSpacesRegex(console.nextLine());
        while (!input.equals("stop")){
            String[] inputArray = input.split("\\|");
            String team1 = inputArray[0].trim();
            String team2 = inputArray[1].trim();
            String[] goals1 = inputArray[2].trim().split(":");
            String[] goals2 = inputArray[3].trim().split(":");

            if(!dataTeams.containsKey(team1)){
                dataTeams.put(team1, new TreeSet<>());
                dataWins.put(team1, 0);
            }

            if(!dataTeams.containsKey(team2)){
                dataTeams.put(team2, new TreeSet<>());
                dataWins.put(team2, 0);
            }

            dataTeams.get(team1).add(team2);
            dataTeams.get(team2).add(team1);

            boolean team1MoreGoals = Integer.parseInt(goals1[0]) + Integer.parseInt(goals2[1]) >
                    Integer.parseInt(goals1[1]) + Integer.parseInt(goals2[0]);
            boolean goalsEqual = Integer.parseInt(goals1[0]) + Integer.parseInt(goals2[1]) ==
                    Integer.parseInt(goals1[1]) + Integer.parseInt(goals2[0]);
            boolean team1MoreGoalsOnAwaySoil = Integer.parseInt(goals2[1]) >  Integer.parseInt(goals1[1]);
            if(team1MoreGoals && !goalsEqual){
                dataWins.put(team1, dataWins.get(team1) + 1);
            }

            if(!team1MoreGoals && !goalsEqual){
                dataWins.put(team2, dataWins.get(team2) + 1);
            }

            if(goalsEqual && team1MoreGoalsOnAwaySoil){
                dataWins.put(team1, dataWins.get(team1) + 1);
            }

            if(goalsEqual && !team1MoreGoalsOnAwaySoil){
                dataWins.put(team2, dataWins.get(team2) + 1);
            }

            input = convertToSpacesRegex(console.nextLine());
        }

        dataWins.entrySet().stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(t -> {
            System.out.println(t.getKey());
            System.out.println("- Wins: " + t.getValue());
            System.out.println("- Opponents: " + String.join(", ", dataTeams.get(t.getKey())));
        });
    }

    private static String convertToSpacesRegex(String value)
    {
        value = value.replaceAll("\\s+", " ");
        return value;
    }
}