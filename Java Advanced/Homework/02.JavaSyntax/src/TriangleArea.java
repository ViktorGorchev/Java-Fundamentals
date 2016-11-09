import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        int numbersCount = 6;
        Scanner console = new Scanner(System.in);
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < numbersCount ; i++) {
            int inputNumber = console.nextInt();
            data.add(inputNumber);
        }

        int aX = data.get(0);
        int aY = data.get(1);

        int bX = data.get(2);
        int bY = data.get(3);

        int cX = data.get(4);
        int cY = data.get(5);

        double result = (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2.0;
        System.out.println(Math.abs(Math.round(result)));
    }
}