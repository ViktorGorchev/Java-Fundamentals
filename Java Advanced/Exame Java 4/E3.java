import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E3 {

    private static final int FROM_UPPER_TO_LOWER_CASE_CHAR_DIFFERENCE = 32;

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder data = new StringBuilder();

        while (true){
            String input = reader.readLine();
            if(input.equals("---NMS SEND---")){
                break;
            }

            data.append(input);
        }

        String delimiter = reader.readLine();

        StringBuilder result = new StringBuilder();
        result.append(data.charAt(0));
        boolean isNewWord = false;
        for (int i = 1; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            char previousChar = data.charAt(i - 1);

            if(isNewWord){
                result.append(previousChar);
                i--;
                isNewWord = false;
                continue;
            }

            boolean currentCharIsUpper = data.charAt(i) > 64 && data.charAt(i) < 91;
            boolean previousCharIsUpper = data.charAt(i - 1) > 64 && data.charAt(i - 1) < 91;

            if(currentCharIsUpper
                    && previousCharIsUpper
                    && currentChar < previousChar){

                result.append(delimiter);
                isNewWord = true;
                continue;
            }

            if(! currentCharIsUpper
                    && ! previousCharIsUpper
                    && currentChar < previousChar){

                result.append(delimiter);
                isNewWord = true;
                continue;
            }

            if(currentCharIsUpper
                    && ! previousCharIsUpper
                    && currentChar < previousChar - FROM_UPPER_TO_LOWER_CASE_CHAR_DIFFERENCE){

                result.append(delimiter);
                isNewWord = true;
                continue;
            }

            if(! currentCharIsUpper
                    && previousCharIsUpper
                    && currentChar - FROM_UPPER_TO_LOWER_CASE_CHAR_DIFFERENCE < previousChar){

                result.append(delimiter);
                isNewWord = true;
                continue;
            }

            result.append(data.charAt(i));
        }

        System.out.println(result);
    }
}
