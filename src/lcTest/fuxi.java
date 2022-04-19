package lcTest;

import org.junit.Test;

import java.util.*;

public class fuxi {
    @Test
    public void test(){
        int[] nums = {1,1,2};
        permuteUnique(nums);
        System.out.println(ans.toString());
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums);
        return ans;
    }
    boolean[] used;
    public void helper(int[] nums){
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false ) {
                if (i!=0 && nums[i]==nums[i-1] && used[i-1]==false){
                    continue;
                }
                used[i] = true;
                res.add(nums[i]);
                helper(nums);
                res.removeLast();
                used[i] = false;
            }
        }
    }

}
