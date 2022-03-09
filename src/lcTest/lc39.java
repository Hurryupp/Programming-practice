package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 */
public class lc39 {
    @Test
    public void test(){
        int[] a = {2,3,6,7};
        int t = 7;
        combinationSum(a,t);
        System.out.println(ans.toString());
    }
    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> res =  new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,target,0);
        return ans;
    }
    public void helper(int[] candidates,int target,int p){
        //递归终止条件
        if (target==0){
            ans.add(new LinkedList<>(res));
            return;
        }
        if (target < 0) {
            return;
        }
        //该节点该做的事情
        for (int i = p; i < candidates.length; i++) {
            if (target-candidates[i]>=0){
                res.add(candidates[i]);
                //System.out.println(candidates[i]);
                //P的意思是，下一层的选择只能选他自己或者他后面的元素
                helper(candidates,target-candidates[i],i); //递归调用
                res.removeLast();
            }
        }
    }
}
