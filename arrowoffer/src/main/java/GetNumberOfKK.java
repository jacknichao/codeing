/**
 * Created by root on 16-7-27.
 *
 题目描述
 统计一个数字在排序数组中出现的次数。

 */
public class GetNumberOfKK {
    public static void main(String[] args) {

    }



    public int GetNumberOfK(int [] array , int k) {
        if(array==null|| array.length<=0) return 0;

        int count=0;

        int firstIndex=getFirstK(array,0,array.length-1,k);
        int lastIndex=getLastK(array,0,array.length-1,k);

        if(firstIndex>-1&& lastIndex>-1){
            count=lastIndex-firstIndex+1;
        }
        return count;
    }

    //因为是在有序的数组中，所以可以考虑二分查找
    public int getFirstK(int[] arr,int low,int high,int key){
        if(low>high) return -1;

        int middleIndex=(low+high)/2;
        int middleData=arr[middleIndex];

        if(middleData==key){
            if((middleIndex>0&& arr[middleIndex-1]!=key)||(middleIndex==0))
                return middleIndex;
            else
                high=middleIndex-1;
        }else if(middleData>key){
            high=middleIndex-1;
        }else{
            low=middleIndex+1;
        }

        return getFirstK(arr,low,high,key);
    }

    public int getLastK(int[] arr,int low,int high,int key){
        if(low>high) return -1;

        int middleIndex=(low+high)/2;
        int middleData=arr[middleIndex];
        if(middleData==key){
            if((middleIndex<arr.length-1&&arr[middleIndex+1]!=key)||(middleIndex==arr.length-1)){
                return middleIndex;
            }else{
                low=middleIndex+1;
            }
        }else if(middleData>key)
            high=middleIndex-1;
        else
            low=middleIndex+1;

        return getLastK(arr,low,high,key);
    }
}
