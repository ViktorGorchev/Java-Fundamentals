import java.util.Scanner;

public class _02_CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine().toLowerCase();
        String lookupSubString = console.nextLine().toLowerCase();


        int count = 0;
        for (int i = 0; i < text.length() - lookupSubString.length() + 1; i++) {
            String currentSubString = text.substring(i, i + lookupSubString.length());

            if (lookupSubString.equals(currentSubString)) {
                count++;
            }
        }

        System.out.println(count);
    }
}