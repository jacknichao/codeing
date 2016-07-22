/**
 * Created by root on 7/20/16.
 * 题目描述

 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class MinValueInRotateArray {
    public static void main(String[] args) {
        //int[] arr={4,5,6,1,2,3};
        int[] arr={1,1,1,0,0,1};

        System.out.println(new MinValueInRotateArray().minNumberInRotateArray(arr));

    }

//    使用二分查找法
    public int minNumberInRotateArray2(int[] array){
        int left=0;
        int right=array.length-1;
        int middle=left;

        while(array[left] >=array[right]){
            if(right-left==1){
                middle=right;
                break;
            }
            middle = (left + right)/2;
            if(array[middle]>=array[left]) left=middle;
            else if(array[middle]<=array[right]) right=middle;
        }
        return array[middle];
    }


    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;

        int result=0;
        int first=array[0];
        int last=array[array.length-1];

        if(first< last) return first;
        else{
            int j=array.length-1;
            while(j>=0&& array[j]<=last){
                last=array[j--];
            }
                result=last;
        }

        return result;
    }
}
