import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, List<String>>> data = new TreeMap<>();
        TreeMap<String, List<Integer>> errors = new TreeMap<>();
        String regex =
                "\"Project\":\\s+\\[\"(.*?)\"\\],\\s+\"Type\":\\s+\\[\"(.*?)\"\\],\\s+\"Message\":\\s+\\[\"(.*?)\"\\]";

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        while (!input.equals("END")){
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String project = matcher.group(1);
                String type = matcher.group(2);
                String message = matcher.group(3);

                if(!data.containsKey(project)){
                    data.put(project, new TreeMap<>());
                    data.get(project).put("Critical", new ArrayList<>());
                    data.get(project).put("Warning", new ArrayList<>());
                }

                data.get(project).get(type).add(message);
            }

            input = console.nextLine();
        }

        for (Map.Entry<String, TreeMap<String, List<String>>> entry : data.entrySet()){
            errors.put(entry.getKey(), new ArrayList<>());
            int critical = data.get(entry.getKey()).get("Critical").size();
            int warning = data.get(entry.getKey()).get("Warning").size();
            int allErrors = critical + warning;
            errors.get(entry.getKey()).add(allErrors);
            errors.get(entry.getKey()).add(critical);
            errors.get(entry.getKey()).add(warning);
        }

        StringBuilder result = new StringBuilder();

        errors.entrySet().stream()
                .sorted((k1, k2) -> k2.getValue().get(0).compareTo(k1.getValue().get(0)))
                .forEach(k -> {
                    result.append(k.getKey() + ":\n");
                    result.append("Total Errors: " + k.getValue().get(0) + "\n");
                    result.append("Critical: " + k.getValue().get(1) + "\n");
                    result.append("Warnings: " + k.getValue().get(2) + "\n");
                    result.append("Critical Messages:\n");
                    if(data.get(k.getKey()).get("Critical").size() > 0) {
                        data.get(k.getKey()).get("Critical").sort(null);
                        Collections.sort(data.get(k.getKey()).get("Critical"),new Comparator<String>()
                        {
                            public int compare(String s1,String s2)
                            {
                                return s1.length() - s2.length();
                            }
                        });

                        data.get(k.getKey()).get("Critical").forEach(c -> result.append("--->" + c + "\n"));
                    }else {
                        result.append("--->None\n");
                    }

                    result.append("Warning Messages:\n");
                    if(data.get(k.getKey()).get("Warning").size() > 0) {
                        data.get(k.getKey()).get("Warning").sort(null);
                        Collections.sort(data.get(k.getKey()).get("Warning"),new Comparator<String>()
                        {
                            public int compare(String s1,String s2)
                            {
                                return s1.length() - s2.length();
                            }
                        });

                        data.get(k.getKey()).get("Warning").forEach(w -> result.append("--->" + w + "\n"));
                    }else {
                        result.append("--->None\n");
                    }

                    result.append("\n");
                });

        System.out.println(result.toString().trim());
    }
}