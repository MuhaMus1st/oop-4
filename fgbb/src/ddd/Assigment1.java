package ddd;
import java.util.Arrays;
import java.util.Scanner;
public class Assigment1 {
    //1 - Linear
    public static int findMin(int n,int[] arr){
        int min = arr[0];
        for(int i=0;i<n;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    // 1 - Constant
    public static int findMinCo(int[] arr, int n) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    //2 Linear
    public static double findAverage(int n,int[] arr){
        double sum =0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        return sum/n;
    }
    // 2 - Constant
    public static double findAverageCon(int[] arr, int n) {
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum / n;
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
    //4 Constant
    public static int fact(int n){
        if(n<=1) return 1;
        return n*fact(n-1);
    }
    //4 Linear
    public static int factorialLinear(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    //5 Constant
    public static int Fibon(int n){
        if(n<=1){
            return n;
        }
        return Fibon(n-1)+Fibon(n-2);
    }
    //5 Linear
    public static int fibonacciLinear(int n) {
        int a = 0, b = 1, c;
        if (n == 0) return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    //6 Constant
    public static int degTwo(int a,int n){
        if(n==1) return a;
        return a*degTwo(a,n-1);
    }
    //6 Linear
    public static int powerLinear(int a, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= a;
        }
        return result;
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
    //8 Constant
    public static boolean isDigitsCon(String s) {
        return s.matches("[0-9]+");
    }
    //9 Constant
    public static int binom(int n,int k){
        if(k==0 || k==n){
            return 1;
        }
        return binom(n-1,k-1)+binom(n-1,k);
    }
    //9 Linear
    public static int binLin(int n, int k) {
        int res = 1;
        if (k > n - k) k = n - k;
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
    //10 Constant
    public static int gcd(int a , int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    //10 Linear
    public static int gcLinear(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
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
        int gc=gcd(a10,b10);
        System.out.println(gc);
    }
}

