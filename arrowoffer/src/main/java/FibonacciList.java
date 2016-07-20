import java.util.HashMap;

/**
 * Created by root on 7/20/16.
 * 题目描述

 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class FibonacciList {
    public static void main(String[] args) {

    }

    public int Fibonacci(int n) {
        if(n<=1) return 1;
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;

        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }

        return arr[n-1];
    }

    private int getMiddleValue(int n,HashMap<Integer,Integer> map ){
        if(n==0) return 1;
        else if(n==1) return 1;
        else return Fibonacci(n-2)+Fibonacci(n-1);
    }
}
