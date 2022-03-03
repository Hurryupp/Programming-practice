package lcTest;

import org.junit.Test;

import java.util.List;
import java.util.ListIterator;

/**
 * @author lenovo
 * 反转链表2
 */
public class lc92 {
    @Test
    public void test(){

    }
    //重点掌握的，使用递归
    public ListNode reverseBetween(ListNode head, int left, int right){
        if (left==1){
            return reverseN(head,left,right);
        }
        ListNode node = reverseBetween(head.next, left - 1, right - 1);
        head.next = node;
        return head;
    }
    //反转前N个
    ListNode successor = null; //记录最后节点的后驱
    public ListNode reverseN(ListNode head,int left,int n){
        if (n==1){
            successor = head.next;
            return head;
        }
        ListNode node = reverseN(head.next, left, n - 1);
        head.next.next = head;
        head.next = successor;
        return node;
    }




//    自己想的：
//    ListNode hou;
//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        ListNode ahead = new ListNode();
//        ahead.next = head;
//        ListNode slow = ahead;
//        ListNode fast = ahead;
//        for (int i = 0; i < left-1; i++) {
//            slow = slow.next;
//        }
//        for (int i = 0; i < right; i++) {
//            fast = fast.next;
//        }
//        hou = fast.next;
//
//        ListNode helper = helper(slow.next, fast);
//        slow.next = helper;
//        while (helper.next!=null){
//            helper = helper.next;
//        }
//        helper.next = hou;
//        return ahead.next;
//    }
//    public ListNode helper(ListNode head,ListNode end){
//        if (head==end){
//            head.next = null;
//            return head;
//        }
//        ListNode helper = helper(head.next, end);
//        head.next.next = head;
//        head.next = null;
//        return helper;
//    }
}
