package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 力扣 23 合并K个有序链表
 * 分治+拉链
 */
public class lc23 {
    @Test
    public void test(){

    }
    //合并K个链表
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        if (lists.length==1) return lists[0];
        if (lists.length==2) return merge2Lists(lists[0],lists[1]);

        //把多个链表分两部分
        int len = lists.length;
        int mid = (int)len/2;
        ListNode[] L = new ListNode[mid];
        ListNode[] R = new ListNode[len - mid];
        for (int i = 0; i < mid; i++) {
            L[i] = lists[i];
        }
        for (int i = mid; i < len; i++) {
            R[i-mid] = lists[i];
        }
        //重要：通过mergeK分成多个，然后通过merge2合起来
        return merge2Lists(mergeKLists(L),mergeKLists(R));
    }
    //合并两个链表
    public ListNode merge2Lists(ListNode node1,ListNode node2){
        if (node1==null&&node2==null) return null;
        else if (node1==null) return node2;
        else if (node2==null) return node1;
        if (node1.val<=node2.val){
            ListNode listNode = merge2Lists(node1.next, node2);
            node1.next = listNode;
            return node1;
        }
        else {
            ListNode listNode = merge2Lists(node1, node2.next);
            node2.next = listNode;
            return node2;
        }
    }
}
