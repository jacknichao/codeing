import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by root on 16-7-27.
 *
 题目描述
 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 输出描述:

 对应每个测试案例，输出两个数，小的先输出。


 */
public class FindNumbersWithSumm
{
    public static void main(String[] args) {
        int[] arr={1,2,4,7,11,15};

        ArrayList<Integer> arrayList=new FindNumbersWithSumm().FindNumbersWithSum(arr,12);
        System.out.println(arrayList.toString());

    }

    //设置两个指针，一个指向数组头部，一个指向尾部，计算两者之和是否与待求的值相同
    //如果相同的话，那么这是一个满足要求的两者之和
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if(array==null||array.length<=0) return arrayList;

        int low=0;
        int high=array.length-1;
        int curSum=0;
        int multi=0x7ffffff;
        while(low<high){
            curSum=array[low]+array[high];
            if(curSum==sum){
                if(array[low]*array[high]<multi){
                    multi=array[low]*array[high];
                    arrayList.clear();
                    arrayList.add(array[low]);
                    arrayList.add(array[high]);
                    break;
                }
            }else if(curSum>sum){
                high--;
            }else {
                low++;
            }
        }

        return arrayList;
    }
}
