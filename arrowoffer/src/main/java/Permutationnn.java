import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by root on 7/22/16.
 *
 * 题目描述

 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c
 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutationnn {
    public static void main(String[] args) {

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList=new ArrayList<String>();
        if(str==null|| str.length()==0) return arrayList;
        Permutation(str.toCharArray(),0,arrayList);
        Collections.sort(arrayList);
        return arrayList;
    }

    public void Permutation(char[] chs,int index,ArrayList<String> result){
        if(index==chs.length-1){
            if(!result.contains(String.valueOf(chs)))result.add(String.valueOf(chs));
        }else{

            for(int i=index+1;i<chs.length;i++){
                char t=chs[i];
                chs[i]=chs[index];
                chs[index]=t;

                Permutation(chs,index+1,result);

                t=chs[i];
                chs[i]=chs[index];
                chs[index]=t;
            }
        }
    }

}
