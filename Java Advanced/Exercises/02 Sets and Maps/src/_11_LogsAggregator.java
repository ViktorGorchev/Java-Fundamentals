import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _11_LogsAggregator {
    public static void main(String[] args) {
        TreeMap<String, TreeSet<String>> ipsData = new TreeMap<>();
        TreeMap<String, Integer> durationData = new TreeMap<>();

        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        for (int i = 0; i < n; i++) {
            String input = console.nextLine();
            String regex = "(\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3})\\s+([A-Za-z]{1,20})\\s+(\\d+)";
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String ip = matcher.group(1);
                String name = matcher.group(2);
                int duration = Integer.parseInt(matcher.group(3));

                if(!ipsData.containsKey(name)){
                    ipsData.put(name, new TreeSet<>());
                    durationData.put(name, 0);
                }

                ipsData.get(name).add(ip);
                durationData.put(name, durationData.get(name) + duration);
            }
        }

        for (Map.Entry<String,TreeSet<String>> entry : ipsData.entrySet()) {
            System.out.println(entry.getKey() + ": " + durationData.get(entry.getKey()) + " " + entry.getValue());
        }
    }
}