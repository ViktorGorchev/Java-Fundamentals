import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargestSequenceOfEqualStrings {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputLine = console.nextLine().split(" ");

        Object[] uniqueElements = Arrays.stream(inputLine).distinct().toArray();
        Collections.reverse(Arrays.asList(uniqueElements));
        String maxElement = null;
        int maxCount = 0;

        for (int i = 0; i < uniqueElements.length; i++) {
            String uniqueElement = uniqueElements[i].toString();
            int elementCounter = 0;
            for (int j = 0; j < inputLine.length; j++) {
                if (uniqueElement.equals(inputLine[j])){
                    elementCounter++;
                }
            }

            if (elementCounter >= maxCount){
                maxCount = elementCounter;
                maxElement = uniqueElement;
            }
        }

        System.out.println(String.join(" ", Collections.nCopies(maxCount, maxElement)));
    }
}