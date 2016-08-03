package com.nichao.sorts;

import java.util.Arrays;

/**
 * Created by root on 16-7-29.
 * 功能：快速排序
 */
public class ExchangeSort_QuickSort {
    public static void main(String[] args) {
        int[] arr={4,2,9,23,22,5,1};

        quickSort(arr,0,args.length-1);
        System.out.println("使用quickSort:   "+ Arrays.toString(arr));


    }

    public static void quickSort(int[] arr,int low,int high){
        while(low<high){
            int index=partiton(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    public  static int partiton(int[] arr,int low,int high){
        int key=arr[low];
        while(low <high){
            while(low<high&& arr[high]>=key) high--;
                arr[low]=arr[high];

            while(low<high&& arr[low]<key) low++;
                arr[high]=arr[low];
        }

        arr[low]=key;
        return low;
    }
}

