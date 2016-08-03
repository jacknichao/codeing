package com.nichao.sorts;

/**
 * Created by root on 16-7-30.
 * 功能；归并排序
 */
public class MergeSort {
    public static void main(String[] args) {

    }

    public static void mergeSort(int[] arr,int low,int high){
        if(arr==null||arr.length<=0) return;
        if (low<high){
            int index=(low+high)/2;
            mergeSort(arr,low,index);
            mergeSort(arr,index+1,high);
            //merge all sorted
            merge(arr,low,index,high);
        }
    }

    //合并已经排序的两部份
    public static void merge(int[] arr,int low,int index,int high){
        int[] tmp1=new int[index-low+1];
        int[] tmp2=new int[high-index+1];



    }
}
