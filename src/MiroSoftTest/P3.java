package MiroSoftTest;

/**
 * @author lenovo
 * 两两交换链表中的节点
 */
public class P3 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        //寻找末尾
        ListNode  end = head;
        for (int i = 0; i < 2; i++) {
            if (end==null){
                return head;
            }
            end = end.next;
        }
        //反转前两个节点
        ListNode headn = head.next;
        headn.next = head;
        //递归调用，把子链表反转
        ListNode node1 = swapPairs(end);
        head.next = node1;
        return headn;
    }
}
