/**
 * Created by root on 7/20/16.
 * 题目描述

 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthTOTail {
    public static void main(String[] args) {

    }

    public ListNode FindKthToTail2(ListNode head,int k) {

        ListNode pre=head;
        ListNode last=head;


        int count=0;
        int original=k;

        while(pre!=null ){
            pre=pre.next;
            count++;
            if(k<1){
                last=last.next;
            }
            k--;
        }

        if(count<original) return null;
        return last;
    }


    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode tmp=head;
        int numbers=0;
        while(tmp!=null){
            numbers++;
            tmp=tmp.next;
        }

        if(numbers<k)
            return null;

        int index=numbers-k;
        int count=0;

        while(count != index){
            count++;
            head=head.next;
        }
        return head;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}