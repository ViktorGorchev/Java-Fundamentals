import java.util.*;

public class SchoolSystem2 {
    public static void main(String[] args) {
        TreeMap<String, TreeMap<String, List<Integer>>> data = new TreeMap<>();

        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine().split("\\s+");
            String name = input[0] + " " + input[1];
            String subject = input[2];
            int grade = Integer.parseInt(input[3]);

            if(!data.containsKey(name)){
                data.put(name, new TreeMap<>());
            }

            if(!data.get(name).containsKey(subject)){
                data.get(name).put(subject, new ArrayList<>());
            }

            data.get(name).get(subject).add(grade);
        }

        StringBuilder result = new StringBuilder();
        data.entrySet().stream().forEach(s ->{
            result.append(s.getKey() + ": [");

            s.getValue().entrySet().stream().forEach(p ->{
                Formatter formatter = new Formatter();
                formatter.format("%s - %.2f, ", p.getKey(), calculateAverage(p.getValue()));
                result.append(formatter);
            });

            result.delete(result.length() - 2, result.length());
            result.append("]\n");
        });

        System.out.println(result);
    }

    private static double calculateAverage(List <Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }

        return sum;
    }
}