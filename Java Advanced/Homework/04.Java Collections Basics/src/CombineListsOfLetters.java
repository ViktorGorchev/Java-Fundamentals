import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CombineListsOfLetters {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] firstLettersInput = console.nextLine().split("\\s+");
        String[] secondLettersInput = console.nextLine().split("\\s+");

        ArrayList<Character> firstList = new ArrayList<>(ConvertStringArrayToCharList(firstLettersInput));
        ArrayList<Character> secondList = new ArrayList<>(ConvertStringArrayToCharList(secondLettersInput));

        secondList.removeAll(firstList);
        firstList.addAll(secondList);

        printArrayList(firstList);
    }

    private static List<Character> ConvertStringArrayToCharList(String[] array){
        List<Character> listOfChars = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            listOfChars.add(array[i].charAt(0));
        }

        return listOfChars;
    }

    private static void printArrayList(ArrayList<Character> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i < array.size() - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}