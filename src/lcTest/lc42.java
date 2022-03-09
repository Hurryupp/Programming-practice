package lcTest;

import org.junit.Test;

public class lc42 {
    @Test
    public void test(){
        int[] nums = {-2};
        int maxSubArray = maxSubArray(nums);
        System.out.println(maxSubArray);
    }
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int tmp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp+nums[i],nums[i]);
            max = Math.max(max,tmp);
        }
        return max;
    }
}
