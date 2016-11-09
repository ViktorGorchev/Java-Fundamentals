import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1_2 {
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
                sum = sum + currentChar;
            }

            if(sum > 26){
                while (sum > 26){
                    sum = sum - 26;
                }
            }

            if(sum == 18){
                royalists.add(word);
            }else{
                nonRoyalists.add(word);
            }

        }

        if(royalists.size() >= nonRoyalists.size()){
            System.out.println("Royalists - " + royalists.size());
            for (String royal: royalists) {
                System.out.println(royal);
            }

            System.out.println("All hail Royal!");
        } else {
            for (String nonRoyal: nonRoyalists) {
                System.out.println(nonRoyal);
            }

            System.out.println("Royalism, Declined!");
        }
    }
}