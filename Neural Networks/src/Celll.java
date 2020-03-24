public class Celll {

    private int x;
    private int y;
    private int minimaxValue;
    private static Board board = new Board();

    public Celll(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMinimaxValue() {
        return minimaxValue;
    }

    public void setMinimaxValue(int score) {
        this.minimaxValue = score;
    }

    @Override
    public String toString() {
        return (String)("(" + this.x + ", " + this.y + ")");
    }

}
