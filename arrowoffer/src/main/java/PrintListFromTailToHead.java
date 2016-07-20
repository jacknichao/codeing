import sun.nio.cs.StandardCharsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Administrator on 2016/7/19.
 * 题目描述
 * <p>
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 输入描述:
 * 输入为链表的表头
 * <p>
 * <p>
 * 输出描述:
 * 输出为需要打印的“新链表”的表头
 */
public class PrintListFromTailToHead {



    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while(listNode!=null){
            arrayList.add(listNode.val);
            listNode=listNode.next;
        }

        int len=arrayList.size();
        ArrayList<Integer> result=new ArrayList<Integer>(len);
        for(int i=len-1;i>=0;i--)
            result.add(arrayList.get(i));

        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
