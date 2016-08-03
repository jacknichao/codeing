import java.util.Arrays;
import java.util.Collections;

/**
 * Created by root on 16-7-27.
 *
 题目描述
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

 */
public class PrintMinNumberr {
    public static void main(String[] args) {
        int[] values={3,32,321};
        System.out.println(new PrintMinNumberr().PrintMinNumber(values));

    }

    public String PrintMinNumber(int [] numbers) {

        if(numbers==null||numbers.length<=0) return "";
        int maxLength=maxLength(numbers);
        String[] strs=new String[numbers.length];
        //构造数据字符串的模板
        char[] chs=new char[maxLength];
        for(int i=0;i<maxLength;i++){
            chs[i]='9'+1;
        }

        String templet=new String(chs);

        for(int i=0;i<numbers.length;i++){
            strs[i]=valueChars(templet.toCharArray(),numbers[i]);
        }

        Arrays.sort(strs);
        StringBuffer sb=new StringBuffer();
        for(String str:strs){
            for(char c: str.toCharArray()){
                if(c>='0'&&c<='9'){
                    sb.append(c);
                }else{
                    break;
                }
            }
        }

        return sb.toString();
    }

    //构造数字字符串，使得长度没有最大字符串长的字符串末尾填充'9'之后的字符
    public String valueChars(char[] chs,int n){
        String str=String.valueOf(n);
        for(int i=0;i<str.length();i++){
            chs[i]=str.charAt(i);
        }
        return String.valueOf(chs);
    }

    //找到数据中最大的数据的位数
    public int maxLength(int[] numbers){
        int value=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]>value)
                value=numbers[i];
        }

        String str=value+"";
        return  str.length();
    }
}
