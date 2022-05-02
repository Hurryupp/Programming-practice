package lcTest;

import org.junit.Test;
import sun.plugin2.liveconnect.ArgumentHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 子集2
 */
public class lc90 {
    @Test
    public void test(){
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
        System.out.println(ans);
    }
    LinkedList<Integer> res = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums,0);
        return ans;
    }
    public void helper(int[] nums,int p){
        ans.add(new ArrayList<>(res));
        for (int i = p; i < nums.length; i++) {
            if (i != p && nums[i]==nums[i-1]) {
                continue;
            }
            res.add(nums[i]);
            helper(nums,i+1);
            res.removeLast();
        }
    }
}
