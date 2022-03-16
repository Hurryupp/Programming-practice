package lcTest;

import org.junit.Test;

//编辑距离
public class lc72 {
    @Test
    public void test(){

    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //判空
        if (len1 == 0 || len2 == 0) {
            return len1+len2;
        }
        //初始化，多开一个空间
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2+1; i++) {
            dp[0][i] = i;
        }

        //循环
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int down = dp[i-1][j]+1; //下面的加一步
                int left = dp[i][j-1]+1; //左边的加一步
                int left_down = dp[i-1][j-1];   //左下角的不加
                if (word1.charAt(i-1)!=word2.charAt(j-1)){
                    //两个字符不相等，才需要左下角的加一
                    left_down++;
                }
                //找一个最小的加上步骤
                dp[i][j] = Math.min(left_down,Math.min(left,down));
            }
        }
        return dp[len1][len2];
    }
}
