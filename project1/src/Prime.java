import java.util.Arrays;

/**
 * Created by sidi Diaby on 9/25/2016.
 */
public class Prime {
    public static boolean isPrime(int number){
        int count=0;
        int i=1;
        while(i<(number/2+1)){
            if (number%i==0){
                count+=1;

            }
            i++;

        }
        if (count>1){
            return false;
        }
        return true;
    }
    public static int getPrime(int n){
        int i=2;
        int count=0;
        if (n==1){
            return 2;

        }
        while(count<n){
            if(isPrime(i)){
                count++;


            }
            i++;



        }
        return i-1;
    }
    public static int[] getPrimeArray(int n){
        int A[];
        A=new int[n];
        for(int i=1;i<=n;i++){
            A[i-1]=getPrime(i);


        }
        return A;
    }
    public static void main( String[]args){

        System.out.println(Arrays.toString(getPrimeArray(100)));
    }
}
