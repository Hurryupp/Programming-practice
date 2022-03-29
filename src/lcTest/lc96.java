package lcTest;

import org.junit.Test;
//不同的二叉搜索树
public class lc96 {
    @Test
    public void test(){
        System.out.println(numTrees(3));
    }
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;
        int res =0;
        for (int i = 3; i <= n ; i++) {
            res = 0;
            for (int j = 0; j < i; j++) {
                res += ans[j]*ans[i-j-1];
            }
            ans[i] = res;
        }
        return res;
    }
}
