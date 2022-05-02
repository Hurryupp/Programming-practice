package lcTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author lenovo
 */
public class qinsFomer {
    static int maxx ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
            dp[i] = nums[i][0];
        }
        maxx = nums[0][0];
        System.out.println(rob(nums, dp));
    }
    public static int rob(int[][] nums,int[] dp) {
        if (nums[0].length == 1) return nums[0][0];
        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (j + nums[j][1] <= i - 1) {
                    dp[i] = Math.max(dp[j]+nums[i][0],dp[i]);
                    maxx = Math.max(dp[i],maxx);
                }
            }
        }
        return maxx;
    }

}
