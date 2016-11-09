import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_MinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, Integer> data = new LinkedHashMap<>();

        String input = console.nextLine();
        int count = 0;
        String resource = null;
        while (!input.equals("stop")){
            if(count % 2 == 0){
                resource = input;                
            }else {
                if(data.containsKey(resource)){
                    data.put(resource, data.get(resource) + Integer.parseInt(input));
                }else {
                    data.put(resource, Integer.parseInt(input));
                }
            }

            count++;
            input = console.nextLine();
        }

        for (Map.Entry<String,Integer> entry : data.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}