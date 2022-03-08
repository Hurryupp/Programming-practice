package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 组合总和3
 */
public class lc216 {
    @Test
    public void test(){
        combinationSum3(3,7);
        System.out.println(ans.toString());
    }
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,n,1,0);
        return ans;
    }
    public void helper(int k,int n,int start,int sum){
        //递归结束条件
        if (res.size() == k && n==sum) {
            ans.add(new ArrayList<>(res));
            return;
        }
        // 每个节点该做的事情
        for (int i = start; i < 10&&i<n; i++) {
            if (n-sum-i>=0){
                res.add(i);
                helper(k,n,i+1,sum+i);
                res.removeLast();
            }
        }
    }
}
