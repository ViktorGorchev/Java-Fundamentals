import java.util.Scanner;

public class _07_BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        if(input.length() > 0 && input.length() % 2 == 0){
            boolean notBalanced = false;
            for (int i = 0; i < input.length() / 2; i++) {
                char currentChar = input.charAt(i);
                switch (currentChar){
                    case '{':
                        if(input.charAt((input.length() - 1)- i) != '}'){
                            notBalanced = true;
                        }

                        break;
                    case '[':
                        if(input.charAt((input.length() - 1)- i) != ']'){
                            notBalanced = true;
                        }

                        break;
                    case '(':
                        if(input.charAt((input.length() - 1)- i) != ')'){
                            notBalanced = true;
                        }

                        break;
                    case ' ':
                        if(input.charAt((input.length() - 1)- i) != ' '){
                            notBalanced = true;
                        }

                        break;
                    default:
                        break;
                }
            }

            if (notBalanced){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }else {
            System.out.println("NO");
        }
    }
}