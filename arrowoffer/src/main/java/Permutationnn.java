import java.util.ArrayList;
import java.util.Arrays;
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
        Permutationnn p=new Permutationnn();
        p.permutation("12345","54321");

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


    //使用字典序完成字符的全排列
    public void permutation(String str,String end){
        if(str==null||str.length()<=0) return ;

        char[] chs=str.toCharArray();
        System.out.println(chs);

        while(!end.equals(new String(chs))){
            while(nextPermutation(chs)){
                System.out.println(chs);
            }
        }
    }

    //二找 一交换 一反转
    public boolean nextPermutation(char[] chs){
        //一找：找到排列中最后（最右）一个升序的首位位置i
        int i=-1;
        for(i=chs.length-2;i>=0&& chs[i]>chs[i+1];i--);

        //表明已经找到所有的排列
        if(i<0){
            System.err.println("--------------------------");
            return false;
        }

        int j=-1;
        //二找：找到排列中第i位右边最后一个比ch[i]大的位置j
        for(j=chs.length-1;j>i&&chs[j]<chs[i];j--);

        //一交换
        char t=chs[i];
        chs[i]=chs[j];
        chs[j]=t;

        //一反转
        reverse(chs,i+1,chs.length-1);
        return true;
    }


    //反转制定字符数组区间中的字符
    public void reverse(char[] chs,int low,int high){
        while(low<high){
            char t=chs[low];
            chs[low]=chs[high];
            chs[high]=t;
            high--;
            low++;
        }
    }

}
