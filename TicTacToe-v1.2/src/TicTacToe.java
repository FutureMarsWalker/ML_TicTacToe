import java.lang.reflect.Array;
import java.util.*;

public class TicTacToe{

    static ArrayList<Integer> userPositions = new ArrayList<Integer>();
    static ArrayList<Integer> brutusPositions = new ArrayList<Integer>();

    static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                                 {'-', '+', '-', '+', '-'},
                                 {' ', '|', ' ', '|', ' '},
                                 {'-', '+', '-', '+', '-'},
                                 {' ', '|', ' ', '|', ' '}};

    static Scanner scanUsrInput = new Scanner(System.in);
    static int userPos;
    static int brutusPos;


    public static void main(String[] args){

        drawGameBoard(gameBoard);

        while(true){

            Brutus.brutusPlays();

            System.out.println("Enter you placement (1 - 9)");
            userPos = scanUsrInput.nextInt();

            while(userPositions.contains(userPos) || brutusPositions.contains(userPos)){

                System.out.println("Position taken! Enter a correct position");
                userPos = scanUsrInput.nextInt();

            }

            drawPiece(gameBoard, userPos, "user");
            //drawGameBoard(gameBoard);

            Brutus.brutusPlays();

            String result = checkWinner();
            if(result.length() > 0){
                drawGameBoard(gameBoard);
                System.out.println(result);
                System.out.println("User position: " + userPositions);
                System.out.println("Brutus positions: " + brutusPositions);
                System.out.println("Input to Brutus: " + Brutus.input);
                break;
            }

            Brutus.brutusPlays();

            brutusPos = (int) (Math.random() * 9) + 1;

            while(userPositions.contains(brutusPos) || brutusPositions.contains(brutusPos)){

                //System.out.println("Position taken! Enter a correct position");
                brutusPos = (int)(Math.random() * 9) + 1;

            }

            drawPiece(gameBoard, brutusPos, "brutus");
            drawGameBoard(gameBoard);

            Brutus.brutusPlays();

            result = checkWinner();
            if(result.length() > 0){
                drawGameBoard(gameBoard);
                System.out.println(result);
                System.out.println(brutusPositions);
                System.out.println(userPositions);
                System.out.println("Input to Brutus: " + Brutus.input);
                break;
            }

        }
    }

    public static void drawGameBoard(char[][] gameBoard){

        for(char[] row : gameBoard){
            for(char column : row){
                System.out.print(column);
            }
            System.out.println();
        }

    }

    public static void drawPiece(char[][] gameBoard, int pos, String user){

        char symbol = ' ';

        if(user.equals("user")){
            symbol = 'X';
            userPositions.add(pos);
        }
        else if(user.equals("brutus")){
            symbol = 'O';
            brutusPositions.add(pos);
        }
        else{
            System.out.println("There is an error.");
        }

        switch(pos){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static String checkWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);

        for(List l : winningConditions){

            if(userPositions.containsAll(l)){

                return "Congratulations You Won!";

            }
            else if(brutusPositions.containsAll(l)){

                return "Brutus Wins! Sorry :(";

            }
            else if(userPositions.size() + brutusPositions.size() == 9){

                return "Tie";

            }

        }

        return "";

    }

}