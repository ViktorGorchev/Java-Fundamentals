import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GandalfStash {
    public static void main(String[] args) {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("cram", 2);
        data.put("lembas", 3);
        data.put("apple", 1);
        data.put("melon", 1);
        data.put("honeycake", 5);
        data.put("mushrooms", -10);

        String regex = "([A-Za-z]+)";
        Scanner console = new Scanner(System.in);
        int happiness = Integer.parseInt(console.nextLine());
        String input = console.nextLine().toLowerCase();

        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            String inputWord = matcher.group(1);
            if(data.containsKey(inputWord)){
                happiness = happiness + data.get(inputWord);
            }else {
                happiness = happiness - 1;
            }
        }

        System.out.println(happiness);

        if(happiness < -5 ){
            System.out.println("Angry");
        }

        if (happiness >= -5 && happiness < 0){
            System.out.println("Sad");
        }

        if (happiness >= 0 && happiness <= 15){
            System.out.println("Happy");
        }

        if (happiness > 15){
            System.out.println("Special JavaScript mood");
        }
    }
}