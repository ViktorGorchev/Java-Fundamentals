import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_StartsAndEndsWithCapitalLetter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
       String input = console.nextLine();

       String regex = "\\b[A-Z][a-zA-Z]*[A-Z]\\b";
       Pattern pattern = Pattern.compile(regex);
       Matcher matcher = pattern.matcher(input);

       while(matcher.find()) {
           System.out.print(matcher.group() + " ");
       }
    }
}
