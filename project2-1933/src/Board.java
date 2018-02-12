import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sidi Diaby
 * diaby002
 * on 10/18/2016.
 */
public class Board {
    private int m;
    private int n;
    boolean valid;
   private Ships[][] board;
    private Boolean [][] hit;
    private int turn=0;
/* gosh this part was the hardest no doubt ! 8 hours or more of pure thinking :(!! well what I did here is that I selected
the random row and column created in Ships and I built a ship from that point by checking if the adjacent column or row was
empty. I also have a boolean array with the same dimensions as my board which checked whether a particular point in the
 board was hit. I also added some names just for the fun. the most complex methods were isValid and placeship. I could
 have used less method, but created a bunch of them mak the problem easier :)
 */


    private int num;
    private String direction="v";

    public Board(int m, int n) {
        if ((m >= 2 && n >= 2) && (m <= 10 && n <= 10)) {

            this.m = m;
            this.n = n;
            valid = true;

            this.num=numberOfShips();
            this.board = new Ships[m][n];
            hit=new Boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j <n ; j++) {
                    hit[i][j]=false;
                }
            }



        } else {
            valid = false;
        }
        if (valid == true) {

        }

        System.out.println(isValidBoard());
    }

    public int getWidth() {
        return n;
    }

    public int getLength() {
        return m;
    }

    public String isValidBoard() {

        if (valid == true) {
            System.out.println("Titanic: T ,  Santa Maria:S, HML Beagel: B, Thousand Sunny= S, Flying dutchman= D ");

            return "Your board was created :) ";

        }
        return "Your board wasn't created :( . Sorry, but one of  your inputs was invald ";
    }



    public int numberOfShips() {

         if (m == 2 || n == 2) {
            num = 1;


        }
        else if (2 < n && n <= 4 || 2 < m && m <= 4) {
            num = 2;

        }
        else if (4 < n && n <= 6 || 4 < m && m <= 6) {
            num = 3;

        }
        else if (6 < n && n <= 8 || 6 < m && m <= 8) {
            num = 4;

        }

       else{ num = 5;}
        return num;

    }
    public Ships typeofShip(){
        if (num==1) {
            Ships s= new Ships("Titanic",2,m,n);
            return s;


        }
        else if (num==3) {
            Ships s = new Ships("Santa Maria", 3, m, n);

            return s;
        }
            else if(num==2){
            Ships s = new Ships("Thousand Sunny", 3, m, n);
            return s;

        }
        else if (num==4) {
            Ships s= new Ships("HML Beagel",4,m,n);
            return s;


        }

        else{
            Ships s= new Ships("Flying Dutchman",5,m,n);
            return s;
        }





    }
    public boolean isValidShip(Ships s) {
        if(s.getRow()+s.getSize()>=n && s.getColumn()+s.getSize()>=m){
            return false;
        }

       else if (s.getColumn() + s.getSize() < m) {
            for (int i =0; i <s.getSize() ; i++) {
                if (board[i+s.getColumn()][s.getRow()] != null) {
                    return false;
                }
            }
            direction="v+";
            }
        else if (s.getColumn() - s.getSize() >=0) {
            for (int i =0; i <s.getSize() ; i++) {
                if (board[s.getColumn()-i][s.getRow()] != null) {
                    return false;
                }
            }
            direction="v-";
        }

        else   if (s.getRow() + s.getSize() < n){
                for (int i = 0; i < s.getSize(); i++) {
                    if (board[s.getColumn()][i+s.getRow()] != null) {

                        return false;

                }

                }
                direction="h";

            }
        else if (s.getRow() - s.getSize() >=0) {
            for (int i =0; i <s.getSize() ; i++) {
                if (board[s.getColumn()][s.getRow()-i] != null) {
                    return false;
                }
            }
            direction="h-";
        }

            return true;
    }



    public void placeShip() {
        while(num>0) {
            Ships s = typeofShip();


            if (isValidShip(s)) {
                if (direction.compareTo("v+") == 0) {

                    for (int i = 0; i < s.getSize(); i++) {


                        board[i+s.getColumn()][s.getRow()] = s;

                    }
                }
                else  if (direction.compareTo("v-") == 0) {

                    for (int i = 0; i < s.getSize(); i++) {


                        board[s.getColumn()-i][s.getRow()] = s;

                    }
                }
                else if (direction.compareTo("h-") == 0) {

                    for (int i = 0; i < s.getSize(); i++) {


                        board[s.getColumn()][s.getRow()-i] = s;

                    }
                }

                else {

                    for (int i = 0; i < s.getSize(); i++) {

                        board[s.getColumn()][i+s.getRow()] = s;
                    }

                }
                s.setDirection(direction);
                num--;
            }
            else {

                placeShip();


            }
        }


            }





    public Ships [][] getBoard(){
        return board;
    }


    public void display() {
        if (valid) {
            String[][] sboard = new String[board.length][board[0].length];
            for (int i = 0; i < sboard.length; i++) {
                for (int j = 0; j < sboard[0].length; j++) {
                    if (board[i][j] == null) {
                        sboard[i][j] = "O";
                    } else {
                        sboard[i][j] = board[i][j].getSymbol(board[i][j].getName());
                    }
                }
            }
            for (int i = 0; i < sboard.length; i++) {
                for (int j = 0; j < sboard[0].length; j++) {
                    System.out.printf("%s  ", sboard[i][j]);
                }
                System.out.println();

            }
        }
        {
            return;
        }


    }
    public void hasbeenhit(int x, int y){
            hit[x][y]=true;
            board[x][y]=null;

    }
    public boolean isEmpty() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != null) {
                    return false;
                }
            }

        }
        return true;
    }
    public boolean washit(int x, int y){
        return hit[x][y];
    }
    public int getTurn(){
        return turn;
    }
    public void setTurn(int x){
        turn=x;
    }
    public void addTurn(){
        turn++;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        Board b = new Board(m, n);
        b.placeShip();

        b.display();


    }


}
