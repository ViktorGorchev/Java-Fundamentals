import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdScript {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        long key = console.nextLong();
        StringBuilder text = new StringBuilder();
        String input = console.nextLine();
        while (!input.equals("End")){
            text.append(input);

            input = console.nextLine();
        }

        boolean isUpperLetter = false;
        long separator = 1;
        for (long i = 1; i <= key; i++) {
            if(i - separator == 26){
                separator = i;
                if(isUpperLetter){
                    isUpperLetter = false;
                }else {
                    isUpperLetter = true;
                }
            }
        }

        long letterAtPos = key - separator;
        String keyLetters;
        if(isUpperLetter){
            keyLetters = (char)('A' + letterAtPos) + "" + (char)('A' + letterAtPos);
        }else {
            keyLetters = ((char)('A' + letterAtPos) + "" + (char)('A' + letterAtPos)).toLowerCase();
        }

        String regex = "(" + keyLetters + ")(.*?)(" + keyLetters + ")";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()) {
            if (matcher.group(2).length() > 0) {
                System.out.println(matcher.group(2));
            }
        }
    }
}