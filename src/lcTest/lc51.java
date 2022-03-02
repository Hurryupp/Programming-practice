package lcTest;


import org.junit.Test;

import java.util.*;

/**
 * @author lenovo
 * 力扣 51 N皇后问题
 * 回溯
 */
public class lc51 {
    @Test
    public void test(){
        int n = 4;
        List<List<String>> lists = solveNQueens(n);
        System.out.println("ans："+lists.toString());
    }
    int[][] loc;
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        loc = new int[n][n];
        helper(0,n);
        return ans;
    }
    public void helper(int m,int n){
        if (m>=n){
            ans.add(new ArrayList<>(res));
            return ;
        }
        for (int i = 0; i < n; i++) {
            //用过的排除掉
            if (isValid(loc,m,i)){
                //标记上
                loc[m][i] = 1;

                String str = new String();
                for (int j = 0; j < n; j++) {
                    if (loc[m][j]==1){
                        str = str+"Q";
                    }
                    else {
                        str = str+".";
                    }
                }
                res.add(str);
                helper(m+1,n);
                //取消标记
                loc[m][i] = 0;
                res.removeLast();
            }
        }
    }
    public boolean isValid(int[][] loc,int row,int col){
        int len = loc.length;
        //检查列
        for (int i = 0; i < row; i++) {
            if (loc[i][col]==1)
                return false;
        }
        //检查左对角
        for(int i = row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (loc[i][j]==1)
                return false;
        }
        //检查右对角
        for(int i = row-1,j=col+1;i>=0&&j<len;i--,j++){
            if (loc[i][j]==1)
                return false;
        }
        return true;
    }
}
