/**
 * Created by sidim on 10/21/2016.
 */
public class Pair {
    public Pair(double l, double r) {
        left = l;
        right = r;
    }
    public double left;
    public double right;
    public static void main(String[] args) {
        Pair p1 = new Pair(1.0, 2.0);
        Pair p2 = new Pair(1.0, 2.0);
        if (p1.equals(p2))
            System.out.println("They are equal");
        else System.out.println("Different");
    }
} // Pair class
