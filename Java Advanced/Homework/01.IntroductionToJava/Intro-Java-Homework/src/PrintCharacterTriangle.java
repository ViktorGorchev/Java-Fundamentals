import java.util.Scanner;

public class PrintCharacterTriangle {
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int count = 0;
        for (int i = 0; i < number * 2; i++) {
            String subString = letters.substring(0, count);
            for (int j = 0; j < subString.length(); j++) {
                System.out.print(subString.charAt(j) + " ");
            }

            if (i != number * 2 - 1){
                System.out.println();
            }

            if (i > number - 1) {
                count--;
            } else {
                count++;
            }
        }
    }
}