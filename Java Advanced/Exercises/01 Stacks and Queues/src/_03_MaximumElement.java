import java.util.Scanner;
import java.util.Stack;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(console.nextLine());

        Stack<Integer> numbersStack = new Stack<>();
        for (int i = 0; i < numberOfLines; i++) {
            String[] input = console.nextLine().split("\\s+");
            String command = input[0];
            if(command.equals("1")){
                numbersStack.push(Integer.parseInt(input[1]));
            }

            if(command.equals("2") && !numbersStack.empty()){
                numbersStack.pop();
            }

            if(command.equals("3")){
                System.out.println(maxElement(numbersStack));
            }
        }
    }

    private static Integer maxElement(Stack<Integer> numbersStack) {
        Stack<Integer> tempStack = new Stack<>();
        tempStack.addAll(numbersStack);
        int largestNumber = Integer.MIN_VALUE;
        int stackSize = tempStack.size();
        for (int i = 0; i < stackSize; i++) {
            int currentNumber = tempStack.pop();
            if (currentNumber > largestNumber){
                largestNumber = currentNumber;
            }
        }

        return largestNumber;
    }
}