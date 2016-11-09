import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ExtractAllUniqueWords {
    public static void main(String[] args) {
       Scanner console = new Scanner(System.in);
       String[] text = console.nextLine().toLowerCase().split("\\W+");

       ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(text));
       wordsList.sort(null);

       Object[] uniqueElements = Arrays.stream(text).distinct().toArray();
       Arrays.sort(uniqueElements);

       for (Object word : uniqueElements) {
           System.out.print(word + " ");
       }
    }
}
/*
 The output of the first example is wrong!
 It is “java to softuni welcome” but it should be “java softuni to welcome” because S is before T.
 */