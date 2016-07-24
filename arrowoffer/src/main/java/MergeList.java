/**
 * Created by root on 7/20/16.
 * 题目描述

 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeList {
    public static void main(String[] args) {
        ListNode l1=new ListNode(5);
        ListNode l21=new ListNode(1);
        ListNode l22=new ListNode(3);
        l21.next=l22;
        ListNode l23=new ListNode(4);
        l22.next=l23;

        new MergeList().showList(l1);
        new MergeList().showList(l21);
        MergeList mergeList=new MergeList();


    }

    public void showList(ListNode listNode){
        ListNode tmp=listNode;
        while(tmp!=null){
            System.out.print(tmp.val+"-->");
            tmp=tmp.next;
        }
        System.out.println();

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode pMergeHead=null;
        if(list1.val<=list2.val){
            pMergeHead=list1;
            pMergeHead.next=Merge(list1.next,list2);
        }else{
            pMergeHead=list2;
            pMergeHead.next=Merge(list1,list2.next);
        }
        return pMergeHead;
    }


}
