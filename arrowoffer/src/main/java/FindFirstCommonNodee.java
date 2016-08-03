import java.util.List;
import java.util.Stack;

/**
 * Created by root on 16-7-27.
 *
 题目描述
 输入两个链表，找出它们的第一个公共结点。

 */
public class FindFirstCommonNodee {
    public static void main(String[] args) {
        int a=3;
        int b=4;
        System.out.println("a=="+a+",  b=="+b);
       /* a=a+b;
        b=a-b;
        a=a-b;*/

       /* a=a^b;
        b=a^b;
        a=a^b;*/
        System.out.println("a=="+a+",  b=="+b);
    }


    //方法2：首先一遍兩個鏈表看看各自的長度，
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null) return null;
        int len1=0;
        int len2=0;

        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while(p1!=null){
            len1++;
            p1=p1.next;
        }

        while(p2!=null){
            len2++;
            p2=p2.next;
        }

        ListNode longNode=pHead1;
        ListNode shortNode=pHead2;
        int delta=len1-len2;

        if(len2>len1){
            delta=len2-len1;
            longNode=p2;
            shortNode=p1;
        }

        for(int i=0;i<delta;i++){
            longNode=longNode.next;
        }
        ListNode commonNode=null;

        while(longNode!=null&& shortNode!=null){
            if(longNode==shortNode){
                commonNode=longNode;
                break;
            }
            longNode=longNode.next;
            shortNode=shortNode.next;
        }

        return commonNode;
    }


    //方法1：借助两个桟，把两个链表都入桟，这样，链表的尾部都会出现在桟顶，出桟的时候依次判断对应的节点时候一直即可
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;

        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (stack1.peek() == stack2.peek()) {
                commonNode = stack1.peek();
            }
            stack1.pop();
            stack2.pop();
        }

        return commonNode;
    }

}
