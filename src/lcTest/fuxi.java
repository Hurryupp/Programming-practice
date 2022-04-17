package lcTest;

import org.junit.Test;

import java.util.*;

public class fuxi {
    @Test
    public void test(){
        int[] nums = {1,2,3};
        subsets(nums);

    }
    LinkedList<Integer> res = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums,0);
        return ans;
    }
    public void helper(int[] nums,int p){
        if (p == nums.length) {
            ans.add(new ArrayList<>(res));
            return;
        }

    }
}
