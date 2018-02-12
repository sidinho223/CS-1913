/**
 * Created by sidi Diaby
 * diaby002
 * on 10/18/2016.
 */
public class Ships {

    private int size;
    private int m;
    private int n;
    private String name;
    private int column;
    private int row;
    private String direction;
    private String symbol;
    /*here i created an instance of a ship with name, m and n are the dimensions of the board i needed it to ocompute
    the random value this class has few setter and getter  methods
     */



    public Ships(String name,int size,int m,int n, String direction) {
        if (n==2 && m==2){
            this.size=1;
        }
        else {
            this.size = size;
        }
        this.m = m;
        this.n = n;
        this.column = (int) Math.floor(Math.random() * m);
        this.row = (int) Math.floor(Math.random() * n);
        this.name=name;
        this.symbol=getSymbol(name);
        this.direction=direction;

    }
    public Ships(String name,int size,int m,int n) {
        if (n==2 && m==2){
            this.size=1;
        }
        else {
            this.size = size;
        }
        this.m = m;
        this.n = n;
        this.column = (int) Math.floor(Math.random() * m);
        this.row = (int) Math.floor(Math.random() * n);
        this.name=name;
        this.symbol=getSymbol(name);

    }


    public int getSize(){
        return size;
    }
    public String getSymbol(String name){
        if(name.compareTo("Titanic")==0){
            return "T";
        }
        if(name.compareTo("Santa Maria")==0){
            return "M";
        }
        if(name.compareTo("HML Beagel")==0){
            return "B";
        }
        if(name.compareTo("Thousand Sunny")==0){
            return "S";
        }
        return "D";

    }
    public int getColumn(){
        return column;
    }
    public int getRow(){
        return row;
    }
    public String getName(){
        return name;
    }
    public void setDirection(String s){
        direction=s;
    }
    public String getDirection(){
        return direction;
    }
    }



