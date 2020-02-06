import java.lang.Math;
public class XsAI__Hero
{
    // //learning values
    // double clsx = 0.5;
    // double clso = 0.5;
    // double fin3 = 0.5;
    // double crnr = 0.5;
    // double sids = 0.5;
    // double midl = 0.5;
    // double stick = 0.5;
    // double carrot = 5.0;
    private Brutus brute;
    public XsAI__Hero(boolean isObserver)
    {
        //int q = 0;
        brute = new Brutus(isObserver);
    }
     public int xAIgo(String bd)
     {
         return brute.move(bd, true);
        // int x = 0;
        // String Open = "";
        // double s1 = 0.0; double s2 = 0.0; double s3 = 0.0;
        // double s4 = 0.0; double s5 = 0.0; double s6 = 0.0;
        // double s7 = 0.0; double s8 = 0.0; double s9 = 0.0;
        // for(int l = 8; l >= 0; l--)
        // {
            // if (!(bd.substring(l, l + 1).equals("x") || bd.substring(l, l + 1).equals("o")))
            // {
                // Open += l + 1;
            // }
        // }
        // for (int i = Open.length() - 1; i >= 0; i--)
        // {
            // String sub = Open.substring(i, i + 1);
            // int spot = bd.indexOf(sub);
            // double rotl = 0.0;
            // if (spot - 3 >= 0)
            // {
                // if (bd.substring(spot - 3).equals("o"))
                // {
                    // if (spot - 3 >= 0)
                    // {
                        // if (bd.substring(spot - 3).equals("o"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clso;
                // }
                // else if(bd.substring(spot - 3).equals("x"))
                // {
                    // if (spot - 3 >= 0)
                    // {
                        // if(bd.substring(spot - 3).equals("x"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clsx;
                // }
            // }
            // if (spot + 3 <= 8)
            // {
                // if (bd.substring(spot + 3).equals("o"))
                // {
                    // if (spot + 3 <= 8)
                    // {
                        // if (bd.substring(spot + 3).equals("o"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clso;
                // }
                // else if(bd.substring(spot + 3).equals("x"))
                // {
                    // if (spot + 3 <= 8)
                    // {
                        // if(bd.substring(spot + 3).equals("x"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clsx;
                // }
            // }
            // if (!(spot - 1 == -1 || spot - 1 == 2 || spot - 1 == 5))
            // {
                // if (bd.substring(spot - 1).equals("o"))
                // {
                    // if (!(spot - 1 == -1 || spot - 1 == 2 || spot - 1 == 5))
                    // {
                        // if (bd.substring(spot - 1).equals("o"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clso;
                // }
                // else if(bd.substring(spot - 1).equals("x"))
                // {
                    // if (!(spot - 1 == -1 || spot - 1 == 2 || spot - 1 == 5))
                    // {
                        // if(bd.substring(spot - 1).equals("x"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clsx;
                // }
            // }
            // if (!(spot + 1 == 3 || spot + 1 == 6 || spot + 1 == 9))
            // {
                // if (bd.substring(spot + 1).equals("o"))
                // {
                    // if (!(spot + 1 == 3 || spot + 1 == 6 || spot + 1 == 9))
                    // {
                        // if (bd.substring(spot + 1).equals("o"))
                        // {
                           // rotl += fin3;
                        // }
                    // }
                    // rotl += clso;
                // }
                // else if(bd.substring(spot + 1).equals("x"))
                // {
                    // if (!(spot + 1 == 3 || spot + 1 == 6 || spot + 1 == 9))
                    // {
                        // if(bd.substring(spot  + 1).equals("x"))
                        // {
                            // rotl += fin3;
                        // }
                    // }
                    // rotl += clsx;
                // }
            // }
            // if (spot != 0 && spot != 2 && spot != 6 && spot != 8)
            // {
                // if (spot - 3 >= 0 && spot + 3 <= 8)
                // {
                    // if (bd.substring(spot - 3).equals("o") && bd.substring(spot + 3).equals("o"))
                    // {
                        // rotl += fin3;
                    // }
                    // else if (bd.substring(spot - 3).equals("x") && bd.substring(spot + 3).equals("x"))
                    // {
                        // rotl += fin3;
                    // }
                // }
                // if ((!(spot - 1 == -1 || spot - 1 == 2 || spot - 1 == 5)) && (!(spot + 1 == 3 || spot + 1 == 6 || spot + 1 == 9)))
                // {
                    // if (bd.substring(spot - 1).equals("o") && bd.substring(spot + 1).equals("o"))
                    // {
                        // rotl += fin3;
                    // }
                    // else if (bd.substring(spot - 1).equals("x") && bd.substring(spot + 1).equals("x"))
                    // {
                        // rotl += fin3;
                    // }
                // }
            // }
            // if (spot == 4)
            // {
                // rotl += midl;
            // }
            // else if (spot == 1 || spot == 3 || spot == 5 || spot == 7)
            // {
                // rotl += sids;
            // }
            // else
            // {
                // rotl += crnr;
            // }
            // if (spot == 0)
            // {
                // s1 = rotl;
            // }
            // else if(spot == 1)
            // {
                // s2 = rotl;
            // }
            // else if(spot == 2)
            // {
                // s3 = rotl;
            // }
            // else if(spot == 3)
            // {
                // s4 = rotl;
            // }
            // else if(spot == 4)
            // {
                // s5 = rotl;
            // }
            // else if(spot == 5)
            // {
                // s6 = rotl;
            // }
            // else if(spot == 6)
            // {
                // s7 = rotl;
            // }
            // else if(spot == 7)
            // {
                // s8 = rotl;
            // }
            // else
            // {
                // s9 = rotl;
            // }
        // }
        // if (Open.indexOf("1") >= 0 && s1 > s2 && s1 > s3 && s1 > s4 && s1 > s5 && s1 > s6 && s1 > s7 && s1 > s8 && s1 > s9)
        // {
            // return 1;
        // }
        // else if (Open.indexOf("2") >= 0 && s2 >= s1 && s2 > s3 && s2 > s4 && s2 > s5 && s2 > s6 && s2 > s7 && s2 > s8 && s2 > s9)
        // {
            // return 2;
        // }
        // else if (Open.indexOf("3") >= 0 && s3 >= s2 && s3 >= s1 && s3 > s4 && s3 > s5 && s3 > s6 && s3 > s7 && s3 > s8 && s3 > s9)
        // {
            // return 3;
        // }
        // else if (Open.indexOf("4") >= 0 && s4 >= s2 && s4 >= s3 && s4 >= s1 && s4 > s5 && s4 > s6 && s4 > s7 && s4 > s8 && s4 > s9)
        // {
            // return 4;
        // }
        // else if (Open.indexOf("5") >= 0 && s5 >= s2 && s5 >= s3 && s5 >= s4 && s5 >= s1 && s5 > s6 && s5 > s7 && s5 > s8 && s5 > s9)
        // {
            // return 5;
        // }
        // else if (Open.indexOf("6") >= 0 && s6 >= s2 && s6 >= s3 && s6 >= s4 && s6 >= s5 && s6 >= s1 && s6 > s7 && s6 > s8 && s6 > s9)
        // {
            // return 6;
        // }
        // else if (Open.indexOf("7") >= 0 && s7 >= s2 && s7 >= s3 && s7 >= s4 && s7 >= s5 && s7 >= s6 && s7 >= s1 && s7 > s8 && s7 > s9)
        // {
            // return 7;
        // }
        // else if (Open.indexOf("8") >= 0 && s8 >= s2 && s8 >= s3 && s8 >= s4 && s8 >= s5 && s8 >= s6 && s8 >= s7 && s8 >= s1 && s8 > s9)
        // {
            // return 8;
        // }
        // else if (Open.indexOf("9") >= 0 && s9 >= s2 && s9 >= s3 && s9 >= s4 && s9 >= s5 && s9 >= s6 && s9 >= s7 && s9 >= s8 && s9 >= s1)
        // {
            // return 9;
        // }
        // else
        // {
            // int len = Open.length();
            // int rand = (int) (Math.random() * len);
            // if (Open.substring(rand, rand + 1).equals("1"))
            // {
                // return 1;
            // }
            // else if (Open.substring(rand, rand + 1).equals("2"))
            // {
                // return 2;
            // }
            // else if (Open.substring(rand, rand + 1).equals("3"))
            // {
                // return 3;
            // }
            // else if (Open.substring(rand, rand + 1).equals("4"))
            // {
                // return 4;
            // }
            // else if (Open.substring(rand, rand + 1).equals("5"))
            // {
                // return 5;
            // }
            // else if (Open.substring(rand, rand + 1).equals("6"))
            // {
                // return 6;
            // }
            // else if (Open.substring(rand, rand + 1).equals("7"))
            // {
                // return 7;
            // }
            // else if (Open.substring(rand, rand + 1).equals("8"))
            // {
                // return 8;
            // }
            // else
            // {
                // return 9;
            // }
         //}
    }
    public void XStick(int result)
    {
        brute.learn(result);
        // double t = clsx + clso + fin3 + crnr + sids + midl;
        // double a = t / 6.0;
        // if (clsx >= a)
        // {
            // double rand = Math.random();
            // clsx -= (rand * stick);
        // }
        // if (clso >= a)
        // {
            // double rand = Math.random();
            // clso -= (rand * stick);
        // }
        // if (fin3 >= a)
        // {
            // double rand = Math.random();
            // fin3 -= (rand * stick);
        // }
        // if (crnr >= a)
        // {
            // double rand = Math.random();
            // crnr -= (rand * stick);
        // }
        // if (sids >= a)
        // {
            // double rand = Math.random();
            // sids -= (rand * stick);
        // }
        // if (midl >= a)
        // {
            // double rand = Math.random();
            // midl -= (rand * stick);
        // }
    }
    public void XCarrot(int result)
    {
        brute.learn(result);
        // double t = clsx + clso + fin3 + crnr + sids + midl;
        // double a = t / 6.0;
        // if (clsx >= a)
        // {
            // double rand = Math.random();
            // clsx += (rand * carrot);
        // }
        // if (clso >= a)
        // {
            // double rand = Math.random();
            // clso += (rand * carrot);
        // }
        // if (fin3 >= a)
        // {
            // double rand = Math.random();
            // fin3 += (rand * carrot);
        // }
        // if (crnr >= a)
        // {
            // double rand = Math.random();
            // crnr += (rand * carrot);
        // }
        // if (sids >= a)
        // {
            // double rand = Math.random();
            // sids += (rand * carrot);
        // }
        // if (midl >= a)
        // {
            // double rand = Math.random();
            // midl += (rand * carrot);
        // }
    }
    public void ShowToggles()
    {
        brute.show();
        //System.out.println("Hero:\nclsx: " + clsx + "\nclso: " + clso + "\nfin3: " + fin3 +
        //                   "\ncrnr: " + crnr + "\nsids: " + sids + "\nmidl: " + midl);
    }
    public void observe(String board, int move)
    {
        brute.observe(board, move);
    }
    
}