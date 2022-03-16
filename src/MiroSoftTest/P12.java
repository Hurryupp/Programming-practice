package MiroSoftTest;

import org.junit.Test;

public class P12 {
    @Test
    public void test(){
        int maxP = maxP(new int[]{1, 2, 3,-2});
        System.out.println(maxP);
    }
    public int maxP(int[] nums){
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums,0,maxF,0,len);
        System.arraycopy(nums,0,minF,0,len);
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(minF[i-1]*nums[i],nums[i]));
            minF[i] = Math.min(maxF[i-1]*nums[i],Math.min(minF[i-1]*nums[i],nums[i]));
        }
        int ans = maxF[0];
        for (int j = 1; j < len; j++) {
            ans = Math.max(ans,maxF[j]);
        }
        return ans;
    }
}
