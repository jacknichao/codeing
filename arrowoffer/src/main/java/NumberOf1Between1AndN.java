/**
 * Created by root on 16-7-27.
 *
 题目描述
 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可
 以很快的求出任意非负整数区间中1出现的次数。

 */
public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(12));

    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;

        for(int i=1;i<=n;i++){
            count+=countNumof1(i);
        }
        return count;
    }

    public int countNumof1(int n){
        int count=0;
        while(n>0){
            if(n%10==1){
                count++;
            }
            n/=10;
        }
        return count;
    }
}
