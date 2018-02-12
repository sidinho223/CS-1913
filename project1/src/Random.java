import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sidi Diaby on 9/26/2016.
 *
 */
public class Random {
    private int randseed=0;
    private int P1;
    private int P2;
    private int M;

    public Random(int p1, int p2, int m){
        this.P1=p1;
        this.P2=p2;
        this.M=m;



    }
    public void setSeed(int seed){
        randseed=seed;

    }
    public int getMaximum(){
        return M;
    }
     public int getRandom(){
        int result =((P1 * randseed) + P2) % M ;

        setSeed(result);
         return  result;

     }
    public int getRandomInteger(int lower, int upper){
        int a= getRandom();
        if(lower>upper){
          int temp=lower;
            lower=upper;
            upper=temp;
        }



        a=a%(upper-lower+1)+lower;

        return a;
    }
    public boolean getRandomBoolean(){
        int a=getRandomInteger(1,2);
        if(a==2){

        return true;
    }
    else{
            return false;
        }
    }

    public int getRandomItem(int[] array){
        int n=array.length -1;

        return array[getRandomInteger(0,n)];
    }

    public int[] getRandomIntegerArray(int n, int lower, int upper){
        int [] A= new int [n];
        for(int i=0;i<n;i++){
            A[i]=getRandomInteger(lower,upper);
        }

        return A;
    }
    public double getRandomDouble(double lower, double upper){
        if(lower>upper){
            double temp=lower;
            lower=upper;
            upper=temp;
        }
        double a=getRandom();
        System.out.println("random"+a);


            a = (upper - lower) * (a / (M - 1));





        return a;
    }
    public static void main(String[]args){




       int p1=Prime.getPrime(1200);
        int p2=Prime.getPrime(2000);
        int M=Prime.getPrime(3000);

        Random random= new Random(p1,p2,M);
        System.out.println(" please enter a seed ");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        Scanner scaned=new Scanner(input);
        random.setSeed(scaned.nextInt());

        int [] A= random.getRandomIntegerArray(100,-5,5);
        System.out.println(Arrays.toString(A));




    }
}
