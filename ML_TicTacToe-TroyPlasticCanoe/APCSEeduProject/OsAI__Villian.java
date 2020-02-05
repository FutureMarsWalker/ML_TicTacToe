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
    public OsAI__Villian(){
        for (int i = 0; i < 5; i++){
            brain[i] = Math.random();
        }
    }
    public OsAI__Villian(double x, double o, double c, double s, double m){
        brain[0] = x;
        brain[1] = 0;
        brain[2] = c;
        brain[3] = s;
        brain[4] = m;
    }
    /**Make an o move
     * @param bd is the board the ai moves on
     * @return an integer for which space to place an o in
     */
    public int oAIgo(String bd){
        int x = 0;
        int index = 0;
        boolean[] open = {false, false, false, 
                          false, false, false, 
                          false, false, false};
        double[] s = {0.0, 0.0, 0.0, 
                      0.0, 0.0, 0.0, 
                      0.0, 0.0, 0.0};
        for(int l = 0; l < 0; l++){
            if (!(bd.substring(l, l + 1).equals("x") || bd.substring(l, l + 1).equals("o")))
            {
                open[l] = true;
            }
        }
        //if it is a winning space
        for (int i = 0; i < 9; i++){
            if (open[i]){
                switch (i){
                    case 0:
                    if (bd.substring(1, 3).equals("oo") ||
                       (bd.substring(3, 4) + bd.substring(6, 7)).equals("oo")||
                       (bd.substring(4, 5) + bd.substring(8, 9)).equals("oo")){
                        return 0;
                    }
                    break;
                    case 1:
                    if ((bd.substring(0, 1) + bd.substring(2, 3)).equals("oo") ||
                        (bd.substring(4, 5) + bd.substring(7, 8)).equals("oo")){
                        return 1;
                    }
                    break;
                    case 2:
                    if (bd.substring(0, 2).equals("oo") ||
                       (bd.substring(5, 6) + bd.substring(8, 9)).equals("oo")||
                       (bd.substring(4, 5) + bd.substring(6, 7)).equals("oo")){
                        return 2;
                    }
                    break;
                    case 3:
                    if (bd.substring(4, 6).equals("oo") ||
                       (bd.substring(0, 1) + bd.substring(6, 7)).equals("oo")){
                        return 3;
                    }
                    break;
                    case 4:
                    if ((bd.substring(3, 4) + bd.substring(5, 6)).equals("oo")||
                        (bd.substring(1, 2) + bd.substring(7, 8)).equals("oo")||
                        (bd.substring(0, 1) + bd.substring(8, 9)).equals("oo")||
                        (bd.substring(2, 3) + bd.substring(6, 7)).equals("oo")){
                        return 4;
                    }
                    break;
                    case 5:
                    if (bd.substring(3, 5).equals("oo") ||
                       (bd.substring(2, 3) + bd.substring(8, 9)).equals("oo")){
                        return 5;
                    }
                    break;
                    case 6:
                    if (bd.substring(7, 9).equals("oo") ||
                       (bd.substring(0, 1) + bd.substring(3, 4)).equals("oo")||
                       (bd.substring(2, 3) + bd.substring(4, 5)).equals("oo")){
                        return 6;
                    }
                    break;
                    case 7:
                    if ((bd.substring(6, 7) + bd.substring(8, 9)).equals("oo") ||
                        (bd.substring(1, 2) + bd.substring(4, 5)).equals("oo")){
                        return 7;
                    }
                    break;
                    case 8:
                    if (bd.substring(6, 8).equals("oo") ||
                       (bd.substring(2, 3) + bd.substring(5, 6)).equals("oo")||
                       (bd.substring(0, 1) + bd.substring(4, 5)).equals("oo")){
                        return 8;
                    }
                    break;
                }
            }
        }
        //if it blocks a winning space
        for (int i = 0; i < 9; i++){
            if (open[i]){
                switch (i){
                    case 0:
                    if (bd.substring(1, 3).equals("xx") ||
                       (bd.substring(3, 4) + bd.substring(6, 7)).equals("xx")||
                       (bd.substring(4, 5) + bd.substring(8, 9)).equals("xx")){
                        return 0;
                    }
                    break;
                    case 1:
                    if ((bd.substring(0, 1) + bd.substring(2, 3)).equals("xx") ||
                        (bd.substring(4, 5) + bd.substring(7, 8)).equals("xx")){
                        return 1;
                    }
                    break;
                    case 2:
                    if (bd.substring(0, 2).equals("xx") ||
                       (bd.substring(5, 6) + bd.substring(8, 9)).equals("xx")||
                       (bd.substring(4, 5) + bd.substring(6, 7)).equals("xx")){
                        return 2;
                    }
                    break;
                    case 3:
                    if (bd.substring(4, 6).equals("xx") ||
                       (bd.substring(0, 1) + bd.substring(6, 7)).equals("xx")){
                        return 3;
                    }
                    break;
                    case 4:
                    if ((bd.substring(3, 4) + bd.substring(5, 6)).equals("xx")||
                        (bd.substring(1, 2) + bd.substring(7, 8)).equals("xx")||
                        (bd.substring(0, 1) + bd.substring(8, 9)).equals("xx")||
                        (bd.substring(2, 3) + bd.substring(6, 7)).equals("xx")){
                        return 4;
                    }
                    break;
                    case 5:
                    if (bd.substring(3, 5).equals("xx") ||
                       (bd.substring(2, 3) + bd.substring(8, 9)).equals("xx")){
                        return 5;
                    }
                    break;
                    case 6:
                    if (bd.substring(7, 9).equals("xx") ||
                       (bd.substring(0, 1) + bd.substring(3, 4)).equals("xx")||
                       (bd.substring(2, 3) + bd.substring(4, 5)).equals("xx")){
                        return 6;
                    }
                    break;
                    case 7:
                    if ((bd.substring(6, 7) + bd.substring(8, 9)).equals("xx") ||
                        (bd.substring(1, 2) + bd.substring(4, 5)).equals("xx")){
                        return 7;
                    }
                    break;
                    case 8:
                    if (bd.substring(6, 8).equals("xx") ||
                       (bd.substring(2, 3) + bd.substring(5, 6)).equals("xx")||
                       (bd.substring(0, 1) + bd.substring(4, 5)).equals("xx")){
                        return 8;
                    }
                    break;
                }
            }
        }
        //then use 5 brain cells and rotl
        for(boolean q: open){
            if (q){
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
            index++;
        }
        //label the s value index of the biggest prefering to play l-r, t-b
        int inwin = 0;
        for (int j = 1; j < 9; j++){
            double spot = s[j];
            if (spot > s[inwin]){
                inwin = j;
            }
        }
        return inwin;
    }
    public void OStick(){
        
    }
    public void OCarrot(){
        
    }
    public String toString(){
        return("Villian:\nclsx: " + brain[0] + "\nclso: " + brain[1] +
               "\ncrnr: " + brain[2] + "\nsids: " + brain[3] + "\nmidl: " + brain[4]);
    }
}