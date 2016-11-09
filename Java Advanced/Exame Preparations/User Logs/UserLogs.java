import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        String regex = "IP=([0-9A-Fa-f]{1,4}:" +
                "[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4}:" +
                "[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4}:" +
                "[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4}:" +
                "[0-9A-Fa-f]{1,4}|[0-9A-Fa-f]{1,4}:" +
                "[0-9A-Fa-f]{1,4}:[0-9A-Fa-f]{1,4}:" +
                "[0-9A-Fa-f]{1,4}::|" +
                "\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}) " +
                "message='(.*)' user=(.{3,50})";

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        while (! input.equals("end")){
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String ip = matcher.group(1);
                String message = matcher.group(2);
                String user = matcher.group(3);

                if(!data.containsKey(user)){
                    data.put(user, new LinkedHashMap<>());
                }

                if(!data.get(user).containsKey(ip)){
                    data.get(user).put(ip, 0);
                }

                data.get(user).put(ip, data.get(user).get(ip) + 1);
            }

            input = console.nextLine();
        }

        StringBuilder result = new StringBuilder();
        data.entrySet().stream().forEach(u ->{
            result.append(u.getKey() + ":\n");

            u.getValue().entrySet().stream().forEach(i -> {
                result.append(i.getKey() + " => " + i.getValue() + ", ");
            });

            result.deleteCharAt(result.length() - 1);
            result.deleteCharAt(result.length() - 1);
            result.append(".\n");
        });

        System.out.print(result);
    }
}