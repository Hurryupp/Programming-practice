package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 相交链表
 */
public class lc160 {
    @Test
    public void test(){

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode anode = headA;
        ListNode bnode = headB;
        int count = 0;
        while (anode!=bnode){
            count++;
            if (count>60000)
                break;
            if (anode==null){
                anode=headB;
            }
            else {
                anode = anode.next;
            }
            if (bnode==null){
                bnode=headA;
            }
            else {
                bnode = bnode.next;
            }
        }
        if (anode==bnode)
            return anode;
        else
            return null;
    }
}
