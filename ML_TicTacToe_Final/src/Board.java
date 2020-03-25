import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board {

    public List<Cell> rootValues;
    public int best = Integer.MIN_VALUE;
    private Scanner scanner;
    private Player[][] board;

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        this.rootValues = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.board = new Player[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    }

    public boolean isRunning() { // Checks if the game is still going on

        if( isWinning(Player.COMPUTER) ) return false;
        if( isWinning(Player.USER)) return false;
        return !getEmptyCells().isEmpty();
    }

    public boolean isWinning(Player player) { // Checks who is winning

        if ( board[0][0] == player && board[1][1] == player && board[2][2] == player ) {
            return true;
        }

        if( board[0][2] == player && board[1][1] == player && board[2][0] == player ){
            return true;
        }

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {

            // checking the rows
            if ( board[i][0] == player && board[i][1] == player && board[i][2] == player ) {
                return true;
            }

            // checking the columns
            if( board[0][i] == player && board[1][i] == player && board[2][i] == player ){
                return true;
            }
        }

        return false;
    }

    public List<Cell> getEmptyCells() { // Get the cells that haven't been played on

        List<Cell> emptyCells = new ArrayList<>();

        for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
            for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
                if (board[i][j] == Player.NONE) {
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        return emptyCells;
    }

    public void move(Cell point, Player player) { // Adds a X or an O on the game board
        board[point.getX()][point.getY()] = player;
    }

    public Cell getBestMove() { // This helps the neural network make the decision to play its move

        int max = Integer.MIN_VALUE;
        best = Integer.MIN_VALUE;
        for (int i = 0; i < rootValues.size(); ++i) {

            if (max < rootValues.get(i).getMinimaxValue()) {
                max = rootValues.get(i).getMinimaxValue();
                best = i;
            }
        }

        return rootValues.get(best);
    }

    public void displayBoard() {

        System.out.println();

        for (int i = 0; i < Constants.BOARD_SIZE; ++i) {
            for (int j = 0; j < Constants.BOARD_SIZE; ++j) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public int returnMin(List<Integer> list) { // The output is used in the minimax algorithm

        int min = Integer.MAX_VALUE;
        int index = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    public int returnMax(List<Integer> list) { // The output is used in the minimax algorithm
        int max = Integer.MIN_VALUE;
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }

        return list.get(index);
    }

    public void callMinimax(int depth, Player player){ // Calls the minimax() from another class
        rootValues.clear();
        minimax(depth, player);
    }

    public int minimax(int depth, Player player) {

        if (isWinning(Player.COMPUTER)) return + 1;
        if (isWinning(Player.USER)) return - 1;

        List<Cell> availableCells = getEmptyCells();

        if (availableCells.isEmpty()) return 0;

        List<Integer> scores = new ArrayList<>();

        for (Cell point : availableCells) {

            if (player == Player.COMPUTER) { //X's turn select the highest from below minimax() call
                move(point, Player.COMPUTER);
                int currentScore = minimax(depth + 1, Player.USER);
                scores.add(currentScore);

                if (depth == 0) {
                    point.setMinimaxValue(currentScore);
                    rootValues.add(point);

                }

            } else if (player == Player.USER) {//O's turn select the lowest from below minimax() call
                move(point, Player.USER);
                scores.add(minimax(depth + 1, Player.COMPUTER));
            }

            board[point.getX()][point.getY()] = Player.NONE; //Reset this point
        }

        if( player == Player.COMPUTER ){
            return returnMax(scores);
        }

        return returnMin(scores);
    }

    public void setupBoard() { // Makes the board but does not print it
        for(int i=0;i<Constants.BOARD_SIZE;i++){
            for(int j=0;j<Constants.BOARD_SIZE;j++){
                board[i][j] = Player.NONE;
            }
        }
    }

    public Scanner getScanner() { // This is used in another class to securely return the scanner
        return scanner;
    }

}
