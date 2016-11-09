import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(" ");
        String firstString = input[0];
        String secondString = input[1];
        System.out.println(multiplyChars(firstString, secondString));
    }

    private static Integer multiplyChars(String firstString, String secondString) {
        int sum = 0;
        for (int i = 0; i < Integer.max(firstString.length(), secondString.length()); i++) {
            if (i < firstString.length() && i < secondString.length()){
                sum += firstString.charAt(i) * secondString.charAt(i);
                continue;
            }

            if (i < firstString.length()){
                sum += firstString.charAt(i);
            }

            if (i < secondString.length()){
                sum += secondString.charAt(i);
            }
        }
        
        return sum;
    }
}
