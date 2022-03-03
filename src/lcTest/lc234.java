package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 判断回文链表
 * 时间复杂度O(n) 空间复杂的O(1)
 * 快慢指针+反转链表
 */
public class lc234 {
    @Test
    public void test(){
        ListNode listNode8 = new ListNode(1,null);
        ListNode listNode7 = new ListNode(2,listNode8);
        ListNode listNode6 = new ListNode(3,listNode7);
        ListNode listNode5 = new ListNode(4,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        isPalindrome(listNode1);

    }
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        ListNode fast,slow,left;
        fast = slow = left = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = reverse(slow);
        ListNode end = right;
        while (left!=right && right!=null){
            if (left.val == right.val) {
                left = left.next;
                right = right.next;
            }
            else {
                break;
            }
        }
        // 是回文
        if (left==right || right==null){
            //反转回来
            reverse(end);
            ListNode h2 = head;
            while (h2!=null){
                System.out.println(h2.val);
                h2 = h2.next;
            }
            return true;
        }
        return false;
    }
    // 将链表反转
    public ListNode reverse(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode pre,cur,nxt;
        pre = null; cur = nxt = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
