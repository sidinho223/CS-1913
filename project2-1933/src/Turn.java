import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sidi Diaby
 * diaby002
 * on 10/19/2016.
 */
/*
turn is a simple class that just output many of the string in the turn problem it's also update the turn variable.

 */
public class Turn {


    private int x;
    private int y;
    private Board b;
    private int penalitytype=0;

    public Turn(Board b, int x, int y) {
        this.x = x;
        this.y = y;
        this.b = b;

        System.out.println(hit(x,y));

    }

    public boolean ispenality(int x, int y) {
        if (x >= b.getLength() || y >= b.getWidth()) {
            penalitytype=1;

            return true;
        }
        if (b.washit(x, y) == true) {

            penalitytype=2;

            return true;
        }

        return false;
    }

    public String hit(int x, int y) {
        if (ispenality(x, y)) {
            String r="";

            if(b.getTurn()==0){
                b.addTurn();
            }
            if (penalitytype==1){
                r="Turn "+b.getTurn() +": "+" out of the board :("+" you are penalized by losing turn "+ String.valueOf(b.getTurn()+1)+"\n"+ "Turn "+ (b.getTurn()+1)+": "+"skipped";
               b.addTurn();
            }
            else{
                r= "Turn "+ b.getTurn()+": "+"the the user selects "+ "("+String.valueOf(x) + ","+ String.valueOf(y)+ ") again and is penalized by losing turn "+ String.valueOf(b.getTurn()+1)+"\n"+ "Turn "+ (b.getTurn()+1)+": "+"skipped";
            b.addTurn();
            }

            return r;
        }
        if (b.getBoard()[x][y] != null) {
            int count = 0;
            for (int i = 0; i < b.getBoard().length; i++) {
                for (int j = 0; j < b.getBoard()[x].length; j++) {
                    if (b.getBoard()[i][j] != null) {
                        if (b.getBoard()[i][j].equals(b.getBoard()[x][y])) {
                            count++;
                        }
                    }
                }
            }
            if(b.getTurn()==0){
                b.addTurn();
            }
            if (count > 1) {
                String r="Turn "+ b.getTurn()+": "+ "you hit the "+ b.getBoard()[x][y].getName()+" :) !";
                b.hasbeenhit(x, y);
                return  r;
            }
            else if (count==1) {
                String r="Turn "+ b.getTurn() +": "+"you sunk the "+ b.getBoard()[x][y].getName()+" :) !";
                b.hasbeenhit(x, y);
                return  r;

            }

        }
        if(b.getTurn()==0){
            b.addTurn();
        }
        b.hasbeenhit(x,y);
        return "Turn "+ b.getTurn()+": "+ "You missed Everything :( ";

    }

    public static void main(String[]args){
        System.out.println("please what are dimensions of your array?");
        Scanner scan = new Scanner(System.in);
        int a= scan.nextInt();
        int b= scan.nextInt();
        Board c= new Board(a,b);
        c.placeShip();
        int count=0;

        while (!c.isEmpty()){

            System.out.println(" enter target location");
            Scanner scanned= new Scanner(System.in);
            int x=scanned.nextInt();
            int y=scanned.nextInt();
            Turn t= new Turn(c,x,y);


            c.addTurn();
            count=c.getTurn();



        }
        System.out.println(" good job you were able to end the game in "+String.valueOf(count-1)+ " turns :)");
    }
}
