import java.util.*;

public class MostFrequentWord {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] text = console.nextLine().toLowerCase().split("\\W+");

        HashMap<Integer, ArrayList<String>> wordsCount = new HashMap<>();
        ArrayList<String> checkedWords = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            String currentWord = text[i];
            if (checkedWords.contains(currentWord)){
                continue;
            }

            checkedWords.add(currentWord);
            int count = 0;
            for (int j = 0; j < text.length; j++) {
                if (text[j].equals(currentWord)){
                    count++;
                }
            }

            if (!wordsCount.containsKey(count)){
                wordsCount.put(count, new ArrayList<>());
            }

            wordsCount.get(count).add(currentWord);
        }

        int maxWordsKey = Collections.max(wordsCount.keySet());
        Collections.sort(wordsCount.get(maxWordsKey));
        for (String word : wordsCount.get(maxWordsKey)) {
            System.out.printf("%s -> %d times\r\n", word, maxWordsKey);
        }
    }
}