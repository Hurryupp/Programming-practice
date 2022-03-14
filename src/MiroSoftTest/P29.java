package MiroSoftTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author lenovo
 * 链表排序
 */
public class P29 {
    @Test
    public void test(){
        ListNode listNode1 = new ListNode(3, null);
        ListNode listNode2 = new ListNode(1, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode node = sortList(listNode4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    //最小堆  实现方法  时间复杂度O(logn) 空间复杂度O(n)
//    public ListNode sortList(ListNode head) {
//        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//        while (head != null) {
//            heap.offer(head);
//            head = head.next;
//        }
//
//        ListNode h1 = heap.poll();
//        ListNode cur = h1;
//        ListNode nxt = cur;
//        while (!heap.isEmpty()){
//            nxt = heap.remove();
//            nxt.next = null;
//            cur.next = nxt;
//            cur = cur.next;
//        }
//        return h1;
//    }

    //归并  自顶向上，使用递归的方法 时间复杂度O(nlogn) 空间复杂度O(logn)
//    public ListNode sortList(ListNode head) {
//        //节点已经分成一个一个的
//        if (head == null || head.next == null) {
//            return head;
//        }
//        //分割节点
//        ListNode newhead = splitListNode(head);
//        ListNode listNode1 = sortList(head);
//        ListNode listNode2 = sortList(newhead);
//        //合并节点
//        ListNode mergenode = merge(listNode1, listNode2);
//        return mergenode;
//    }
//    //分割函数
//    public ListNode splitListNode(ListNode head){
//        ListNode slow = head;   //充作newHead
//        ListNode pre = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            pre = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        pre.next = null;
//        return slow;
//    }
//    //合并两个有序链表
//    public ListNode merge(ListNode h1, ListNode h2){
//        if (h1 == null && h2 == null) {
//            return null;
//        } else if (h1 == null) {
//            return h2;
//        } else if (h2 == null) {
//            return h1;
//        }else {
//            if (h1.val < h2.val) {
//                h1.next = merge(h1.next,h2);
//                return h1;
//            }
//            else {
//                h2.next = merge(h1,h2.next);
//                return h2;
//            }
//        }
//    }

    //使用Arrays函数，Arrays函数底层使用的是优化过的归并算法,空间复杂度依旧是O(n)
//    public ListNode sortList(ListNode head) {
//        ListNode tmp = head;
//        ListNode tmp1 = head;
//        int count = 0;
//        while (tmp!=null){
//            count++;
//            tmp = tmp.next;
//        }
//        ListNode[] nodes = new ListNode[count];
//        for (int i = 0; i < nodes.length; i++) {
//            nodes[i] = tmp1;
//            tmp1 = tmp1.next;
//        }
//        Arrays.sort(nodes, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//        for (int i = 0; i < nodes.length; i++) {
//            if (i < nodes.length - 1) {
//                nodes[i].next = nodes[i+1];
//            }
//            else {
//                nodes[i].next = null;
//            }
//        }
//        return nodes[0];
//    }

    //使用自底向上的归并，时间复杂度O(logn)，空间复杂度为O(1)   仔细看要掌握
        public ListNode sortList(ListNode head) {
            if(head==null||head.next==null) return head;
            int n=0;
            //设置前面的节点
            ListNode dummy = new ListNode();
            dummy.next=head;
            ListNode cur = head;
            while(cur!=null)
            {
                cur=cur.next;
                n++;
            }
            int len=1;
            while(len<n)
            {
                ListNode beforeHead=dummy;
                while(beforeHead!=null)
                {
                    ListNode mid = beforeHead.next;
                    for(int i=0;i<len;i++)
                    {
                        if(mid!=null) mid=mid.next;
                        else break;
                    }
                    ListNode afterTail=mid;
                    for(int i=0;i<len;i++)
                    {
                        if(afterTail!=null) afterTail=afterTail.next;
                        else break;
                    }
                    Merge(beforeHead,mid,afterTail);
                    for(int i=0;i<len*2;i++)
                    {
                        if(beforeHead!=null)
                            beforeHead=beforeHead.next;
                        else break;
                    }
                }
                len*=2;
            }
            return dummy.next;
        }
        void Merge(ListNode beforeHead, ListNode mid, ListNode afterTail)
        {
            ListNode cur = beforeHead;
            ListNode head1 = cur.next;
            ListNode head2 = mid;
            while(head1!=mid&&head2!=afterTail)
            {
                if(head1.val<=head2.val)
                {
                    cur.next=head1;
                    head1=head1.next;
                }
                else
                {
                    cur.next=head2;
                    head2=head2.next;
                }
                cur=cur.next;
            }
            while(head1!=mid)
            {
                cur.next=head1;
                head1=head1.next;
                cur=cur.next;
            }
            while(head2!=afterTail)
            {
                cur.next=head2;
                head2=head2.next;
                cur=cur.next;
            }
            cur.next=afterTail;
        }

}
