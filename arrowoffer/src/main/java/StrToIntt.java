/**
 * Created by root on 16-7-29.
 *
 题目描述
 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。

 */
public class StrToIntt {
    public static void main(String[] args) {
        System.out.println(new StrToIntt().StrToInt(""));

    }

    //这道题的不在于难度多大，而在于考虑的全面与否
    //1.字符串的非法输入
    //2.转换成整数后上溢或者下溢
    //3.正负号问题
    //4.空串如何处理
    public int StrToInt(String str) {
        if(str==null || str.length()<=0) return 0;
        //标示是正数还是负数
        boolean positiveFlag=true;
        //该字符串是否是有效的数字字符串
        boolean isValidate=true;

        char[] chs=str.toCharArray();
        int index=0;

        if(chs[index]=='+'){
            index++;
        }else if(chs[index]=='-'){
            positiveFlag=false;
            index++;
        }

        isValidate=chechValidate(chs,index);
        int result;
        if(!isValidate){
            result=0;
        }else{
            result=translateCharToInt(chs,index,positiveFlag);
        }
        if(positiveFlag) return result;
        else return  -result;
    }

    public boolean chechValidate(char[] chs,int start){
        boolean validate=true;
        while(start<chs.length){
            if(chs[start]<='9'&&chs[start]>='0'){
                start++;
            }else{
                validate=false;
                break;
            }
        }
        return validate;
    }

    public int translateCharToInt(char[] chs,int start,boolean positiveFlag){
        long result=0;
        while(start<chs.length){
            result*=10;
            result+=chs[start++]-'0';
        }

        if(positiveFlag){
            if(result>0x7fffffff){
              result=0;
            }
        }else{
            if(-result<0x80000000){
                result=0;
            }
        }

        return (int)result;

    }


}
