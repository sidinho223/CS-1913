import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sidi Diaby
 * diby002
 * on 10/19/2016.
 * debug is just a simple version of turn but i also called the method display here. It was a fun but hard project :)
 * enjoy the game.
 *
 */
public class debug {
    public static void main(String[] args) {
        System.out.println("please what are deimensions of your array?");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        Board c = new Board(a, b);
        c.placeShip();
        c.display();
        int count = 0;


        while (!c.isEmpty()) {
            System.out.println(" enter target location");
            Scanner scanned = new Scanner(System.in);
            int x = scanned.nextInt();
            int y = scanned.nextInt();

            Turn t = new Turn(c, x, y);
            c.display();
            c.addTurn();
            count=c.getTurn();
        }
        System.out.println(" goodjob you were able to end the game in " + (count-1) + " turns :)");
    }
}
