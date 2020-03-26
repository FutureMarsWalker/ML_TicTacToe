import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args){ //The game starts here
        String wantToPlay = "";
        while(true) {

            Scanner scan = new Scanner(System.in);

            new Game();
            System.out.print("Do you want to play again? (y or n): ");
            wantToPlay = scan.nextLine();

            if (wantToPlay.equalsIgnoreCase("y")) {
                new ApplicationRunner();
            }
            else if (wantToPlay.equalsIgnoreCase("n")){
                System.out.println("Game Over.");
                break;
            }
        }
    }
}
