package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//全排列
public class lc46 {
    @Test
    public void test(){
        int[] ints = {1, 2, 3};
        List<List<Integer>> permute = permute(ints);
        System.out.println(permute.toString());
    }
    List<List<Integer>> ans = new ArrayList<>(); //保存所有符合条件的集合
    LinkedList<Integer> res = new LinkedList<>(); //保存符合条件的数据
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length==0)
            return ans;
        boolean[] used = new boolean[nums.length]; // 状态数组,保存那个已经被遍历过
        subper(nums,used);
        return ans;
    }
    public void subper(int[] nums,boolean[] used){
        if (res.size()==nums.length){   //加入记录
            ans.add(new ArrayList<>(res));
            return ;
        }
        for (int i = 0; i < nums.length; i++) { //重点部分
            if (used[i]){ //被使用过就不考虑了
                continue;
            }
            //未被使用过
            used[i] = true;     //设置为被使用
            res.add(nums[i]);   //加入结果集
            subper(nums,used);  //递归，把剩下的放入
            used[i] = false;    //回溯，把自己设为没被使用过
            res.removeLast();   //回溯，把自己移除
        }
    }
}
