import java.awt.*;
import java.util.Scanner;

public class GhettoNumeralSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();

        String getto[] = {"Gee","Bro","Zuz", "Ma","Duh","Yo", "Dis","Hood","Jam", "Mack"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            int index = Integer.parseInt(Character.toString(number.charAt(i)));
            result.append(getto[index]);
        }

        System.out.print(result);
    }
}
