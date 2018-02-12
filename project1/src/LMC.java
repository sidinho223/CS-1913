import java.util.Scanner;

/**
 * Created by sidi Diaby on 9/23/2016.
 */

public class LMC {


    public static int getLMC(int a , int b) {
        int largest=b;
        int smallest;
        int i = 2;
        int result;
        if (a <= 0 | b <= 0)  {

            return -1;
        }
        if (a % b == 0) {
            return a;
        }
        if (b % a == 0) {
            return b;
        }

        if (a < b) {
            largest = b;
            smallest = a;
        } else {
            largest = a;
            smallest = b;
        }
        result=largest;

        while (result% smallest != 0) {
            result=largest * i;
            i += 1;
        }
        return result;
    }
    public static int getGCD(int a , int b){
        int gcd;
        int largest;
        int smallest;
        if (a < 0 | b < 0)  {

            return -1;
        }
        if(a<b){
            largest=b;
            smallest=a;
        }
        else {
            largest=a;
            smallest=b;
        }
        if(smallest==0){
            return largest;
        }
        else{
            int temp=smallest;
            smallest=largest%smallest;
            largest=temp;
            return getGCD(smallest,largest);
        }


    }

    public static void main(String[]args){
        System.out.println(" please enter two numbers a and b: ");
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        Scanner scaned=new Scanner(input);
        int a=scaned.nextInt();
        int b=scaned.nextInt();


        if(getLMC(a,b)<0){
            System.out.println("error invalid input for your LMC");
        }
        else{
            System.out.println("the LMC is "+ getLMC(a,b));
        }

        if(getGCD(a,b)<0){
                System.out.println("error invalid input for your GCD");
            }
           else{
            System.out.println("The GCD is "+getGCD(a,b));
        }

    }


}
