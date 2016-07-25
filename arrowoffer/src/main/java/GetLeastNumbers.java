import java.util.ArrayList;

/**
 * Created by root on 7/25/16.
 * 题目描述

 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class GetLeastNumbers {
    public static void main(String[] args) {
        int[] arr={4,5,1,6,2,7,3,8};
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(arr,4));

    }



    //方法2:使用快速排序的思想，在快排中，partition函数的主要工作就是找个一个数将其放到正确的位置上，并使得它的左边都小于该数，右侧都大于该数
    //并返回正确位置的index，如果这个位置恰好是第k个的话，那么其左边的数字都是小于这个数
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input ,int k){

    }


    //方法1.开辟额外的k个数字空间，用于保存最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input==null|| input.length<=0||k<=0) return new ArrayList<Integer>();

        ArrayList<Integer> arrayList=new ArrayList<Integer>(k);
        if(k>=input.length)
            for(int n:input)
                arrayList.add(n);

        else {
            int index = 0, j = 0;
            int[] arr = new int[k];
            arr[0]=input[0];

            for (int i = 1; i < input.length; i++) {
                if (j < k - 1) {
                    arr[++j] = input[i];
                } else {
                    //已经存入了k个数字，此时开始把最大的数字置换出来
                    index = findMaxIndex(arr);
                    if (arr[index] > input[i])
                        arr[index] = input[i];
                }
            }

            for (int n : arr)
                arrayList.add(n);
        }
        return arrayList;
    }


    /*找到数组中的最大的值对应的索引*/
    public int findMaxIndex(int[] arr){
        int max=arr[0];
        int index=0;
        for(int i=1;i<arr.length;i++)
            if(arr[i]>max){
                max=arr[i];
                index=i;
            }
        return index;
    }



}
