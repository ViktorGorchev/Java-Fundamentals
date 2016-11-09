import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E3_2 {
    private static List<String> cards = new ArrayList<>();
    private static int flushCount = 0;

    public static void main(String[] args) {
        String regex = "(10|[JQKA])([cdhs])";

        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i < n; i++) {
            String input = console.nextLine();
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String card = matcher.group(1);
                String type = matcher.group(2);
                cards.add(card + type);
            }
        }

        checkForFlush();
        System.out.printf("Royal's Royal Flushes - %d.\n", flushCount);
    }

    private static void checkForFlush() {
        String stringFlush = "10JQKA";

        for (int i = 0; i < cards.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(cards.get(i));
            String type = sb.substring(sb.length() -1, sb.length());
            String card = sb.deleteCharAt(sb.length() -1).toString();

            if(!card.equals("10")){
                continue;
            }

            StringBuilder foundCards = new StringBuilder();
            List<Integer> cardsIndexes = new ArrayList<>();
            for (int k = i; k < cards.size(); k++) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(cards.get(k));
                String typeOfCurrentCard = sb2.substring(sb2.length() -1, sb2.length());
                if(!type.equals(typeOfCurrentCard)){
                    continue;
                }

                String currentCard = sb2.deleteCharAt(sb2.length() -1).toString();
                foundCards.append(currentCard);
                cardsIndexes.add(k);

                int indexOfFirstCard = foundCards.indexOf(stringFlush);
                if(foundCards.toString().contains(stringFlush) && indexOfFirstCard + 4 < cardsIndexes.size() -1){

                    cards.set(cardsIndexes.get(indexOfFirstCard), "0c");
                    cards.set(cardsIndexes.get(indexOfFirstCard + 1), "0c");
                    cards.set(cardsIndexes.get(indexOfFirstCard + 2), "0c");
                    cards.set(cardsIndexes.get(indexOfFirstCard + 3), "0c");
                    cards.set(cardsIndexes.get(indexOfFirstCard + 4), "0c");

                    String fullType = null;
                    switch (type){
                        case "c":
                            fullType = "Clubs";
                            break;
                        case "d":
                            fullType = "Diamonds";
                            break;
                        case "h":
                            fullType = "Hearts";
                            break;
                        case "s":
                            fullType = "Spades";
                            break;
                        default:
                            break;
                    }

                    System.out.println("Royal Flush Found - " + fullType);
                    flushCount = flushCount + 1;

                    foundCards.delete(0, foundCards.length());
                    cardsIndexes.clear();
                }
            }
        }
    }
}
