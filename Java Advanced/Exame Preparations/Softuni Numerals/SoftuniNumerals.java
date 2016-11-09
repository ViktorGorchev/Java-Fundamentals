import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniNumerals {
    public static void main(String[] args) {
        List<String> letters = new ArrayList<>();
        letters.add("aa");
        letters.add("aba");
        letters.add("bcc");
        letters.add("cc");
        letters.add("cdc");

        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        String regex = "(aa|aba|bcc|cc|cdc)";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        String numberNotConverted = "";
        while (matcher.find()) {
            String lettersNumber = matcher.group(1);
            numberNotConverted += letters.indexOf(lettersNumber) + "";
        }

        BigInteger convertedNumber = new BigInteger (numberNotConverted, 5);
        System.out.println(convertedNumber);
    }
}