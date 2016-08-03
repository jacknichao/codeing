package com.nichao.sorts;

import java.util.Arrays;

/**
 * Created by root on 16-7-29.
 * 功能：直接插入排序
 */
public class InsertSort_DirectInsertSort {
    public static void main(String[] args) {
        int[] arr={4,2,9,23,22,5,1};
        System.out.println(Arrays.toString(arr));
        directInsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void  directInsertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int tmp=arr[i];
            //j+1位是可用的
            while(j>=0 && arr[j]>tmp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=tmp;
        }
    }
}
