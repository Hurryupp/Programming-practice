package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 环形链表2
 */
public class lc142 {
    @Test
    public void test(){

    }
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow)
                break;
        }
        //无环
        if (fast==null||fast.next==null){
            return null;
        }
        //有环
        while (head!=slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
