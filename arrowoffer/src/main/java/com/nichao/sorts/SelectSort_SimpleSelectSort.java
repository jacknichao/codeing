package com.nichao.sorts;

import java.util.Arrays;

/**
 * Created by root on 16-7-29.
 * 功能：简单选择排序
 */
public class SelectSort_SimpleSelectSort {
    public static void main(String[] args) {
        int[] arr={4,2,9,23,22,5,1};
        System.out.println(Arrays.toString(arr));
        simpleSelectSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void simpleSelectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++)
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    arr[i]=arr[i]+arr[j];
                    arr[j]=arr[i]-arr[j];
                    arr[i]=arr[i]-arr[j];
                }
            }
    }
}
