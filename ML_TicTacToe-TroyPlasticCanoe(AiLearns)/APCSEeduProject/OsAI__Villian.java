import java.lang.Math;
public class OsAI__Villian{
    //learning values
    private double[] brain = new double[5];
    /*close to x
      close to o
      corner
      sides
      middle*/
    private double stick;
    private double carrot;
    /**
     * General Constructer
     * Sets the values for brain that control where the AI plays
     * Sets values for learning
     * Basically gives values for the above vareables
     */
    public OsAI__Villian(){
        for (int i = 0; i < 5; i++){brain[i] = Math.random();}
        stick = 0.5;
        carrot = 1.0;
    }
    /**
     * Spesific Constructor
     * Allows exact control over the vareables above
     * uses inputs so you can manualy maintain a tic tac toe value set
     */
    public OsAI__Villian(double x, double o, double c, double s, double m, double t, double r){
        brain[0] = x;
        brain[1] = 0;
        brain[2] = c;
        brain[3] = s;
        brain[4] = m;
        stick = t;
        carrot = r;
    }
    /**
     * Make an o move
     * @param bd is the board the ai moves on
     * @return an integer for which space to place an o in
     */
    public int oAIgo(String bd){
        boolean[] open = {true, true, true, 
                          true, true, true, 
                          true, true, true};
        double[] s = {0.0, 0.0, 0.0, 
                      0.0, 0.0, 0.0, 
                      0.0, 0.0, 0.0};
        for(int i = 0; i < 9; i++){
            if (bd.substring(i, i + 1).equals("x") || bd.substring(i, i + 1).equals("o")){
                open[i] = false;
            }
        }
        //if it is a winning space
        if (open[0] && (bd.substring(1, 3).equals("oo") ||
                       (bd.substring(3, 4) + bd.substring(6, 7)).equals("oo")||
                       (bd.substring(4, 5) + bd.substring(8, 9)).equals("oo"))){return 1;}
        if (open[1] && ((bd.substring(0, 1) + bd.substring(2, 3)).equals("oo") ||
                        (bd.substring(4, 5) + bd.substring(7, 8)).equals("oo"))){return 2;}
        if (open[2] && (bd.substring(0, 2).equals("oo") ||
                       (bd.substring(5, 6) + bd.substring(8, 9)).equals("oo")||
                       (bd.substring(4, 5) + bd.substring(6, 7)).equals("oo"))){return 3;}
        if (open[3] && (bd.substring(4, 6).equals("oo") ||
                       (bd.substring(0, 1) + bd.substring(6, 7)).equals("oo"))){return 4;}
        if (open[4] && ((bd.substring(3, 4) + bd.substring(5, 6)).equals("oo")||
                        (bd.substring(1, 2) + bd.substring(7, 8)).equals("oo")||
                        (bd.substring(0, 1) + bd.substring(8, 9)).equals("oo")||
                        (bd.substring(2, 3) + bd.substring(6, 7)).equals("oo"))){return 5;}
        if (open[5] && (bd.substring(3, 5).equals("oo") ||
                       (bd.substring(2, 3) + bd.substring(8, 9)).equals("oo"))){return 6;}
        if (open[6] && (bd.substring(7, 9).equals("oo") ||
                       (bd.substring(0, 1) + bd.substring(3, 4)).equals("oo")||
                       (bd.substring(2, 3) + bd.substring(4, 5)).equals("oo"))){return 7;}
        if (open[7] && ((bd.substring(6, 7) + bd.substring(8, 9)).equals("oo") ||
                        (bd.substring(1, 2) + bd.substring(4, 5)).equals("oo"))){return 8;}
        if (open[8] && (bd.substring(6, 8).equals("oo") ||
                       (bd.substring(2, 3) + bd.substring(5, 6)).equals("oo")||
                       (bd.substring(0, 1) + bd.substring(4, 5)).equals("oo"))){return 9;}
        //if it blocks a winning space
        if (open[0] && (bd.substring(1, 3).equals("xx") ||
                       (bd.substring(3, 4) + bd.substring(6, 7)).equals("xx")||
                       (bd.substring(4, 5) + bd.substring(8, 9)).equals("xx"))){return 1;}
        if (open[1] && ((bd.substring(0, 1) + bd.substring(2, 3)).equals("xx") ||
                        (bd.substring(4, 5) + bd.substring(7, 8)).equals("xx"))){return 2;}
        if (open[2] && (bd.substring(0, 2).equals("xx") ||
                       (bd.substring(5, 6) + bd.substring(8, 9)).equals("xx")||
                       (bd.substring(4, 5) + bd.substring(6, 7)).equals("xx"))){return 3;}
        if (open[3] && (bd.substring(4, 6).equals("xx") ||
                       (bd.substring(0, 1) + bd.substring(6, 7)).equals("xx"))){return 4;}
        if (open[4] && ((bd.substring(3, 4) + bd.substring(5, 6)).equals("xx")||
                        (bd.substring(1, 2) + bd.substring(7, 8)).equals("xx")||
                        (bd.substring(0, 1) + bd.substring(8, 9)).equals("xx")||
                        (bd.substring(2, 3) + bd.substring(6, 7)).equals("xx"))){return 5;}
        if (open[5] && (bd.substring(3, 5).equals("xx") ||
                       (bd.substring(2, 3) + bd.substring(8, 9)).equals("xx"))){return 6;}
        if (open[6] && (bd.substring(7, 9).equals("xx") ||
                       (bd.substring(0, 1) + bd.substring(3, 4)).equals("xx")||
                       (bd.substring(2, 3) + bd.substring(4, 5)).equals("xx"))){return 7;}
        if (open[7] && ((bd.substring(6, 7) + bd.substring(8, 9)).equals("xx") ||
                        (bd.substring(1, 2) + bd.substring(4, 5)).equals("xx"))){return 8;}
        if (open[8] && (bd.substring(6, 8).equals("xx") ||
                       (bd.substring(2, 3) + bd.substring(5, 6)).equals("xx")||
                       (bd.substring(0, 1) + bd.substring(4, 5)).equals("xx"))){return 9;}
        //then use 5 brain cells and rotl
        int index = 0;
        for(boolean o: open){
            if (o){
                double rotl = 0.0;
                /*if close to x add for xs
                 *if close to o add for os
                 *if on corner side or middle add for that*/
                switch (index){//no need for close x middle because they all benefit from it
                     case 0:
                     if (bd.substring(1, 2).equals("x")){rotl += brain[0];}
                     if (bd.substring(3, 4).equals("x")){rotl += brain[0];}
                     break; 
                     case 1:
                     if (bd.substring(0, 1).equals("x")){rotl += brain[0];}
                     if (bd.substring(2, 3).equals("x")){rotl += brain[0];}
                     break; 
                     case 2:
                     if (bd.substring(1, 2).equals("x")){rotl += brain[0];}
                     if (bd.substring(5, 6).equals("x")){rotl += brain[0];}
                     break; 
                     case 3:
                     if (bd.substring(0, 1).equals("x")){rotl += brain[0];}
                     if (bd.substring(6, 7).equals("x")){rotl += brain[0];}
                     break;
                     case 4:
                     if (bd.substring(0, 1).equals("x")){rotl += brain[0];}
                     if (bd.substring(1, 2).equals("x")){rotl += brain[0];}
                     if (bd.substring(2, 3).equals("x")){rotl += brain[0];}
                     if (bd.substring(3, 4).equals("x")){rotl += brain[0];}
                     if (bd.substring(5, 6).equals("x")){rotl += brain[0];}
                     if (bd.substring(6, 7).equals("x")){rotl += brain[0];}
                     if (bd.substring(7, 8).equals("x")){rotl += brain[0];}
                     if (bd.substring(8, 9).equals("x")){rotl += brain[0];}
                     break; 
                     case 5:
                     if (bd.substring(2, 3).equals("x")){rotl += brain[0];}
                     if (bd.substring(8, 9).equals("x")){rotl += brain[0];}
                     break; 
                     case 6:
                     if (bd.substring(7, 8).equals("x")){rotl += brain[0];}
                     if (bd.substring(3, 4).equals("x")){rotl += brain[0];}
                     break; 
                     case 7:
                     if (bd.substring(8, 9).equals("x")){rotl += brain[0];}
                     if (bd.substring(6, 7).equals("x")){rotl += brain[0];}
                     break;
                     case 8:
                     if (bd.substring(5, 6).equals("x")){rotl += brain[0];}
                     if (bd.substring(7, 8).equals("x")){rotl += brain[0];}
                     break;
                }
                switch (index){//no need for close o middle because they all benefit from it
                     case 0:
                     if (bd.substring(1, 2).equals("o")){rotl += brain[1];}
                     if (bd.substring(3, 4).equals("o")){rotl += brain[1];}
                     break; 
                     case 1:
                     if (bd.substring(0, 1).equals("o")){rotl += brain[1];}
                     if (bd.substring(2, 3).equals("o")){rotl += brain[1];}
                     break; 
                     case 2:
                     if (bd.substring(1, 2).equals("o")){rotl += brain[1];}
                     if (bd.substring(5, 6).equals("o")){rotl += brain[1];}
                     break; 
                     case 3:
                     if (bd.substring(0, 1).equals("o")){rotl += brain[1];}
                     if (bd.substring(6, 7).equals("o")){rotl += brain[1];}
                     break;
                     case 4:
                     if (bd.substring(0, 1).equals("o")){rotl += brain[1];}
                     if (bd.substring(1, 2).equals("o")){rotl += brain[1];}
                     if (bd.substring(2, 3).equals("o")){rotl += brain[1];}
                     if (bd.substring(3, 4).equals("o")){rotl += brain[1];}
                     if (bd.substring(5, 6).equals("o")){rotl += brain[1];}
                     if (bd.substring(6, 7).equals("o")){rotl += brain[1];}
                     if (bd.substring(7, 8).equals("o")){rotl += brain[1];}
                     if (bd.substring(8, 9).equals("o")){rotl += brain[1];}
                     break; 
                     case 5:
                     if (bd.substring(2, 3).equals("o")){rotl += brain[1];}
                     if (bd.substring(8, 9).equals("o")){rotl += brain[1];}
                     break; 
                     case 6:
                     if (bd.substring(7, 8).equals("o")){rotl += brain[1];}
                     if (bd.substring(3, 4).equals("o")){rotl += brain[1];}
                     break; 
                     case 7:
                     if (bd.substring(8, 9).equals("o")){rotl += brain[1];}
                     if (bd.substring(6, 7).equals("o")){rotl += brain[1];}
                     break;
                     case 8:
                     if (bd.substring(5, 6).equals("o")){rotl += brain[1];}
                     if (bd.substring(7, 8).equals("o")){rotl += brain[1];}
                     break;
                }
                if (open[index]){
                    switch (index){
                         case 0: case 2: case 6: case 8:
                         rotl += brain[2];
                         break;
                         case 1: case 3: case 5: case 7:
                         rotl += brain[3];
                         break;
                         case 4:
                         rotl += brain[4];
                         break;
                    }
                    s[index] = rotl;
                }
            }
            index++;
        }
        //label the s value index of the biggest prefering to play l-r, t-b
        int inwin = 0;
        for (int j = 1; j < 9; j++){
            double spot = s[j];
            if (spot > s[inwin] && open[j]){inwin = j;}
        }
        return inwin + 1;
    }
    public void OStick(){
        int[] bRank = this.rankBrain();
        brain[bRank[0]] -= stick;
        brain[bRank[1]] -= stick / 2;
        brain[bRank[3]] += stick / 2;
        brain[bRank[4]] += stick;
    }
    public void OCarrot(){
        int[] bRank = this.rankBrain();
        brain[bRank[0]] += carrot;
        brain[bRank[1]] += carrot / 2;
        brain[bRank[3]] -= carrot / 2;
        brain[bRank[4]] -= carrot;
    }
    public int[] rankBrain(){
        int[] out = {0, 1, 2, 3, 4};
        for (int j : out){
            int top = j;
            for (int i = j + 1; i < 5; i++){
                if (brain[top] < brain[i]){top = i;}
            }
            j = top;
        }
        return out;
    }
    public String toString(){
        return("Villian:\nclsx: " + brain[0] + "\nclso: " + brain[1] +
               "\ncrnr: " + brain[2] + "\nsids: " + brain[3] + "\nmidl: " + brain[4]);
    }
}