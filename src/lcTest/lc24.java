package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 反转链表
 * 迭代和递归两种实现方法
 */
public class lc24 {
    @Test
    public void test(){
        ListNode listNode8 = new ListNode(8,null);
        ListNode listNode7 = new ListNode(7,listNode8);
        ListNode listNode6 = new ListNode(6,listNode7);
        ListNode listNode5 = new ListNode(5,listNode6);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        ListNode h = listNode1;
        ListNode h1 = reverseDiGui(h);
        ListNode h3 = h1;
        while (h1!=null){
            System.out.println(h1.val);
            h1 = h1.next;
        }
        System.out.println("*****************");
        ListNode h2 = reverseDieDai(h3);
        while (h2!=null){
            System.out.println(h2.val);
            h2 = h2.next;
        }
    }
    // 递归的方法
    public ListNode reverseDiGui(ListNode head){
        if (head == null || head.next==null) {
            return head;
        }
        ListNode node = reverseDiGui(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    // 迭代的方法
    public ListNode  reverseDieDai(ListNode head){
        if (head==null){
            return null;
        }
        ListNode pre,cur,nxt;
        pre = null; cur = head; nxt = head;
        while (cur!=null){
            // 记录后继节点，并且预防空指针异常
            nxt = cur.next;
            // 反转链表
            cur.next = pre;
            // 更新节点
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
