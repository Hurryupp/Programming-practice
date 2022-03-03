package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 链表的中间节点
 * 快慢指针
 */
public class lc876 {
    @Test
    public void test(){
        ListNode listNode4 = new ListNode(4,null);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode node = middleNode(listNode1);
        System.out.println(node.val);
    }
    public ListNode middleNode(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
