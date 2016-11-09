import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_FilterArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] words = console.nextLine().split("\\s+");

        List<String> filteredWords = Arrays.asList(words).stream().
              filter(w -> w.toString().length() > 3).collect(Collectors.toList());

        if(filteredWords.size() == 0){
            System.out.println("(empty)");
        }else{
            System.out.println(String.join(" ", filteredWords));
        }
    }
}
