import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");

        List<String> royalists = new ArrayList<>();
        List<String> nonRoyalists = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            int sum = 0;
            for (int c = 0; c < word.length(); c++) {
                char currentChar = word.charAt(c);
                if(currentChar > 26){
                    while (currentChar > 26){
                        currentChar = (char)(currentChar - 26);
                    }
                }

                sum = sum + currentChar;
            }

            if(sum == 18){
                royalists.add(word);
            }else{
                nonRoyalists.add(word);
            }

        }

        System.out.println(royalists);
        System.out.println(nonRoyalists);

    }
}
