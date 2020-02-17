import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Brutus {

    static ArrayList<Integer> input = new ArrayList<>(
            List.of(0, 0, 0, 0, 0, 0, 0, 0, 0)
    );
    static int xValue = -1;
    static int oValue = 1;

    public static void brutusPlays(){

        taken();
        //System.out.println(input);
        //TicTacToe.brutusPos = (int)(Math.random() * 9) + 1;
        //return TicTacToe.brutusPos;

    }

    private static ArrayList<Integer> taken(){

        for(int value : TicTacToe.userPositions){
            input.set(value - 1, xValue );
        }

        for(int value : TicTacToe.brutusPositions){
            input.set(value - 1, oValue);
        }

        return input;

    }

}
