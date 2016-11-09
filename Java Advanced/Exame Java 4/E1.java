import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> flowers = new LinkedList<>();
        flowers.addAll(Arrays.asList(reader.readLine().split("[\\s]+")));

        Stack<String> buckets = new Stack<>();
        buckets.addAll(Arrays.asList(reader.readLine().split("[\\s]+")));

        List<Integer> secondNatureFlowers = new ArrayList<>();

        int flowersSize = flowers.size();
        int waterLeft = 0;
        for (int i = 0; i < flowersSize; i++) {
            int bucket = Integer.parseInt(buckets.pop());
            int flower = Integer.parseInt(flowers.remove());

            if(bucket + waterLeft == flower){
                secondNatureFlowers.add(flower);
                waterLeft = 0;
                continue;
            }

            waterLeft = (bucket + waterLeft) - flower;
        }

        if(buckets.size() > 0){

            buckets.push(String.valueOf(waterLeft + Integer.parseInt(buckets.pop())));
        }

        if(buckets.size() > 0){
            int bucketsSize = buckets.size();
            for (int i = 0; i < bucketsSize; i++) {
                System.out.print(buckets.pop() + " ");

            }
        }else {
            int fSize = flowers.size();
            for (int i = 0; i < fSize; i++) {
                System.out.print(flowers.remove() + " ");

            }
        }




        System.out.println();

        if(secondNatureFlowers.size() == 0){
            System.out.println("None");
        }else {
            int size = secondNatureFlowers.size();
            for (int i = 0; i < size; i++) {
                System.out.print(secondNatureFlowers.get(i) + " ");
            }
        }


//        System.out.println(buckets);
//        System.out.println(flowers);
//        System.out.println(secondNatureFlowers);
    }
}
