import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by root on 16-7-27.
 *
 题目描述
 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 输出描述:

 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序


 */
public class FindContinuousSequences {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrs=new FindContinuousSequences().FindContinuousSequence(15);
        System.out.println(arrs);

    }

    //该题的解法与一组连续值中找到两个数和等于特定的值的解法相似，也是开两个索引，如果两个索引之间的数字和小于我们需要的数字，
    //那么需要增大数组，即将右边的索引增大，如果大于了我们目标和，那我们需要减小数组中容纳的数值，
    //因此需要增大左边的索引，等同于将数组中的值减小
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<ArrayList<Integer>>();

        if(sum<3) return arrayLists;

        int small=1;
        int bigger=2;
        //因为要求至少是两个数，所以如果最小的树超过要去的和的一半的话，那么加上大的数肯定要超过目标和
        int middle=(sum+1)/2;
        int tmpSum=small+bigger;

        while(small<=middle){
            tmpSum=(bigger+small)*(bigger-small+1)/2;
            if(tmpSum==sum) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for (int i = small; i <= bigger; i++)
                    arr.add(i);
                arrayLists.add(arr);

                //寻找下一组可能的组合
                bigger++;
//                continue;
            }else if(tmpSum>sum){
                small++;
            }else{
                bigger++;
            }
        }
        return arrayLists;
    }
}
