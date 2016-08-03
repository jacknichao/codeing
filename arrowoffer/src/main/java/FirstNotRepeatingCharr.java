/**
 * Created by root on 16-7-27.
 *
 题目描述
 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置

 */
public class FirstNotRepeatingCharr {
    public static void main(String[] args) {
        System.out.println((char)new FirstNotRepeatingCharr().FirstNotRepeatingChar("abaccdeff"));

    }

    //用空间换时间，一个字符是8位，可以表示256各符号，
    // 可以申请256个数组，用字母的ascii码作为键， 值为出现的次数标记，比如出现一次的，只标记为1，多次的用-1标记
    //然后遍历字符串两次，第一次统计各个字符的出现次数，第二次遍历的时候，看当前字符串是不是出现1次
    public int FirstNotRepeatingChar(String str) {

        if(str==null || str.length()<=0) return -1;

        int[] times=new int[256];

        for(char c:str.toCharArray()){
            int code=(int)c;
            if(times[code]==0){
                times[code]=1;
            }else if(times[code]==1){
                times[code]=-1;
            }
        }

        int index=-1;
        for(int i =0 ;i<str.length();i++)
            if(times[(int)str.charAt(i)]==1){
                index=i;
                break;
            }

        return index;
    }
}
