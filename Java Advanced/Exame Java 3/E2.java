import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class E2 {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(console.readLine());

        int cubesNotHit = size * size * size;
        BigInteger sumHits = BigInteger.ZERO;

        while (true){
            String input = console.readLine();
            if(input.equals("Analyze")){
                break;
            }

            String[] inputLine = input.split("[\\s]+");
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < inputLine.length; i++) {
                numbers.add(Integer.parseInt(inputLine[i]));
            }

            boolean inRange = true;
            for (int i = 0; i < numbers.size() - 1; i++) {
                int num = numbers.get(i);

                if(num < 0 || num > size - 1){
                    inRange = false;
                }
            }

            if(inRange && (numbers.get(numbers.size() - 1) > 0)){
                sumHits = sumHits.add(new BigInteger(numbers.get(numbers.size() - 1).toString()));
                cubesNotHit--;
            }

        }


        System.out.println(sumHits);
        System.out.println(cubesNotHit);
        console.close();
    }
}
