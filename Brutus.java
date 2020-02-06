
/**
 * Brutus is an array and list AI
 *
 * To do: add a method so that if a move is on both the good and bad lists, it gets removed from both
 *
 * @author Eli
 * @version 0.9
 */
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
public class Brutus
{
    
    private ArrayList<String> thisGameInput;
    private ArrayList<Integer> thisGameOutput;
    
    private ArrayList<String> input;
    private ArrayList<Integer> output;
    private ArrayList<Integer> outputSuccess;
    private ArrayList<Integer> thisGameOutputSuccess;
    private static File fileInput = new File("brutusInput.txt");
    private static File fileOutput = new File("brutusOutput.txt");
    private static File fileOutputSuccess = new File("brutusOutputSuccess.txt");
    private Game board = new Game();
    private ArrayList<Integer> memoriesUsed;
    
    private boolean randomEnabled;
    private boolean isObserver;
    //variable used in the boardEquals method to allow the machine
    //to virtually flip/rotate the board in its mind, speeding learning by up to 8X
    //(This does not  here yet, though)
    private int[] currentBoard = new int[9];

    
    public Brutus(boolean isObserver)
    {
        thisGameInput = new ArrayList();
        thisGameOutput = new ArrayList();
        
        input = new ArrayList();
        output = new ArrayList();
        outputSuccess = new ArrayList();
        memoriesUsed = new ArrayList();
        
        this.isObserver = isObserver;
        
        loadMemoryFromFiles();
        if (input.size() != output.size() || input.size() != outputSuccess.size())
        {
            System.err.println("The memory files are messed up.");
            System.err.println(input.size());
            System.err.println(output.size());
            System.err.println(outputSuccess.size());
        }

        Scanner scan = new Scanner(System.in);
        //remove this after improving code to not get stuck
        System.out.println("Enable random moving? (Helps when computer gets \"Stuck\")");
        try {
            randomEnabled = scan.nextBoolean();
        } catch (java.util.InputMismatchException e)
        {
            System.out.println("setting to default: false");
            randomEnabled = false;
        }
        //show();
    }
    public int move(String bd, boolean isX)//bd is for board
    {
        if (isObserver) {
        //chance of choosing: 0=no chance, 1=not prefered, 2=neutral, 3=good
        int[] chanceOfChoosing = new int[9];
        
        //NEW
        //0 no, 1 5-6 move loss, 2 7-8 move loss, 3 9 move loss, 4 tie/unknown, 5 9 move win, 6 7-8 move win, 7 5-6 move win
         //if the space is full, set the chance of choosing it to 0
        for (int i = 0; i < bd.length(); i++)
        {
            if (bd.substring(i, i + 1).equalsIgnoreCase("x") || bd.substring(i, i + 1).equalsIgnoreCase("o"))
            {
                chanceOfChoosing[i] = -1;
            } 
            else 
            {
                chanceOfChoosing[i] = 4;//if not, set it to 4 temporarily
            }
        }
        //loop through the memory
        //if the space is in memory, set chanceOfChoosing to how good of a move it is
        //WORK HERE
        //int startI = (int)(Math.random() * input.size());
        int startI = 0;
        for (int i = startI; i < input.size(); i++)
        
        //for (int i = 0; i < input.size(); i++)
        {
            if(bd.equals(input.get(i)))//doesn't use virtual board-flip
            //if (boardEquals(bd, failInput.get(i)))//uses virtual board-flip
            {
                memoriesUsed.add(i);
                chanceOfChoosing[output.get(i)] = outputSuccess.get(i);//doesn't use virtual board-flip
                //chanceOfChoosing[currentBoard[failOutput.get(i)] - 1] = 1;//uses virtual board-flip
            }
        }
        for (int i = 0; i < startI; i++)
        {
            if(bd.equals(input.get(i)))//doesn't use virtual board-flip
            //if (boardEquals(bd, failInput.get(i)))//uses virtual board-flip
            {
                memoriesUsed.add(i);
                chanceOfChoosing[output.get(i)] = outputSuccess.get(i);//doesn't use virtual board-flip
                //chanceOfChoosing[currentBoard[failOutput.get(i)] - 1] = 1;//uses virtual board-flip
            }
        }
        //Display chanceOfChoosing (remove in final version)
        String stringChanceOfChoosing = "";
        for (int value: chanceOfChoosing)
        {
            stringChanceOfChoosing += value;
        }
        System.out.println();
        board.printChances(stringChanceOfChoosing);//
        System.out.println();

        //find the best space(prioritizes first in list) and play there, returns -1 for error
        //pick a random order for checking all of the variables
        int[] order = {0,1,2,3,4,5,6,7,8};//all the possible moves
        if (randomEnabled)
        {
            order = getRandomOrder();
        }
        //NEW nested for loop
        for (int j = 7; j >= 0; j--)
        {
            for (int i = 0; i < chanceOfChoosing.length; i++)
            {
                if (chanceOfChoosing[order[i]] == j)
                {
                    thisGameInput.add(bd);
                    thisGameOutput.add(order[i]);
                    return order[i] + 1;//WORK HERE, RETURNS WRONG MOVE?
                }
            }
        }

        System.out.println("ERROR");
        return 8;
    } else {
        System.out.println("ERROR: Brutus cannot move because it is an observer");
        return -1;
    }
    }

    public void observe(String board, int move)
    {
        thisGameInput.add(board);
        thisGameOutput.add(move);
    }
    public void learn(int results)
    {
        for (int i = 0; i < thisGameInput.size(); i++)
        {
            //WORK HERE
            //in the "else", it always maxes at 7, which is a problem
            if (results < 5)
            {
                outputSuccess.add(results - i + 1);
                input.add(thisGameInput.get(i));
                output.add(thisGameOutput.get(i));
            } else {
                outputSuccess.add(results + i - 2);
                input.add(thisGameInput.get(i));
                output.add(thisGameOutput.get(i));  
            }
        }
        cleanMemory();
       
        thisGameInput = new ArrayList<String>();
        thisGameOutput = new ArrayList<Integer>();
        memoriesUsed = new ArrayList<Integer>();
    }
    public void show()
    {
        System.out.println("input:" + input);
        System.out.println("output:" + output);
        System.out.println("output success:" + outputSuccess);
        writeToFiles();
    }
    //Don't worry about this next method. It just saves variables to files.
    public void writeToFiles()
    {
        clearMemoryFiles();
        try 
        {

            FileWriter inWriter = new FileWriter(fileInput);
            FileWriter outWriter = new FileWriter(fileOutput);
            FileWriter outSucWriter = new FileWriter(fileOutputSuccess);
            

            for (int i = 0; i < input.size(); i++)
            {
                inWriter.write(input.get(i)); 
                inWriter.write(System.lineSeparator());
                outWriter.write(output.get(i)+ ""); 
                outWriter.write(System.lineSeparator());
                outSucWriter.write(outputSuccess.get(i)+"");
                outSucWriter.write(System.lineSeparator());
            }
            inWriter.close();
            outWriter.close();
            outSucWriter.close();
        } 
        catch (java.io.IOException e)
        {
            System.out.println("Something strange went wrong with the save files");
        }
    }
    //Don't worry about this next method. It just loads variables from files
    public void loadMemoryFromFiles()
    {
        try
        {
             // a new scanner for each of the 4 save files
            Scanner inScan = new Scanner(fileInput);
            Scanner outScan = new Scanner(fileOutput);
            Scanner outSucScan = new Scanner(fileOutputSuccess);
            
            while(inScan.hasNextLine())
            {
                input.add(inScan.nextLine());
                try {
                    output.add(Integer.parseInt(outScan.nextLine()));
                    outputSuccess.add(Integer.parseInt(outSucScan.nextLine()));
                } catch (java.lang.NumberFormatException c)
                {
                    System.err.println("Problem: non-numerical charachter in brutusOutput.txt or brutusOutputSuccess.txt");
                }
            }
            
            inScan.close();
            outScan.close();
            outSucScan.close();
            cleanMemory();
        } catch (java.io.FileNotFoundException e)
        {
            System.out.println("Someone deleted the save files. They should be named:");
            System.out.println("brutusFailInput.txt, brutusFailOutput.txt, brutusWinOutput.txt, brutusWinInput.txt");
        }
    }
    //Empties learning text documents
    public static void clearMemoryFiles()
    {
        try 
        {
            FileWriter inWriter = new FileWriter(fileInput, false);
            FileWriter outWriter = new FileWriter(fileOutput, false);
            FileWriter outSucWriter = new FileWriter(fileOutputSuccess, false);
            
            inWriter.close();
            outWriter.close();
            outSucWriter.close();
        } 
        catch (java.io.IOException e)
        {
            System.out.println("Something strange went wrong with the save files");
        }
    }
    //In tic-tac-toe, a game is the same if you rotate or flip the board
    //This code allows the computer to rotate/flip boards in its mind to speed up learning
    //preconditions: two 9-digit boards are put in
    //postconditions: returns if the two boards are equal by rotating or flipping
    //THIS CODE IS CURRENTLY NOT BEING USED
    public boolean boardEquals(String bd, String input)
    {
        final int[][] EQUIVALENT_BOARDS = {{1,2,3,4,5,6,7,8,9},{7,4,1,8,5,2,9,6,3},{9,8,7,6,5,4,3,2,1},{3,6,9,2,5,8,1,4,7},{3,2,1,6,5,4,9,8,7},{9,6,3,8,5,2,7,4,1},{7,8,9,4,5,6,1,2,3},{1,4,7,2,5,8,3,6,9}};
        boolean all9Matched = true;
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (!bd.substring(EQUIVALENT_BOARDS[i][j] - 1, EQUIVALENT_BOARDS[i][j]).equals(input.substring(j, j+1)))
                {
                    all9Matched = false;
                    break;
                }
            }
            if (all9Matched)
            {
                currentBoard = EQUIVALENT_BOARDS[i];//remembers what angle it is looking at for future use
                                                    
                return true;
            } else {
                all9Matched = true;
            }
        }
        return false;
    }
    //WORK HERE (later)
    //This might not work 100%
    //it is supposed to make the memory lists shorter and remove duplicates
    public void cleanMemory()
    {
        int firstItemSuccess = -1;
        int lastItemSuccess = -1;
        Integer averageSuccess = -1;
        for (int i = 0; i < input.size();)//Notice no i++
        {

            if ((i != input.lastIndexOf(input.get(i))) && (output.get(i) == output.get(input.lastIndexOf(input.get(i)))))//WORK HERE
            {
                firstItemSuccess = outputSuccess.get(i);
                
                lastItemSuccess = outputSuccess.get(input.lastIndexOf(input.get(i)));
                averageSuccess = (int)Math.floor(((double)(firstItemSuccess) + lastItemSuccess) / 2);//rounds up
                
                //deletes the last information'
                System.out.println("removed" + input.get(i) + ", output: "+ output.get(input.lastIndexOf(input.get(i))) + "success: " + outputSuccess.get(input.lastIndexOf(input.get(i))));
                output.remove(input.lastIndexOf(input.get(i)));
                outputSuccess.remove(input.lastIndexOf(input.get(i)));
                input.remove(input.lastIndexOf(input.get(i)));
                
                //updates the first information to be an average of the first and last
                outputSuccess.set(i, averageSuccess);
                System.out.println("updated original to: " + averageSuccess);
            } else {
                i++;
            }
        }
        
    }
    //returns a random order of numbers 0-8
    public int[] getRandomOrder()
    {
        ArrayList<Integer> numbers = new ArrayList();
        numbers.add(0);numbers.add(1);numbers.add(2);numbers.add(3);numbers.add(4);numbers.add(5);numbers.add(6);numbers.add(7);numbers.add(8);
        int[] randomOrder = new int[9];
        int randomIndex = 0;
        for (int i = 0; i < 9; i++)
        {
            randomIndex = (int)(Math.random() * numbers.size());
            randomOrder[i] = numbers.get(randomIndex);
            numbers.remove(randomIndex);
        }
        return randomOrder;
    }
    public void addOpponentMoveToMemory(String board, int reaction)//A better way to do this would be to have a boolean isObserver for this Brutus
    //also, the "board" and "reaction" variable names are better than input/output
    //and should be used in the rest of the code as a replacement
    {
        //WORK HERE
        thisGameInput.add(board);
        thisGameOutput.add(reaction);
    }
    
}

