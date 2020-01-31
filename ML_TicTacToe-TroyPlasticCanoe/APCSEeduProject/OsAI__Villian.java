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
        for(int l = 8; l >= 0; l--){
            if (!(bd.substring(l, l + 1).equals("x") || bd.substring(l, l + 1).equals("o")))
            {
                open[l] = true;
            }
        }
        //if it is a winning space
        for (int i = 0; i < 9; i++){
            switch (index){
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
                
                break;
            }
        }
        //if it blocks a winning space
        
        //then use 6 brain cells and rotl
        for(boolean q: open){
            if (q){
                double rotl = 0.0;
                //return first in array with highest value
            }
            index++;
        }
        return 1;
    }
    /** OStick
     * This method is run when O wins
     * It 
     */
    public void OStick(){
        
    }
    public void OCarrot(){
        
    }
    public String toString(){
        return("Villian:\nclsx: " + brain[0] + "\nclso: " + brain[1] +
               "\ncrnr: " + brain[2] + "\nsids: " + 
               brain[3] + "\nmidl: " + brain[4]);
    }
}