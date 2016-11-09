import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardsFrequencies {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        List<String> allMatches = new ArrayList<>();
        String pattern = "([\\d]{1,2}|[AKJQ])";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            allMatches.add(matcher.group());
        }

        ArrayList<String> checkedCards = new ArrayList<>();
        for (int i = 0; i < allMatches.size(); i++) {
            String currentCard = allMatches.get(i);
            if (checkedCards.contains(currentCard)){
                continue;
            }

            checkedCards.add(currentCard);
            int count = 0;
            for (int j = 0; j < allMatches.size(); j++) {
                if (currentCard.equals(allMatches.get(j))){
                    count++;
                }
            }

            float percent = ((float) count / allMatches.size()) * 100;
            System.out.printf("%s -> %.2f%%\r\n", currentCard, percent);
        }
    }
}