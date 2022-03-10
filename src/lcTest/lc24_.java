package lcTest;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author lenovo
 * 两两交换链表中的节点
 */
public class lc24_ {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(4,node3);
        ListNode node5 = new ListNode(5,node4);
        ListNode node = swapTwo(node5);
        while (node!=null){
            System.out.println(node.val+" ");
            node = node.next;
        }

    }
    public static ListNode swapTwo(ListNode root){
        if (root == null) {
            return null;
        }
        ListNode end = root;
        for (int i = 0; i < 2; i++) {
            if (end==null){
                return root;
            }
            end = end.next;
        }
        ListNode node = reverse(root, end);
        ListNode node1 = swapTwo(end);
        node.next.next = node1;
        return node;
    }
    //返回前两个的反转
    public static ListNode reverse(ListNode head,ListNode end){
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head;
        while (cur != end) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
