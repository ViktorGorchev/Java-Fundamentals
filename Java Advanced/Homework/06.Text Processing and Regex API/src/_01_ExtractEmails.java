import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_ExtractEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        String emailMatcher = "((?<=\\s)|^)([a-z0-9][a-z0-9\\-._]*[a-z0-9])@([a-z0-9][a-z0-9\\-]*[a-z0-9]\\.)+[a-z0-9]+";
        Pattern pattern = Pattern.compile(emailMatcher);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
