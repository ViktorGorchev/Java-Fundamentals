import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E4_3 {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, List<String>>> data = new TreeMap<>();
        TreeMap<String, Integer> methods = new TreeMap<>();
        TreeMap<String, Integer> tests = new TreeMap<>();

        String regex = "([A-Z]\\w+)\\s\\|\\s([A-Z]\\w+)\\s\\|\\s([A-Z]\\w+)"; //^ $

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        while (!input.equals("It's testing time!")){

            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String classInput = matcher.group(1).trim();
                String methodInput = matcher.group(2).trim();
                String testInput = matcher.group(3).trim();

                if(!data.containsKey(classInput)){
                    data.put(classInput, new TreeMap<>());
                    methods.put(classInput,0);
                    tests.put(classInput, 0);
                }

                if(!data.get(classInput).containsKey(methodInput)){
                    data.get(classInput).put(methodInput, new ArrayList<>());
                    methods.put(classInput, methods.get(classInput) + 1);
                }

                if(!data.get(classInput).get(methodInput).contains(testInput)){
                    data.get(classInput).get(methodInput).add(testInput);
                    tests.put(classInput, tests.get(classInput) + 1);
                }

            }

            input = console.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> sortedByTests = new LinkedHashMap<>();
        tests.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c ->{
            sortedByTests.put(c.getKey(), new LinkedHashMap<>());

            for (Map.Entry<String, List<String>> method: data.get(c.getKey()).entrySet()) {
                sortedByTests.get(c.getKey()).put(method.getKey(), method.getValue());
            }

        });

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> sortedByTestsThenByMethods = new LinkedHashMap<>();
        methods.entrySet().stream().sorted((c1, c2) -> c1.getValue().compareTo(c2.getValue())).forEach(c -> {
            sortedByTestsThenByMethods.put(c.getKey(), new LinkedHashMap<>());

            for (Map.Entry<String, List<String>> method: sortedByTests.get(c.getKey()).entrySet()) {
                sortedByTests.get(c.getKey()).put(method.getKey(), method.getValue());
            }

        });

        sortedByTestsThenByMethods.entrySet().stream().forEach(c -> {
            System.out.println(c.getKey() + ":");
            c.getValue().entrySet().stream()
                    .sorted((m1, m2) -> ((Integer) m2.getValue().size()).compareTo( m1.getValue().size()))
                    .forEach(m -> {
                        System.out.println("##" + m.getKey());
                        m.getValue().stream().sorted((t1, t2) -> ((Integer) t1.length()).compareTo(t2.length()))
                                .forEach(t -> {
                                    System.out.println("####" + t);
                                });
                    });
        });


    }
}
