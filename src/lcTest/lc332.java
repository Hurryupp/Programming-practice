package lcTest;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lenovo
 * 力扣 332 零钱兑换
 * 动态规划
 */
public class lc332 {
    @Test
    public void test(){
        int[] coins = new int[]{1,2,5};
        int amount = 83;
        System.out.println(coinChange(coins,amount));
    }
//    下面是自顶而下得解法，使用递归和备忘录
//    int[] memo;
//    public int coinChange(int[] coins, int amount) {
//        memo = new int[amount + 1];
//        Arrays.fill(memo,-666);
//        return dp(coins,amount);
//    }
//    public int dp(int[] coins,int amount){
//        if (amount==0){
//            return 0;
//        }
//        if (amount<0){
//            return -1;
//        }
//        if (memo[amount]!=-666){
//            return memo[amount];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int coin :
//                coins) {
//            int subProblem = dp(coins,amount-coin);
//            if (subProblem==-1) {
//                continue;
//            }
//            res = Math.min(res,subProblem+1);
//        }
//        memo[amount] = (res==Integer.MAX_VALUE)?-1:res;
//        return memo[amount];
//    }
//  下面是自底向上得解法，使用dp数组
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // 初始化dp数组
        Arrays.fill(dp,amount+10);

        dp[0] = 0; // base case
        for (int i = 1; i < amount + 1; i++) {
            for (int coin :
                    coins) {
                if (i>=coin){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return (dp[amount]==amount+10)?-1:dp[amount];
    }
}
