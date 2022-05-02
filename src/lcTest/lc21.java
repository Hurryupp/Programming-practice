package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 力扣 21 合并两个有序链表
 * 拉链法
 */
public class lc21 {
    @Test
    public void test(){

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        new StringBuffer()
        //递归结束条件
        if (list1==null&&list2==null) return null;
        else if (list1==null) return list2;
        else if (list2==null) return list1;

        //递归调用
        if (list1.val<=list2.val){
            ListNode R = mergeTwoLists(list1.next, list2);
            list1.next = R;
            return list1;
        }
        else {
            ListNode L = mergeTwoLists(list1, list2.next);
            list2.next = L;
            return list2;
        }
    }

}
