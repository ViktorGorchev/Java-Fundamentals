public class PrintCharacters {
    public static void main(String[] args) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < letters.length(); i++) {
           System.out.print(letters.charAt(i) + " ");
        }
    }
}
