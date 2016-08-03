/**
 * Created by root on 16-7-29.
 *
 题目描述
 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 输出描述:

 如果当前字符流没有存在出现一次的字符，返回#字符。


 */
public class FirstAppearingOnceFromStream {
    public static void main(String[] args) {
        String string="google";
        FirstAppearingOnceFromStream fa=new FirstAppearingOnceFromStream();
        for(int i=0;i<string.length();i++){
            fa.Insert(string.charAt(i));
        }

        System.out.println(fa.FirstAppearingOnce());

    }
    private int index=0;
    private int[] occurrence=new int[256];
    //initialize the array
    {
        for(int i=0; i<occurrence.length;i++){
            occurrence[i]=-1;
        }
    }


    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(occurrence[ch]==-1){
            occurrence[ch]=index;
        }else if(occurrence[ch]>=0){
            occurrence[ch]=-2;
        }
        index++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int index=256;
        char c='#';
        for(int i=0;i<256;i++){
            if(occurrence[i]>=0){
                if(occurrence[i]<index){
                    index=occurrence[i];
                    c=(char) i;
                }
            }
        }
        return c;
    }
}
