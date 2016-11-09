import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputData = console.nextLine().split(" ");
        int sideA = Integer.parseInt(inputData[0]);
        int sideB = Integer.parseInt(inputData[1]);

        System.out.println(sideA * sideB);
    }
}