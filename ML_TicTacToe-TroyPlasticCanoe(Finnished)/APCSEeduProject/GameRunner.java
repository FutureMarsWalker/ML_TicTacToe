import java.util.Scanner;
public class GameRunner
{
    public static void main()
    {
        Scanner in = new Scanner(System.in);
        OsAI__Villian villian = new OsAI__Villian();//Villain always plays o
        //XsAI__Hero hero = new XsAI__Hero();//Hero always plays x
        System.out.println("Choose (enter a number 1-4): ");
        System.out.println("1: Play as x against random AI");
        System.out.println("2: Play as x against custom AI");
        System.out.println("3: Play with a friend");
        System.out.println("4: Broken but it will train an opponent");
        boolean OsAI = false;
        boolean XsAI = false;
        switch (getInt(4, 1))
        { //safely gets an integer input and responds appropriately
            case 1:
            OsAI = true;
            villian = new OsAI__Villian();//Villain always plays o
            break;
            case 2:
            OsAI = true;
            double x; double o; double c; double s; double m; double t; double r;
            System.out.println("Enter the close to x value");
            x = in.nextDouble();
            System.out.println("Enter the close to o value");
            o = in.nextDouble();
            System.out.println("Enter the corner preferance value");
            c = in.nextDouble();
            System.out.println("Enter the side preferance value");
            s = in.nextDouble();
            System.out.println("Enter the middle preferance value");
            m = in.nextDouble();
            System.out.println("Enter the punishment value");
            t = in.nextDouble();
            System.out.println("Enter the reward value");
            r = in.nextDouble();
            villian = new OsAI__Villian(x, o, c, s, m, t, r);
            break;
            case 3:
            OsAI = false;
            break;
            case 4:
            OsAI = true;
            XsAI = false; // make true to facilitate the dev training
            break;
        }
        int Xwins = 0;
        int Owins = 0;
        System.out.print("Enter the number of games you want to play(0 to 100): ");
        int runs = getInt(100, 0);
        System.out.println("");
        for (int r = runs; r > 0; r--)//main game loop
        {
            String bd = "123456789";
            int turn = 0;
            while (true)//turn loop
            {
                //check if anybody won
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
                    //hero.XCarrot();
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
                    //hero.XStick();
                    Owins++;
                    break;
                }//was it a tie
                else if (!(bd.substring(0, 1).equals("1") || bd.substring(1, 2).equals("2") ||
                           bd.substring(2, 3).equals("3") || bd.substring(3, 4).equals("4") ||
                           bd.substring(4, 5).equals("5") || bd.substring(5, 6).equals("6") ||
                           bd.substring(6, 7).equals("7") || bd.substring(7, 8).equals("8") ||
                           bd.substring(8, 9).equals("9")))
                {
                    System.out.println("Tie.");
                    break;
                }
                else//let turns be played
                {
                    if (turn % 2 == 0)//xs get a turn
                    {
                        if (XsAI)
                        {
                            /*int x = hero.xAIgo(bd);
                            bd = xPlays(bd, x);
                            turn++;*/
                        }
                        else
                        {
                            System.out.println("Crosses Turn:");
                            printGame(bd);
                            System.out.print("Enter the space you wish to play on: ");
                            int x = 0;
                            //get a number and be sure not to "write on top of" another
                            while (x == 0 || bd.substring(x - 1, x).equals("x") || bd.substring(x - 1, x).equals("o"))
                            {
                                x = getInt(9, 1);
                            }
                            bd = xPlays(bd, x);
                            turn++;
                        }
                    }
                    else//os get a turn
                    {
                        if (OsAI)
                        {
                            int x = villian.oAIgo(bd);
                            bd = oPlays(bd, x);
                            turn++;
                        }
                        else
                        {
                            System.out.println("Nots Turn:");
                            printGame(bd);
                            System.out.print("Enter the space you wish to play on: ");
                            int x = 0;
                            //get a number and be sure not to "write on top of" another
                            while (x == 0 || bd.substring(x - 1, x).equals("x") || bd.substring(x - 1, x).equals("o"))
                            {
                                x = getInt(9, 1);
                            }
                            bd = oPlays(bd, x);
                            turn++;
                        }
                    }       
                }
            }
            printGame(bd);
            System.out.println(runs - r + 1);
        }
        System.out.println("OWins: " + Owins);
        if (OsAI)
        {
            System.out.println(villian);
        }
        System.out.println("XWins: " + Xwins);
    }
    /**
     * up dates board for x
     */
    public static String xPlays(String b, int x)
    {
        b = b.substring(0, x - 1) + "x" + b.substring(x);
        return b;
    }
    /**
     * up dates board for o
     */
    public static String oPlays(String b, int x)
    {
        b = b.substring(0, x - 1) + "o" + b.substring(x);
        return b;
    }
    /**
     * prints the board
     */
    public static void printGame(String b)
    {
        System.out.println("[" + b.substring(0,1) + "][" + b.substring(1,2) + "][" + b.substring(2,3) + "]");
        System.out.println("[" + b.substring(3,4) + "][" + b.substring(4,5) + "][" + b.substring(5,6) + "]");
        System.out.println("[" + b.substring(6,7) + "][" + b.substring(7,8) + "][" + b.substring(8,9) + "]");
    }
    /**
     * Garuntees a valid number
     */
    public static int getInt(int max, int min)
    {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        try 
        { //This makes sure the user gives a valid input.
            n = scan.nextInt();
            System.out.println(n);
            if (n <= max && n >= min) 
            {
                scan.close();
                return n;
            } 
            else 
            {
                System.out.println("Invalid input.");
                System.out.println("");
                scan.close();
                return getInt(max, min);
            }
        } 
        catch (java.util.InputMismatchException e)
        {
            System.out.println("Invalid input.");
            System.out.println("");
            scan.close();
            return getInt(max, min);
        }
    }
}