/**
 * Created by root on 7/20/16.
 * 题目描述

 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public static void main(String[] args) {

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode l1=list1;
        ListNode l1_last=list1;

        ListNode l2=list2;
        while(l1!=null&& l2!=null){
            if(l1.val<l2.val){
                l1_last=l1;
                l1=l1.next;
                continue;
            }

            l1_last.next=l2;


        }

    }
}
