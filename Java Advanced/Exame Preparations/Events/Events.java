import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Events {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, List<String>>> data = new TreeMap<>();
        String regex = "^#([a-zA-Z]+):\\s*@(([a-zA-Z]+))\\s*(\\d{2}):(\\d{2})$";

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        int inputLines = Integer.parseInt(input);
        for (int i = 0; i < inputLines; i++) {
            input = console.nextLine();
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String location = matcher.group(3);
                String name = matcher.group(1);
                String hour = matcher.group(4);
                String minutes = matcher.group(5);

                boolean hourNotInRange = Integer.parseInt(hour) < 0 || Integer.parseInt(hour) > 23;
                boolean minutesNotInRange = Integer.parseInt(minutes) < 0 || Integer.parseInt(minutes) > 59;
                if(hourNotInRange || minutesNotInRange){
                    continue;
                }

                if(!data.containsKey(location)){
                    data.put(location, new TreeMap<>());
                }

                if(!data.get(location).containsKey(name)){
                    data.get(location).put(name, new ArrayList<>());
                }

                data.get(location).get(name).add(hour + ":" + minutes);
            }
        }

        List<String> locations = Arrays.asList(console.nextLine().split(","));

        for (String location: data.keySet()) {
            if(!locations.contains(location)){
                continue;
            }

            System.out.println(location + ":");
            int count = 1;
            for (Map.Entry<String, List<String>> entry : data.get(location).entrySet()) {
                System.out.print(count + ". " + entry.getKey() + " -> ");
                System.out.println(String.join(", ", entry.getValue().stream().sorted().collect(Collectors.toList())));
                count++;
            }
        }
    }
}