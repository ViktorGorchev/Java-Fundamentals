import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E3_2 {

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

            if(Character.toLowerCase(currentChar) < Character.toLowerCase(previousChar)){
                if (i == data.length() - 1){
                    result.append(delimiter);
                    result.append(currentChar);
                    break;
                }

                result.append(delimiter);
                isNewWord = true;
                continue;
            }

            result.append(data.charAt(i));
        }

        System.out.println(result);
    }

}
