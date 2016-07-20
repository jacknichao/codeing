import java.util.Arrays;

/**
 * Created by root on 7/20/16.
 * 题目描述

 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,7,8,5};
        System.out.println(Arrays.toString(arr));
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void reOrderArray(int [] array) {
        int newIndex=0;
        int j=0;
        int[] newArr=new int[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i]%2==1){
                array[newIndex++]=array[i];
            }else {
                newArr[j++]=array[i];
            }
        }

        j=0;
        while(newIndex<array.length){
            array[newIndex++]=newArr[j++];
        }
    }
}
