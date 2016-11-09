import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String inputText = console.nextLine();

        TreeMap<Character, Integer> charsCount = new TreeMap<>();
        for (int i = 0; i < inputText.length(); i++) {
            char currentChar = inputText.charAt(i);
            if(charsCount.containsKey(currentChar)){
                charsCount.put(currentChar, charsCount.get(currentChar) + 1);
                continue;
            }

            charsCount.put(currentChar, 1);
        }

        for (Map.Entry<Character,Integer> entry : charsCount.entrySet()) {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }
    }
}