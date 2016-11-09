import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;


class Coordinates{
    public int row;
    public int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class TheHeiganDance {
    private static final int PLAGUE_CLOUD = 3500;
    private static final int ERUPTION = 6000;
    private static List<Coordinates> spellDamageArea;
    private static int board[][] = new int[15][15];

    private static BigDecimal damageToHeigan;
    private static boolean gameIsPlaying = true;
    private static int playerPoints = 18500;
    private static int playerRow;
    private static int playerCol;
    private static List<Coordinates> playerMoves;
    private static int plagueCloudNextTurnDamage = 0;
    private static boolean playerIsKilled = false;

    private static BigDecimal heiganPoints = new BigDecimal(3000000);
    private static String spell;
    private static boolean heiganIsDefeated = false;

    public static void main(String[] args) {
        seedGame();

        Scanner console = new Scanner(System.in);
        damageToHeigan = new BigDecimal(console.nextLine());
        String input = console.nextLine();
        String currentSpell = null;
        while (gameIsPlaying){
            String[] inputArray = input.split("\\s+");
            currentSpell = inputArray[0];
            int row = Integer.parseInt(inputArray[1]);
            int col = Integer.parseInt(inputArray[2]);

            heiganPoints = heiganPoints.subtract(damageToHeigan);
            if(heiganPoints.signum() <= 0){
                heiganIsDefeated = true;
            }

            if(plagueCloudNextTurnDamage > 0){
                playerPoints -= plagueCloudNextTurnDamage;
                plagueCloudNextTurnDamage = 0;
            }

            if(playerPoints <= 0){
                playerIsKilled = true;
            }

            if(heiganIsDefeated || playerIsKilled){
                break;
            }

            ExecuteSpell(currentSpell, row, col);
            spell = currentSpell;

            if(playerIsKilled){
                break;
            }

            input = console.nextLine();
            if(input.isEmpty()){
                gameIsPlaying = false;
            }
        }

        if(spell.equals("Cloud")){
            spell = "Plague Cloud";
        }

        if(heiganIsDefeated){
            System.out.println("Heigan: Defeated!");
        }else{
            System.out.printf("Heigan: %.2f\n", heiganPoints);
        }

        if(playerIsKilled){
            System.out.printf("Player: Killed by %s\n", spell);
        }else{
            System.out.printf("Player: %d\n", playerPoints);
        }

        System.out.printf("Final position: %d, %d\n", playerRow, playerCol);
    }

    private static void ExecuteSpell(String spell, int row, int col) {
        updateBoardSpell(row, col);

        if(board[playerRow][playerCol] == 0){
            Coordinates newPosition = playerCanMove();
            if(newPosition != null){
                playerRow = newPosition.row;
                playerCol = newPosition.col;
            }

            if(newPosition == null){
                tackePlayerPoints(spell);
            }
        }

        reseedBoard();
    }

    private static void tackePlayerPoints(String spell) {
        if(spell.equals("Eruption")){
            playerPoints -= ERUPTION;
        }

        if(spell.equals("Cloud")){
            playerPoints -= PLAGUE_CLOUD;
            plagueCloudNextTurnDamage = PLAGUE_CLOUD;
        }

        if(playerPoints <= 0){
            playerIsKilled = true;
        }
    }

    private static Coordinates playerCanMove() {
        Coordinates newPos = null;
        int movesCount = 4;
        for (int i = 0; i < movesCount; i++) {
            int tempRow = playerMoves.get(i).row + playerRow;
            int tempCol = playerMoves.get(i).col + playerCol;
            if(checkIfInBoard(tempRow, tempCol) && board[tempRow][tempCol] == 1){
                newPos = new Coordinates(tempRow, tempCol);
                return newPos;
            }
        }

        return newPos;
    }

    private static void updateBoardSpell(int rowSpell, int colSpell) {
        int spellDamagedSells = 9;
        for (int i = 0; i < spellDamagedSells; i++) {
            int tempDamageRow = spellDamageArea.get(i).row + rowSpell;
            int tempDamageCol = spellDamageArea.get(i).col + colSpell;
            boolean inBoard = checkIfInBoard(tempDamageRow, tempDamageCol);
            if(inBoard){
                board[tempDamageRow][tempDamageCol] = 0;
            }
        }
    }

    private static boolean checkIfInBoard(int row, int col) {
        boolean rowInBoard = row >= 0 && row < 15;
        boolean colInBoard = col >=0 && col < 15;
        return rowInBoard && colInBoard;
    }

    private static void seedGame() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = 1;
            }
        }

        playerRow = 7;
        playerCol = 7;

        playerMoves = new ArrayList<>();
        playerMoves.add(new Coordinates(-1, 0));
        playerMoves.add(new Coordinates(0, 1));
        playerMoves.add(new Coordinates(1, 0));
        playerMoves.add(new Coordinates(0, -1));

        spellDamageArea = new ArrayList<>();
        spellDamageArea.add(new Coordinates(0, 0));
        spellDamageArea.add(new Coordinates(-1, -1));
        spellDamageArea.add(new Coordinates(-1, 0));
        spellDamageArea.add(new Coordinates(-1, 1));
        spellDamageArea.add(new Coordinates(0, -1));
        spellDamageArea.add(new Coordinates(0, 1));
        spellDamageArea.add(new Coordinates(1, -1));
        spellDamageArea.add(new Coordinates(1, 0));
        spellDamageArea.add(new Coordinates(1, 1));
    }

    private static void reseedBoard(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = 1;
            }
        }
    }
}