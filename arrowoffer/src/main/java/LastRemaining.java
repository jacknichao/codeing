/**
 * Created by root on 16-7-28.
 *
 题目描述
 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 HF作为牛客的资深元老,自然也准备了一些小游戏。
 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。
 然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution2(5,3));

    }


    //方法2：找到每次出局的规律
    //f(n,m)={1) 0 ,n=1; 2)[f(n-1,m)+m]%n, n>1
    public int LastRemaining_Solution2(int n, int m) {
        if(n<=0||m<=0) return -1;

        int last=0;
        for(int i=2;i<=n;i++)
            last=(last+m)%i;

        return last;
    }



        //方法1：典型的约瑟夫环问题,使用经典的报数写法,这个方法在oj上会报超时,因此需要找规律，采用第二种方法
    public int LastRemaining_Solution(int n, int m) {
        if(n<=0 || m<=0) return -1;
        m=m%n;
        boolean[] flags=new boolean[n];
        int index=0;
        int count=0;
        while(n!=1){
            //表示已经出局的小朋友
            if(flags[index]==true) {
                index++;
                index%=flags.length;
                continue;
            }

            if(count==m-1){
                count=0;
                flags[index]=true;
                n--;
            }else{
                count++;
            }

            index++;
            index%=flags.length;
        }

        int result=-1;
        for(int i=0;i<flags.length;i++)
            if(flags[i]==false) {
                result = i + 1;
                break;
            }

        return result;
    }
}
