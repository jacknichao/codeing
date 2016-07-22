/**
 * Created by root on 7/21/16.
 */
public class FF {
    public static void main(String[] args) {
        System.out.println(FIB(50));
    }

    public static long FIB(int n){
        long first=0;
        long second=1;
        long result=1;
        for(int i=2;i<=n;i++)
        {
            result=first+second;
            second=first;
            first=result;
        }
        return result;
    }
}
