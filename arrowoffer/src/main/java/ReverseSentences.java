/**
 * Created by root on 16-7-28.
 *
 题目描述
 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

 */
public class ReverseSentences {
    public static void main(String[] args) {
        String str="student. a am i";
        System.out.println(new ReverseSentences().ReverseSentence(str));

    }

    //先翻转整个句子，然后将句子按照空格划分，再翻转单词
    public String ReverseSentence(String str) {
        if(str==null || str.length()<=0) return "";
        char[] chs=str.toCharArray();
        //reverse all sequence
        reverseChars(chs,0,chs.length-1);
        //reverse statements
        int start=0;
        int end=0;
        while(end<chs.length){
            if(chs[end]==' '){
                reverseChars(chs,start,end-1);
                start=end+1;
            }else if(end==chs.length-1){
                reverseChars(chs,start,end);
            }
            end++;
        }

        return String.valueOf(chs);
    }

    public void reverseChars(char[] chs,int start,int end){
        while(start<end){
            char c=chs[start];
            chs[start]=chs[end];
            chs[end]=c;
            start++;
            end--;
        }
    }
}
