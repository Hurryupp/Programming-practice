package lcTest;

import org.junit.Test;

import java.util.*;

public class lc40 {
    @Test
    public void test(){
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2(nums,8);
        System.out.println(ans);
    }
    LinkedList<Integer> res = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,0);
        return ans;
    }
    public void helper(int[] candidates, int target ,int p,int sum){
        if (sum==target){
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = p; i < candidates.length&&sum+candidates[i]<=target; i++) {
            //同层的第一个直接回溯，或者同层的不合前面一样的直接回溯
            if (i==p||(i!=p && candidates[i]!=candidates[i-1])){
                res.add(candidates[i]);
                helper(candidates,target,i+1,sum+candidates[i]);
                res.removeLast();
            }
        }
        //第二种思路
//        if (p<=candidates.length-1){
//            //选他
//            if (sum+candidates[p]<=target){
//                res.add(candidates[p]);
//                helper(candidates,target,p+1,sum+candidates[p]);
//                res.removeLast();
//            }
//            //不选择
//            helper(candidates,target,p+1,sum);
//        }
    }
}
