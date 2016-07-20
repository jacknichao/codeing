/**
 *
 * Created by Administrator on 2016/7/19.
 * 题目描述

 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public static void main(String[] args){
        StringBuffer sb=new StringBuffer();
        sb.append("nichao 1990");
        sb.append("swallow  my  wife");


        System.out.println(replaceSpace(sb));


    }

    public static String replaceSpace(StringBuffer str) {
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '|| str.charAt(i)=='\t'){
                str.replace(i,i+1,"%20");
            }
        }

        return str.toString();


    }
}
