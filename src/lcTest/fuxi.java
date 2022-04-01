package lcTest;

import org.junit.Test;

import java.util.*;

public class fuxi {
    @Test
    public void test(){
        int[] ints = {10,1,2,7,6,1,5};
        combinationSum2(ints,8);
        System.out.println(ans);
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();
    //HashSet<LinkedList<Integer>> set =  new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,0);
        return ans;
    }
    public void helper(int[] candidates,int target,int sum,int p){
        if (sum == target) {
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = p; i <candidates.length; i++) {
            if (sum+candidates[i]<=target&&(i==0||(i!=p&&candidates[i]!=candidates[i-1]))){
                res.add(candidates[i]);
                helper(candidates,target,sum+candidates[i],i+1);
                res.removeLast();
            }
        }
    }
}
