package MiroSoftTest;

import org.junit.Test;

public class lianbiaohe {
    @Test
    public void test(){
        //第一组
        ListNode listNode1 = new ListNode(7,null);
        ListNode listNode2 = new ListNode(4,listNode1);

        ListNode listNode6 = new ListNode(9,null);
        ListNode listNode3 = new ListNode(9,listNode6);
        ListNode listNode4 = new ListNode(6,listNode3);
        ListNode listNode5 = new ListNode(3,listNode4);

        ListNode helper = helper(listNode5, listNode2);
        while (helper != null) {
            System.out.println(helper.val);
            helper = helper.next;
        }

    }

    public ListNode helper(ListNode l2,ListNode l1){
        int flag = 0;
        int jin = 0;
        int val = 0;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (l1 != null && l2 != null) {
            val = l1.val + l2.val;
            jin = val/10;
            val = val%10;
            l1.val = val;
            l2.val = val;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            //无进位
            if (jin==0){
                return l1;
            }
            //有进位
            ListNode t1 = h1;
            while (t1.next!=null){
                t1 = t1.next;
            }
            t1.next = new ListNode(jin);
            return h1;
        }
        else if (l1 == null){
            flag =2;
            if (jin==0){
                return h2;
            }
            else {
                //有进位
                ListNode pre = l2;
                while (l2!=null){
                    val = jin + l2.val;
                    jin = val/10;
                    val = val%10;
                    l2.val = val;
                    pre = l2;
                    l2 = l2.next;
                }
                if (jin!=0){
                    pre.next = new ListNode(jin);
                }
                return h2;
            }
        } else if (l2 == null) {
            if (jin==0){
                return h1;
            }
            else {
                //有进位
                ListNode pre = l1;
                while (l1!=null){
                    val = jin + l1.val;
                    jin = val/10;
                    val = val%10;
                    l1.val = val;
                    pre = l1;
                    l1 = l1.next;
                }
                if (jin!=0){
                    pre.next = new ListNode(jin);
                }
                return h1;
            }
        }
        if (flag == 2) {
            return h2;
        }
        else {
            return h1;
        }
    }
}
