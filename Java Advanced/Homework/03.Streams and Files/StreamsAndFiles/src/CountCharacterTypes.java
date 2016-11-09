import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/words.txt"))){
            String fileLine = reader.readLine();
            while (fileLine != null){
                text.append(fileLine.toLowerCase());
                fileLine = reader.readLine();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        List vowels = new ArrayList(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.toString(text.charAt(i)).equals(" ")){
                continue;
            }

            if (vowels.contains(text.charAt(i))){
                vowelsCount++;
                continue;
            }

            if (text.charAt(i) >= (int)'a' && text.charAt(i) <= 'z'){
                consonantsCount++;
                continue;
            }

            punctuationCount++;
        }

        System.out.printf("Vowels: %d\nConsonants: %d\nPunctuation: %d\n",
                vowelsCount,
                consonantsCount,
                punctuationCount);
    }
}