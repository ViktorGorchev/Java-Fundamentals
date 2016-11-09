import java.util.HashMap;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        HashMap<String, String> phoneBook = new HashMap<>();

        String input = console.nextLine();
        while (!input.equals("search")){
            String[] data = input.split("-");
            phoneBook.put(data[0].trim(), data[1].trim());

            input = console.nextLine();
        }

        String searchInfo = console.nextLine();
        while (!searchInfo.equals("stop")) {
            if (phoneBook.containsKey(searchInfo)) {
                System.out.printf("%s -> %s%n", searchInfo, phoneBook.get(searchInfo));
            } else{
                System.out.printf("Contact %s does not exist.%n", searchInfo);
            }

            searchInfo = console.nextLine();
        }
    }
}