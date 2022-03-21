package lcTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lenovo
 * 数组中得第K大元素
 */
public class lc215 {
    @Test
    public void test(){

    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> myqueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (myqueue.size() < k && !myqueue.contains(nums[i])) {
                myqueue.add(nums[i]);
            }
            else {

            }
        }
        //while ()

        return 1;
    }
}
