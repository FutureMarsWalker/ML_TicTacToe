import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
public class GameRunner
{
    public static void main()
    {

        Game board = new Game();
        OsAI__Villian villian = new OsAI__Villian();//Villain always plays o
        XsAI__Hero hero = new XsAI__Hero();//Hero always plays x
        System.out.println("Choose (enter a number 1-4): ");
        System.out.println("1: Play as x against AI");
        System.out.println("2: Play as o against AI");
        System.out.println("3: Watch the AIs play each other");
        System.out.println("4: Play with a friend");
        boolean OsAI;
        boolean XsAI;
        switch (getInt(4, 1)){ //safely gets an integer input and responds appropriately
            case 1:
            OsAI = true;
            XsAI = false;
            break;
            case 2:
            OsAI = false;
            XsAI = true;
            break;
            case 3:
            OsAI = true;
            XsAI = true;
            break;
            case 4:
            OsAI = false;
            XsAI = false;
            break;
            default:
            System.out.println("Something went terribly wrong");
            OsAI = false;
            XsAI = false;
            break;
        }
        
        int Xwins = 0;
        int Owins = 0;
        System.out.println("");
        System.out.println("Here's the deal: this game has graphics, but they aren't that good yet.");
        System.out.println("Enter your input into this window that you see right now.");
        System.out.println("When the graphics window pops up, drag this window to a place"); 
        System.out.println("where you can see them both");
        System.out.println("");
        System.out.print("Enter the number of games you want to play(0 to 10,000): ");
        int runs = getInt(1000, 0);
        System.out.println("");
        
        for (int r = runs; r > 0; r--)
        {
            String bd = board.theBoard();
            int turn = 0;
            while (true)//infinite loop, uses break to escape
            {
                //check if anybody won or tied
                if(bd.substring(0, 3).equals("xxx") ||
                   bd.substring(3, 6).equals("xxx") ||
                   bd.substring(6, 9).equals("xxx") ||
                   (bd.substring(0, 1) + bd.substring(3, 4) + bd.substring(6, 7)).equals("xxx") ||
                   (bd.substring(1, 2) + bd.substring(4, 5) + bd.substring(7, 8)).equals("xxx") ||
                   (bd.substring(2, 3) + bd.substring(5, 6) + bd.substring(8, 9)).equals("xxx") ||
                   (bd.substring(0, 1) + bd.substring(4, 5) + bd.substring(8, 9)).equals("xxx") ||
                   (bd.substring(2, 3) + bd.substring(4, 5) + bd.substring(6, 7)).equals("xxx"))
                {
                    System.out.println("Crosses win!");
                    villian.OStick();
                    hero.XCarrot();
                    Xwins++;
                    break;
                }
                else if (bd.substring(0, 3).equals("ooo") ||
                   bd.substring(3, 6).equals("ooo") ||
                   bd.substring(6, 9).equals("ooo") ||
                  (bd.substring(0, 1) + bd.substring(3, 4) + bd.substring(6, 7)).equals("ooo") ||
                  (bd.substring(1, 2) + bd.substring(4, 5) + bd.substring(7, 8)).equals("ooo") ||
                  (bd.substring(2, 3) + bd.substring(5, 6) + bd.substring(8, 9)).equals("ooo") ||
                  (bd.substring(0, 1) + bd.substring(4, 5) + bd.substring(8, 9)).equals("ooo") ||
                  (bd.substring(2, 3) + bd.substring(4, 5) + bd.substring(6, 7)).equals("ooo"))
                {
                    System.out.println("Nots win!");
                    villian.OCarrot();
                    hero.XStick();
                    Owins++;
                    break;
                }
                else if (!(bd.substring(0, 1).equals("1") || bd.substring(1, 2).equals("2") ||
                           bd.substring(2, 3).equals("3") || bd.substring(3, 4).equals("4") ||
                           bd.substring(4, 5).equals("5") || bd.substring(5, 6).equals("6") ||
                           bd.substring(6, 7).equals("7") || bd.substring(7, 8).equals("8") ||
                           bd.substring(8, 9).equals("9")))
                {
                    System.out.println("Tie.");
                    break;
                }
                else//if nobody won yet
                {
                    if (turn % 2 == 0)//if it's my turn
                    {
                        if (XsAI)//If AI x is on, use AI
                        {
                            int x = hero.xAIgo(bd);
                            bd = board.xPlays(bd, x);
                            turn++;
                        }
                        else//Otherwise use human input
                        {
                            System.out.println("Crosses Turn:");
                            board.printGame(bd);
                            System.out.print("Enter the space you wish to play on: ");
                            int x = 0;
                            //get a number and be sure not to "write on top of" another
                            while (x == 0 || bd.substring(x - 1, x).equals("x") || bd.substring(x - 1, x).equals("o"))
                            {
                                x = getInt(9, 1);
                            }
                            bd = board.xPlays(bd, x);
                            turn++;
                        }
                    }
                    else
                    {
                        if (OsAI)//If o AI is on, use it
                        {
                            int x = villian.oAIgo(bd);
                            bd = board.oPlays(bd, x);
                            turn++;
                        }
                        else//Otherwise use human input
                        {
                            System.out.println("Nots Turn:");
                            board.printGame(bd);
                            System.out.print("Enter the space you wish to play on: ");
                            int x = 0;
                            //get a number and be sure not to "write on top of" another
                            while (x == 0 || bd.substring(x - 1, x).equals("x") || bd.substring(x - 1, x).equals("o"))
                            {
                                x = getInt(9, 1);
                            }
                            bd = board.oPlays(bd, x);
                            turn++;
                        }
                    }       
                }
            }
            board.printGame(bd);
            System.out.println(runs - r + 1);
        }
        if (OsAI) {
            villian.ShowToggles();
        }
        System.out.println("Wins: " + Owins);
        if (XsAI) {
            hero.ShowToggles();
        }
        System.out.println("Wins: " + Xwins);
    }
    public static int getInt(int max, int min) 
    {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        try { //This makes sure the user gives a valid input.
            n = scan.nextInt();
            System.out.println(n);
            if (n <= max && n >= min) {
            scan.close();
            return n;
            } else {
                System.out.println("Invalid input.");
                System.out.println("");
                scan.close();
                return getInt(max, min);
            }
        } catch (java.util.InputMismatchException e) 
        {
            System.out.println("Invalid input.");
            System.out.println("");
            scan.close();
            return getInt(max, min);
        }
        
    }
    
}
