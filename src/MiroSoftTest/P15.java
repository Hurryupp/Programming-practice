package MiroSoftTest;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author lenovo
 * 数组内小于target的最大元素。
 */
public class P15 {
    @Test
    public void test(){
        int[] nums = {3};
        int target = 4;

        int i = find(nums, target);
        System.out.println(i);
    }
    public int  find(int[] nums,int target){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target && nums[i] > max) {
                max = nums[i];
            }
        }
        if (max == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return max;
        }
    }
}
