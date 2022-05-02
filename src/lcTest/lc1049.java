package lcTest;

import org.junit.Test;

public class lc1049 {
    @Test
    public void test(){
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightII(stones));
    }
    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        if (len == 1) {
            return stones[0];
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += stones[i];
        }
        int wight = sum>>1;
        int[] dp = new int[wight+1];
        for (int i = 0; i < len; i++) {
            for (int j = wight; j >= stones[i]; j--) {
                    dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }


        return (sum-2*dp[wight]);
    }
}
