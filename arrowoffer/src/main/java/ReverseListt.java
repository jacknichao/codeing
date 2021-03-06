/**
 * Created by root on 7/20/16.
 * 题目描述
 * <p>
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 方法：头插法，遍历一个链表，使用头插法插入都另一个链表中
 */
public class ReverseListt {
    public static void main(String[] args) {

    }

    //方法：头插法，遍历一个链表，使用头插法插入都另一个链表中
    public ListNode ReverseList(ListNode head) {
        ListNode listNode = null;
        while (head != null) {
            int val = head.val;
            ListNode tmp = new ListNode(val);
            tmp.next = listNode;
            listNode = tmp;
            head = head.next;
        }

        return listNode;
    }


    //方法：使用第归的方式反转链表
    public ListNode reverseList(ListNode head){
        if(head==null ||head.next==null) return head;

        ListNode newhead=reverseList(head.next);
        //画图表示比较直观
        head.next.next=head;
        head.next=null;
        return newhead;
    }
}

