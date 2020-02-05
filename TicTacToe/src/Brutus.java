import java.util.Arrays;
import java.util.Random;

public class Brutus {

    static int[] input = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int xValue = -1;
    static int oValue = 1;

    public Brutus() {

        cpuPlays();

    }

    public static void cpuPlays() {

        input[TicTacToe.playerPositions.get(0) - 1] = xValue;
        System.out.println(Arrays.toString(input));

        TicTacToe tic = new TicTacToe();

        while(true){

            Random rand = new Random();
            tic.cpuPos = rand.nextInt(9) + 1;

            while(TicTacToe.cpuPositions.contains(tic.cpuPos) || TicTacToe.playerPositions.contains(tic.cpuPos)){

                tic.cpuPos = rand.nextInt(9) + 1;

            }

            TicTacToe.placePiece(TicTacToe.gameBoard, tic.cpuPos, "cpu");

            TicTacToe.printGameBoard(TicTacToe.gameBoard);

            String result = TicTacToe.checkWinner();
            if(result.length() > 0) {
                System.out.println(result);
                break;

            }
        }
    }

    public static int[] taken(){

        return input;

    }
}
