/**
 * Created by root on 7/20/16.
 */
public class JumpFloor2 {
    public static void main(String[] args) {

    }

    public int JumpFloorII(int target) {

        if(target <=0)
            return 0;
        else if(target==1)
            return 1;
        else if(target==2)
            return 2;
        //n step for each jump
        int result=1+1+2;
        target--;
        while(target>2)
            result+=JumpFloorII(target--);

        return result;

    }
}
