public class Game
{
    public String xPlays(String b, int x){
        b = b.substring(0, x - 1) + "x" + b.substring(x);
        return b;
    }
    public String oPlays(String b, int x){
        b = b.substring(0, x - 1) + "o" + b.substring(x);
        return b;
    }
    public void printGame(String b){
        System.out.println("[" + b.substring(0,1) + "][" + b.substring(1,2) + "][" + b.substring(2,3) + "]");
        System.out.println("[" + b.substring(3,4) + "][" + b.substring(4,5) + "][" + b.substring(5,6) + "]");
        System.out.println("[" + b.substring(6,7) + "][" + b.substring(7,8) + "][" + b.substring(8,9) + "]");
    }
}
