import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class E1 {
    public static void main(String[] args) throws IOException {
        Queue<String> bunkers = new ArrayDeque<>();
        HashMap<String, Queue<Integer>> data = new HashMap<>();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(console.readLine());

        while (true){
            String input = console.readLine();
            if(input.equals("Bunker Revision")){
                break;
            }

            String[] inputParams = input.split("[\\s]+");
            for (int i = 0; i < inputParams.length; i++) {
                try {
                    int weapon = Integer.parseInt(inputParams[i]);
                    //data.get(bunkers.peek()).add(weapon);
                    if(bunkers.size() > 1){
                        int sum = sumWeapons(data, bunkers);
                        if(weapon <= capacity && capacity - sum <= weapon){
                            data.get(bunkers.peek()).add(weapon);
                        }




                    } else{

                    }






                }catch (NumberFormatException e){
                    String bunker = inputParams[i];
                    bunkers.add(bunker);
                    if(! data.containsKey(bunker)){
                        data.put(bunker, new ArrayDeque<>());
                    }
                }
            }
        }

        System.out.println(bunkers);
        System.out.println(data);


        console.close();
    }

    private static int sumWeapons(HashMap<String, Queue<Integer>> data, Queue<String> bunkers) {
        HashMap<String, Queue<Integer>> tempData = data;
        int sum = 0;
        for (int i = 0; i < tempData.get(bunkers.peek()).size(); i++) {
             sum += tempData.get(bunkers.peek()).remove();
        }

        return sum;
    }


}
