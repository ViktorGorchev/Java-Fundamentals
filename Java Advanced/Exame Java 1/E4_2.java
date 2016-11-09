import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E4_2 {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, TreeSet<String>>> data = new TreeMap<>();
        TreeMap<String, Integer> methods = new TreeMap<>();

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
                }

                if(!data.get(classInput).containsKey(methodInput)){
                    data.get(classInput).put(methodInput, new TreeSet<>());
                    methods.put(classInput, methods.get(classInput) + 1);
                }

                data.get(classInput).get(methodInput).add(testInput);
            }

            input = console.nextLine();
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        data.entrySet().stream().sorted((c1, c2) -> {

            int testsCount1 = 0;
            for (TreeSet<String> v : c1.getValue().values()) {
                testsCount1 = testsCount1 + v.size();
            }

            int testsCount2 = 0;
            for (TreeSet<String> v : c2.getValue().values()) {
                testsCount2 = testsCount2 + v.size();
            }

            //if (testsCount1 != testsCount2) {
            return Integer.compare(testsCount2, testsCount1);
            //}

            //return c1.getKey().compareTo(c2.getKey());

        }).sorted((c1, c2) -> {

            int methodsCount1 = c1.getValue().keySet().size();
            int methodsCount2 = c2.getValue().keySet().size();

            //if (methodsCount1 != methodsCount2) {
            return Integer.compare(methodsCount1, methodsCount2);
            //}

            //return c1.getKey().compareTo(c2.getKey());

        }).forEach(c -> {
            System.out.println(c.getKey()+":");
            c.getValue().entrySet().stream().sorted((m1, m2) -> {
                int methodTestsCount1 = m1.getValue().size();
                int methodTestsCount2 = m2.getValue().size();

                return Integer.compare(methodTestsCount2, methodTestsCount1);
            }).forEach(m -> {
                System.out.println("##" + m.getKey());
                m.getValue().stream().sorted((t1, t2) -> {
                    int testLength1 = t1.length();
                    int testLength2 = t2.length();

                    // if(testLength1 != testLength2){
                    return Integer.compare(testLength1, testLength2);
                    //}

                    // return ..............
                }).forEach(t -> {
                    System.out.println("####" + t);
                });
            });

        });
    }
}
