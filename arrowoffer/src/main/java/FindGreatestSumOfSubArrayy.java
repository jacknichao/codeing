/**
 * Created by root on 16-7-25.
 题目描述:
 HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,
 他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},
 连续子向量的最大和为8(从第0个开始,到第3个为止)。你会不会被他忽悠住？
 */
public class FindGreatestSumOfSubArrayy {

    public static void main(String[] args) {
        int[] arr={6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArrayy().FindGreatestSumOfSubArray(arr)+"--------");

    }

    public int FindGreatestSumOfSubArray2(int[] array){
        if(array==null||array.length<=0) return 0;

        int nCurSum=0;
        int nGreatestSum=0x80000000;
        for(int i=0;i<array.length;i++){
            if(nCurSum<=0)
                nCurSum=array[i];
            else
                nCurSum+=array[i];

            if(nCurSum>nGreatestSum)
                nGreatestSum=nCurSum;
        }
        return nGreatestSum;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSubArray=-1;
        if(array==null|| array.length<=0) return maxSubArray;

        int[] sumArr=new int[array.length];

        sumArr[0]=array[0];
        for(int i=1;i<array.length;i++){
            if(sumArr[i-1]>0){
                sumArr[i]=sumArr[i-1]+array[i];
            }else{
                sumArr[i]=array[i];
            }
        }

        maxSubArray=sumArr[0];
        for(int j=1;j<sumArr.length;j++){
            System.out.println(sumArr[j]);
            if(sumArr[j]>maxSubArray)
                maxSubArray=sumArr[j];
        }

        return maxSubArray;
    }
}
