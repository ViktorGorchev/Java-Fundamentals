import java.util.*;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int enqueueNumber = console.nextInt();
        int numberOfelementsToDequeue  = console.nextInt();
        int elementToCheck = console.nextInt();
        console.nextLine();

        Queue<Integer> numbersQueue = new ArrayDeque<>();
        for (int i = 0; i < enqueueNumber; i++) {
            numbersQueue.add(console.nextInt());
        }

        for (int i = 0; i < numberOfelementsToDequeue; i++) {
            numbersQueue.poll();
        }

        if (numbersQueue.size() > 0) {
            if(numbersQueue.contains(elementToCheck)){
                System.out.println("true");
            }else {
                System.out.println(smallestElement(numbersQueue));
            }

        } else
            System.out.println(0);
    }

    private static Integer smallestElement(Queue<Integer> numbersQueue) {
        Queue<Integer> tempQueue = new ArrayDeque<>();
        tempQueue.addAll(numbersQueue);
        int smallestNumber = Integer.MAX_VALUE;
        for (int i = 0; i < tempQueue.size(); i++) {
            int currentNumber = tempQueue.poll();
            if (currentNumber < smallestNumber){
                smallestNumber = currentNumber;
            }
        }

        return smallestNumber;
    }
}