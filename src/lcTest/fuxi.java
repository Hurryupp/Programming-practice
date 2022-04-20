package lcTest;

import org.junit.Test;

import java.util.*;

public class fuxi {
    @Test
    public void test(){
        solveNQueens(4);
        System.out.println(ans);
    }
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> res = new LinkedList<>();
    boolean[][] used;   //记录是否放置了皇后
    public List<List<String>> solveNQueens(int n) {
        used = new boolean[n][n];
        helper(n,0);
        return ans;
    }
    public void helper(int n,int p){
        //如果已经遍历完所有格子了
        if (p == n) {
            ans.add(new ArrayList<>(res));
            return;
        }
        //从0开始横向遍历
        for (int i = 0; i < n; i++) {
            //验证i位置可不可以放下皇后
            if (isValid(p,i,n)){
                //可以放下皇后
                //步骤加入res
                StringBuffer buffer = new StringBuffer();
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        buffer.append("Q");
                    }
                    else{
                        buffer.append(".");
                    }
                }
                res.add(new String(buffer));
                used[p][i] = true;
                //递归下一行
                helper(n,p+1);
                //回溯
                res.removeLast();
                used[p][i] = false;
            }
        }
    }
    public boolean isValid(int m,int n,int len){
        //验证同列的
        for (int i = 0; i < m; i++) {
            if (used[i][n]){
                return false;
            }
        }
        //验证左上角的
        for (int i = m-1,j = n-1; i >= 0 && j >=0; i--,j--) {
            if (used[i][j]){
                return false;
            }
        }
        //验证右上角的
        for (int i = m-1,j = n+1; i >= 0&& j<len; i--,j++) {
            if (used[i][j]){
                return false;
            }
        }
        return true;
    }
}
