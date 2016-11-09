import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        LinkedHashSet<String> userNames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            userNames.add(console.nextLine());
        }

        for (String userName : userNames) {
            System.out.println(userName);
        }
    }
}
