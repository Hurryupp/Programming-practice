package lcTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


// K个一组翻转链表
// 迭代的方式翻转链表
// 重点部分：把链表迭代搞好
public class lc25 {
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
        ListNode h1 = reverseKGroup(h, 3);
        //ListNode h1 = reverse(h, listNode5);
        while (h1!=null){
            System.out.println(h1.val);
            h1 = h1.next;
        }

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null) return null;
        ListNode a,b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b==null) return head;
            b = b.next;
        }
        ListNode newhead = reverse(a, b);
        a.next = reverseKGroup(b,k); // 递归翻转后面的链表
        return newhead;
    }
    public ListNode reverse(ListNode head,ListNode b){
        ListNode pre,cur,nxt; //前驱、目前节点、后继
        pre = null; cur = head; nxt = head;
        while (cur!=b){
            nxt = cur.next; // 防止出现空指针异常
            cur.next = pre; // 翻转链表
            // 更新指针
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
