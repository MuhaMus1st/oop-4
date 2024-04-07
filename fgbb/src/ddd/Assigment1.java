package ddd;
import java.util.Arrays;
import java.util.Scanner;
public class Assigment1 {
    //1
    public static int findMin(int n,int[] arr){
        int min = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    //2
    public static double findAverage(int n,int[] arr){
        double sum =0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        return sum/n;
    }
    //3
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    //4
    public static int fact(int n){
        if(n<=1) return 1;
        return n*fact(n-1);
    }
    //5
    public static int Fibon(int n){
        if(n<=1){
            return n;
        }
        return Fibon(n-1)+Fibon(n-2);
    }
    //6
    public static int degTwo(int a,int n){
        if(n==1) return a;
        return a*degTwo(a,n-1);
    }
    //8
    public static boolean isDig(String s){
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    //9
    public static int binom(int n,int k){
        if(k==0 || k==n){
            return 1;
        }
        return binom(n-1,k-1)+binom(n-1,k);
    }
    //10
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args){
        //1
        int[] arr1={10,2,4,5,2};
        int min = findMin(5,arr1);
        System.out.println(min);
        //2
        int[] arr2={3,2,5,3};
        double av=findAverage(4,arr2);
        System.out.println(av);
        //3
        int num3=7;
        System.out.println("Problem 3: " + num3 + (isPrime(num3) ? " Prime" : " Composite"));
        //4
        int num4=5;
        int factor=fact(num4);
        System.out.println("Factorial of " + num4 + " = " + factor);
        //5
        int num5=5;
        int fib=Fibon(num5);
        System.out.println("Fibonacci(" + num5 + ") = " + fib);
        //6
        int base = 2;
        int ex = 10;
        int pow = degTwo(base, ex);
        System.out.println("Problem 6: " + base + "^" + ex + " = " + pow);
        //8
        String str8a = "123456";
        String str8b = "123a12";
        System.out.println("Problem 8:");
        System.out.println(str8a + (isDig(str8a) ? " Yes" : " No"));
        System.out.println(str8b + (isDig(str8b) ? " Yes" : " No"));
        //9
        int n9=7;
        int k9=3;
        int binC=binom(n9,k9);
        System.out.println(binC);
        //10
        int a10=32;
        int b10=48;
        int gcdd=gcd(a10,b10);
        System.out.println(gcdd);

    }
}

