import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class OlympicsAreComing {
    public static void main(String[] args) {
        LinkedHashMap<String, HashSet<String>> dataPlayers = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> dataWins = new LinkedHashMap<>();

        Scanner console = new Scanner(System.in);
        String input = convertToSpacesRegex(console.nextLine());
        while (!input.equals("report")){
            String[] inputArray = input.split("\\|");
            String player = inputArray[0].trim();
            String country = inputArray[1].trim();

            if(!dataPlayers.containsKey(country)){
                dataPlayers.put(country, new HashSet<>());
                dataWins.put(country, 0);
            }

            dataPlayers.get(country).add(player);
            dataWins.put(country, dataWins.get(country) + 1);

            input = convertToSpacesRegex(console.nextLine());
        }

        dataWins.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c -> {
            System.out.printf("%s (%d participants): %d wins\n",
                    c.getKey(),
                    dataPlayers.get(c.getKey()).size(),
                    c.getValue());
        });
    }

    private static String convertToSpacesRegex(String value)
    {
        value = value.replaceAll("\\s+", " ");
        return value;
    }
}