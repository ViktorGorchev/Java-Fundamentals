import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GUnit {
    public static void main(String[] args) {
        TreeMap<String,TreeMap<String, TreeSet<String>>> data = new TreeMap<>();
        String regex = "^([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+) \\| ([A-Z][A-Za-z0-9]+)$";

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        while (!input.equals("It's testing time!")){
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String classInput = matcher.group(1);
                String methodInput = matcher.group(2);
                String testInput = matcher.group(3);

                if(!data.containsKey(classInput)){
                    data.put(classInput, new TreeMap<>());
                }

                if(!data.get(classInput).containsKey(methodInput)){
                    data.get(classInput).put(methodInput, new TreeSet<>());
                }

                data.get(classInput).get(methodInput).add(testInput);
            }

            input = console.nextLine();
        }

        data.entrySet().stream()
                .sorted((c1, c2) -> Integer.compare(c1.getValue().keySet().size(), c2.getValue().keySet().size()))
                .sorted((c1, c2) -> Integer.compare(countTests(c2.getValue()), countTests(c1.getValue())))
                .forEach(c -> {
                    System.out.println(c.getKey() + ":");

                    c.getValue().entrySet().stream()
                            .sorted((m1, m2) -> Integer.compare(m2.getValue().size(), m1.getValue().size()))
                            .forEach(m -> {
                                System.out.println("##" + m.getKey());

                                m.getValue().stream()
                                        .sorted((t1, t2) -> Integer.compare(t1.length(), t2.length()))
                                        .forEach(t ->{
                                            System.out.println("####" + t);
                                        });
                            });
                });
    }

    private static Integer countTests(TreeMap<String, TreeSet<String>> map){
        int count = 0;
        for (TreeSet<String> set : map.values()) {
            count = count + set.size();
        }

        return count;
    }
}