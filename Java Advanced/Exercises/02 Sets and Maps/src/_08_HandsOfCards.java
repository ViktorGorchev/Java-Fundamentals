import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> playerCards = new LinkedHashMap<>();

        while (true){
            String input = console.nextLine();
            if(input.equals("JOKER")){
                break;
            }

            String[] inputData = input.split(":");
            String name = inputData[0];
            String[] cardsArray = inputData[1].trim().split(", ");
            if(!playerCards.containsKey(name)){
                playerCards.put(name, new HashSet<>());
            }

            for (int i = 0; i < cardsArray.length; i++) {
                playerCards.get(name).add(cardsArray[i]);
            }
        }

        for (Map.Entry<String,HashSet<String>> playerHand : playerCards.entrySet()) {
            int playerScore = 0;
            for (String card : playerHand.getValue()) {
                char type = card.charAt(card.length() - 1);
                int multiplier = 1;
                switch (type){
                    case 'S':
                        multiplier = 4;
                        break;
                    case 'H':
                        multiplier = 3;
                        break;
                    case 'D':
                        multiplier = 2;
                        break;
                    case 'C':
                        multiplier = 1;
                        break;
                    default:
                        break;
                }

                switch (card.charAt(0)){
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        playerScore += (card.charAt(0) - 48) * multiplier;
                        break;
                    case '1':
                        playerScore += 10 * multiplier;
                        break;
                    case 'J':
                        playerScore += 11 * multiplier;
                        break;
                    case 'Q':
                        playerScore += 12 * multiplier;
                        break;
                    case 'K':
                        playerScore += 13 * multiplier;
                        break;
                    case 'A':
                        playerScore += 14 * multiplier;
                        break;
                    default:
                        break;
                }
            }

            System.out.printf("%s: %d%n", playerHand.getKey(), playerScore);
        }
    }
}