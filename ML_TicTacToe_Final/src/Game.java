import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Board board;
    private Random random;


    public Game(){
        String[][] board = {{"[1]", " | ", "[2]", " | ",  "[3]"},
                            {"----+-----+----"},
                            {"[4]", " | ", "[5]", " | ", "[6]"},
                            {"----+-----+----"},
                            {"[7]", " | ",  "[8]", " | ", "[9]"}};
        for(String[] row : board){
            for(String col : row){
                System.out.print(col);
            }
            System.out.println();
        }
        initializeGame(); //This will setup the board
        displayBoard(); //Prints the board in the terminal
        makeFirstMove(); //Choice between who plays first: the computer or the player
        playGame(); //The main game loop
        checkStatus(); //Checks if someone has won the game
    }

    private void checkStatus() {
            if (board.isWinning(Player.COMPUTER)) {
                System.out.println("Computer has won! ☜(ﾟヮﾟ☜)");

            } else if (board.isWinning(Player.USER)) {
                System.out.println("Player has won! ☜(ﾟヮﾟ☜)");

            } else {
                System.out.println("It's a draw!");

            }
    }

    private void playGame() {

        while ( board.isRunning() ) {

            System.out.print("Enter your move (1(top left) - 9(bottom right)): ");
            int userCell = board.getScanner().nextInt(); //Gets user input
            System.out.print("Player's move: ");
            System.out.println();
            board.move(playerMove(userCell), Player.USER); // playerMove() translates 1 - 9 int into a Cell type compatible input
            board.displayBoard();

            if (!board.isRunning()) {
                break;
            }

            board.callMinimax(0, Player.COMPUTER); // Starts the minimax process, this process actually gets the target for the neural network

            Network.netTarget(board.getBestMove());
            System.out.println();
            System.out.println("Computer's move: ");
            board.move(Network.compCell, Player.COMPUTER);

            board.displayBoard();
        }
    }

    private Cell playerMove(int usercell){
        Cell userCell = null;
        if(usercell == 1){
            userCell = new Cell(0, 0);
        }else if(usercell == 2){
            userCell = new Cell(0, 1);
        }else if(usercell == 3){
            userCell = new Cell(0, 2);
        }else if(usercell == 4){
            userCell = new Cell(1, 0);
        }else if(usercell == 5){
            userCell = new Cell(1, 1);
        }else if(usercell == 6){
            userCell = new Cell(1, 2);
        }else if(usercell == 7){
            userCell = new Cell(2, 0);
        }else if(usercell == 8){
            userCell = new Cell(2, 1);
        }else if(usercell == 9){
            userCell = new Cell(2, 2);
        }
        return userCell;
    }

    private void makeFirstMove() {

        System.out.print("Who starts? 1 - Computer or 2 - User (1 or 2): ");
        int choice = board.getScanner().nextInt();

        if(choice == 1){
            System.out.print("Computer's move: ");
            Cell cell = new Cell(random.nextInt(Constants.BOARD_SIZE), random.nextInt(Constants.BOARD_SIZE));
            board.move(cell, Player.COMPUTER);
            board.displayBoard();
        }
    }

    private void displayBoard() {
        board.displayBoard();
    }

    private void initializeGame() {
        this.board = new Board();
        this.board.setupBoard();
        this.random = new Random();
    }
}
