import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11_PoisonousPlants {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        List<Integer> plants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plants.add(console.nextInt());
        }

        console.nextLine();

        int days = 0;
        while (true){
            boolean noDeadPlants = true;
            List<Integer> plantsToRemove = new ArrayList<>();
            for (int i = 1; i < plants.size(); i++) {
                if(plants.get(i) > plants.get(i - 1)){
                    plantsToRemove.add(i);
                    noDeadPlants = false;
                }
            }


            for (int i = plantsToRemove.size() - 1; i >= 0; i--) {
                int index = plantsToRemove.get(i);
                plants.remove(index);
            }

            if(noDeadPlants){
                break;
            }

            days++;
        }

        System.out.println(days);
    }
}