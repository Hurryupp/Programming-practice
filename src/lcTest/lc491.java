package lcTest;

import org.junit.Test;

import java.util.*;

/**
 * @author lenovo
 * 力扣491 递增子序列
 */
public class lc491 {
    @Test
    public void test(){

    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums,0);
        return ans;
    }
    public void helper(int[] nums,int p){
        if (res.size() >= 2 ) {
            ans.add(new ArrayList<>(res));
        }
        //在这儿用一个MAP记一下,防止后面再出现相同的数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = p; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],0);
            }
            if (i!=p&&map.get(nums[i])>0){
                continue;
            }
            if(res.size() < 1||nums[i]>=res.get(res.size()-1)){
                map.put(nums[i],map.get(nums[i])+1);
                res.add(nums[i]);
                helper(nums,i+1);
                res.removeLast();
            }
        }
    }
}
