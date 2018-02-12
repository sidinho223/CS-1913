/**
 * Created by sidim on 10/21/2016.
 */

public class Exam {

    public static void update(double multiplier, double val, Pair pr) {
        val = multiplier * val;
        pr.left = multiplier * pr.left;
        pr.right = multiplier * pr.right;
        System.out.println("Update: val is: " + val + " pair is: " + pr.left + " " + pr.right);
    } // update

    public static void main(String[] args) {
        Pair p = new Pair(3.0, 4.0);
        double x = 5.0;

        System.out.println("Start main: x is: " + x + " pair is: " + p.left + " " + p.right);
        update(2, x, p);
        System.out.println("End main: x is: " + x + " pair is: " + p.left + " " + p.right);
    } // main
}