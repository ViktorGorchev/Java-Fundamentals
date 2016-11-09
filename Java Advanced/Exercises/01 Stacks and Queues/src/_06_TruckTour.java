import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class _06_TruckTour {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        ArrayDeque<Station> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] token = console.nextLine().split("\\s+");
            int gas = Integer.valueOf(token[0]);
            int distance = Integer.valueOf(token[1]);
            Station station = new Station();
            station.gasGiven = gas;
            station.distanceToNext = distance;

            queue.addLast(station);
        }

        int gasInTank = 0;
        boolean foundFirst = false;
        int index = 0;
        while (true) {
            Station currentStation = queue.removeFirst();
            gasInTank += currentStation.gasGiven;
            queue.addLast(currentStation);
            Station firstStation = currentStation;
            int indexAddUp = 1;

            while (gasInTank >= currentStation.distanceToNext){
                gasInTank -= currentStation.distanceToNext;
                currentStation = queue.removeFirst();
                queue.addLast(currentStation);
                gasInTank += currentStation.gasGiven;
                indexAddUp++;

                if  (currentStation.equals(firstStation)){
                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst){
                break;
            }

            index += indexAddUp;
            gasInTank = 0;
        }

        System.out.println(index);
    }
}

class Station{
    int gasGiven;
    int distanceToNext;
}
