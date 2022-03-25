package lcTest;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lenovo
 * 计算右侧小于当前元素的个数
 */
public class lc315 {
    @Test
    public void test(){
        int[] nums = {5, 3, 2, 7, 6};
        temp = new int[nums.length];
        Sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    int[] temp;
    public List<Integer> countSmaller(int[] nums) {



        return new ArrayList<Integer>();
    }
    public void Sort(int[] nums,int low,int high){
        if (low >= high) {
            return;
        }
        //寻找中间元素
        int mid = (low+high)/2;
        //递归左子树
        Sort(nums,low,mid);
        Sort(nums,mid+1,high);
        Merge(nums,low,mid+1,high);
    }
    public void Merge(int[] nums,int low,int mid,int high){
        for (int i = low; i <=high; i++) {
            temp[i] = nums[i];
        }
        int start1 = low;
        int start2 = mid;
        for (int i = low; i <=high; i++) {
            if (start1==mid){
                //左边遍历完了
                nums[i] = temp[start2++];
            } else if (start2 == high + 1) {
                //右边遍历完了
                nums[i] = temp[start1++];
            }
            else if (temp[start1]>temp[start2]){
                nums[i] = temp[start2++];
            }
            else {
                nums[i] = temp[start1++];
            }
        }
    }
}
