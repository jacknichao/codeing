/**
 * Created by root on 7/25/16.
 * 题目描述

 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(new MoreThanHalfNum().MoreThanHalf2(arr));

    }

    //方法1:如何是将其排序的话，超过一半的数候选人肯定是中位数,这种方法时间复杂度较高，
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null|| array.length==0) return 0;

        for(int i=1;i<array.length;i++){
            int j=i-1;
            int tmp=array[i];
            while(j>=0&&tmp<array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            array[j+1]=tmp;
        }

        if(checkMoreThanHalf(array,array[array.length/2]))
            return array[array.length/2];
        else return 0;
    }

    //检查是否真的超过了一半
    public boolean checkMoreThanHalf(int[] array,int value){
        int count=0;
        for(int n:array)
            if(n==value) count++;
        if(count>array.length/2) return true;
        else return false;
    }



    //方法2：借助快速排序的思想，在快排中，partition函数的主要工作就是找个一个数将其放到正确的位置上，并使得它的左边都小于该数，右侧都大于该数
    //并返回正确位置的index，如果这个位置恰好是中位数的index的话，那么就找到了超过一半的候选数字了
    public int MoreThanHalfNum(int[] array){
        if(array==null||array.length<=0) return 0;

        int middle=array.length>>1;
        int start=0;
        int end=array.length-1;
        int index=Partition(array,start,end);
        while(index!=middle){
            if(index>middle){
                end=index-1;
                index=Partition(array,start,end);
            }

            if(index<middle){
                start=index+1;
                index=Partition(array,start,end);
            }
        }

        if(checkMoreThanHalf(array,array[middle]))
            return array[middle];
        else return 0;

    }

    public int Partition(int[] arr,int start,int end){
        int tmp=arr[start];
        while(start<end){
            while(start<end&&arr[end]>=tmp) end--;
                 arr[start]=arr[end];

            while(start<end&&arr[start]<tmp) start++;
                arr[end]=arr[start];
        }
        arr[start]=tmp;
        return start;
    }


    //方法3：分析数据结构特征:数组中有一个数字出现次数超过一半，也就是说它出现的次数比其他所有数次出现的次数之和还要多
    //因此，我们可以考虑在遍历数组的时候保存两个值，一个是数组中的一个数字，一个是次数
    public int MoreThanHalf2(int[] array){
        if(array==null ||array.length<=0) return 0;
        int value=array[0];
        int count=1;

        for(int i=1;i<array.length;i++){
            if(value==array[i]){
                count++;
                continue;
            }
            if(count>0) {
                count--;
            }else{//当为0的时候i，我们需要保存下一个数字，并把次数设置为1
                count=1;
                value=array[i];
            }
        }

        if(checkMoreThanHalf(array,value)) return value;
        else return 0;
    }
}
