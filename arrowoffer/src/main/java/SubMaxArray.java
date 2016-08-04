import java.util.Arrays;

/**
 * Created by root on 16-8-4.
 */
public class SubMaxArray {
    public static void main(String[] args) {
        int[] arr=new int[]{1,-2,3,10,-4,7,2,-1};
        int[] maxSum=new int[arr.length];
        maxSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(maxSum[i-1]<0) maxSum[i]=arr[i];
            else
                maxSum[i]=maxSum[i-1]+arr[i];
        }

        Arrays.sort(maxSum);
        System.out.println("max subarr sum is :" +maxSum[maxSum.length-1]);
    }


}
