import java.util.Scanner;

public class CountSpecifiedWord {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] text = console.nextLine().toLowerCase().split("\\W+");
        String word = console.nextLine().toLowerCase();

        int count = 0;
        for (int i = 0; i < text.length; i++) {
            if (word.equals(text[i])){
                count++;
            }
        }

        System.out.println(count);
    }
}