package lcTest;

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayDeque;

/**
 * @author lenovo
 * 删除链表的倒数第N个节点
 */
public class lc19 {
    @Test
    public void test(){

    }

//    快慢指针
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode ahead = new ListNode(0);
//        ahead.next = head;
//        ListNode tmp = ahead;
//        ListNode cur = ahead;
//        ListNode last = ahead;
//        while (n>0){
//            cur = cur.next;
//            n--;
//        }
//        while (cur!=null){
//            last = tmp;
//            tmp = tmp.next;
//            cur = cur.next;
//        }
//        last.next = tmp.next;
//        return ahead.next;
//    }

    //递归的解法，重点掌握
//    private int count ;
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head==null){
//            count = 0;
//            return null;
//        }
//        ListNode listNode = removeNthFromEnd(head.next, n);
//        count++;
//        if (count==n){
//            return listNode;
//        }
//        else {
//            head.next = listNode;
//            return head;
//        }
//    }

//    使用栈来解决
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ArrayDeque<ListNode> listNodes = new ArrayDeque<>();
//        while (head!=null){
//            listNodes.addLast(head);
//            head = head.next;
//        }
//        int count = 0;
//        ListNode ahead = null;
//        while (!listNodes.isEmpty()){
//            System.out.println(listNodes.toString());
//            ListNode listNode = listNodes.removeLast();
//            count++;
//            if (count!=n){
//                listNode.next = ahead;
//                ahead = listNode;
//            }
//        }
//        return ahead;
//    }
}
