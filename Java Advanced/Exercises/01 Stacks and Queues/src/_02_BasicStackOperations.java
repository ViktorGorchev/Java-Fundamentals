import java.util.Scanner;
import java.util.Stack;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberOfelementsToPush = console.nextInt();
        int numberOfelementsToPop = console.nextInt();
        int elementToCheck = console.nextInt();
        console.nextLine();

        Stack<Integer> numbersStack = new Stack<>();
        for (int i = 0; i < numberOfelementsToPush; i++) {
            numbersStack.push(console.nextInt());
        }

        for (int i = 0; i < numberOfelementsToPop; i++) {
            numbersStack.pop();
        }

        if (numbersStack.size() > 0) {
            if(numbersStack.contains(elementToCheck)){
                System.out.println("true");
            }else {
                System.out.println(smallestElement(numbersStack));
            }

        } else
            System.out.println(0);
        }

    private static Integer smallestElement(Stack<Integer> numbersStack) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.addAll(numbersStack);
        int smallestNumber = Integer.MAX_VALUE;
        for (int i = 0; i < tempStack.size(); i++) {
            int currentNumber = tempStack.pop();
            if (currentNumber < smallestNumber){
                smallestNumber = currentNumber;
            }
        }

        return smallestNumber;
    }
}