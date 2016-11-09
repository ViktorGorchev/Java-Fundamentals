import java.util.Scanner;

public class CountAllWords {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] words = console.nextLine().split("\\W+");
        System.out.println(words.length);
    }
}
