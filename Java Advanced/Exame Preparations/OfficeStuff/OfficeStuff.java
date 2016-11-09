import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfficeStuff {
    public static void main(String[] args) {
        TreeMap<String, LinkedHashMap<String, Integer>> data = new TreeMap<>();
        String regex = "\\|\\s*(.*?)\\s*-\\s*(\\d+)\\s*-\\s*(.*?)\\s*\\|";

        Scanner console = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(console.nextLine());

        for (int i = 0; i < numberOfLines; i++) {
            String input = convertToSpacesRegex(console.nextLine());
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String company = matcher.group(1).trim();
                int amount = Integer.parseInt(matcher.group(2).trim());
                String product = matcher.group(3).trim();

                if(!data.containsKey(company)){
                    data.put(company, new LinkedHashMap<>());
                }

                if(!data.get(company).containsKey(product)){
                    data.get(company).put(product, 0);
                }

                data.get(company).put(product, data.get(company).get(product) + amount);
            }
        }

        StringBuilder result = new StringBuilder();
        data.entrySet().stream().forEach(c -> {
           result.append(c.getKey() + ": ");

            c.getValue().entrySet().stream().forEach(p -> {
               result.append(p.getKey() + "-" + p.getValue() + ", ");
            });

            if(result.length() > 1){
                result.delete(result.length() - 2,result.length());
            }

            result.append("\n");
        });

        System.out.println(result.toString());
    }

    private static String convertToSpacesRegex(String value)
    {
        value = value.replaceAll("\\s+", " ");
        return value;
    }
}