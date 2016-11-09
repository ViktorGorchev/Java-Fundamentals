import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, String> data = new LinkedHashMap<>();

        int count = -1;
        String name = null;
        while (true){
            count++;
            String input = console.nextLine();
            if(input.equals("stop")){
                break;
            }

            if(count % 2 == 0){
                name = input;
                continue;
            }

            String email = input;
            if(email.length() < 2){
                continue;
            }

            boolean isUs = email.toLowerCase().charAt(email.length() - 2) == 'u'
                    && email.toLowerCase().charAt(email.length() - 1) == 's';
            boolean isUk = email.toLowerCase().charAt(email.length() - 2) == 'u'
                    && email.toLowerCase().charAt(email.length() - 1) == 'k';

            if(isUs || isUk){
                continue;
            }

            data.put(name, email);
        }

        for (Map.Entry<String,String> entry : data.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}