package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 力扣第47题 全排列2
 * 类型：回溯+去重
 * 题目链接：
 * https://leetcode-cn.com/problems/permutations-ii/
 * 讲解：
 * https://programmercarl.com/0047.%E5%85%A8%E6%8E%92%E5%88%97II.html#_47-%E5%85%A8%E6%8E%92%E5%88%97-ii
 */
public class lc47 {
    @Test
    public void test(){
        int[] nums = {1, 2, 1};
        permuteUnique(nums);
        System.out.println(ans.toString());
    }
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> res = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length==0){
            return ans;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        permuteUniqueHelper(nums);
        return ans;
    }
    public void permuteUniqueHelper(int[] nums){
        if (nums.length == res.size()){
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if (!used[i]){
                used[i] = true;
                res.add(nums[i]);
                permuteUniqueHelper(nums);
                used[i] = false;
                res.removeLast();
            }
        }
    }
}
