package lcTest;

import org.junit.Test;

// 力扣目标和
public class lc494 {
    @Test
    public void test(){
        int[] nums = {1};
        int target = 2;
        System.out.println(findTargetSumWays(nums, target));
    }
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        int wight = (sum - target) / 2;
        helper(nums,wight,0,0);
        return count;
    }
    int count = 0;
    public void helper(int[] nums,int wight,int p,int bao){
        if (p==nums.length) {
            if (wight == bao) {
                count++;
            }
            return;
        }
        //不选
        helper(nums,wight,p+1,bao);
        //选
        helper(nums,wight,p+1,bao+nums[p]);
    }
}
