import java.util.Scanner;
import java.util.Stack;

public class _10_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        Stack<String> undoData = new Stack<>();
        StringBuilder text = new StringBuilder();
        text.append(" ");
        for (int i = 0; i < n; i++) {
            String input = console.nextLine();

            String command = input.charAt(0) + "";

            switch (command){
                case "1":
                    text.append(input.substring(2, input.length()));
                    undoData.push(text.toString());
                    break;
                case "2":
                    text.delete(text.length() - Integer.parseInt(input.substring(2, input.length())), text.length());
                    undoData.push(text.toString());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(input.substring(2, input.length()))));
                    break;
                case "4":
                    if(undoData.size() < 2){
                        break;
                    }

                    undoData.pop();
                    String previousText = undoData.peek();
                    text.delete(0, text.length());
                    text.append(previousText);
                    break;
                default:
                    break;
            }
        }
    }
}