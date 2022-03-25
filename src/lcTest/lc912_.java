package lcTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author lenovo
 * 排序数组，使用快排来写
 */
public class lc912_ {
    @Test
    public void test(){
        int[] nums = { 1, 8, 4, 2,  6};
        shuffle(nums); //混乱数组
        Sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public void Sort(int[] nums,int low,int high){
        if (low>=high){
            return;
        }
        int p = partition(nums, low, high);//获取位置
        Sort(nums,low,p);
        Sort(nums,p+1,high);
    }
    public int partition(int[] nums,int low,int high){
        int p = low;
        for (int i=low+1;i<=high;i++){
            if ((p<i && nums[p]>nums[i])||(p>i && nums[p]<nums[i])){
                swap(nums,p,i);
                int tmp = i;
                i = p;
                p = tmp;
            }
        }
        return p;
    }
    public void swap(int[] nums,int p1,int p2){
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
    public void shuffle(int[] nums){
        Random random = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int r = i+random.nextInt(n-i);
            swap(nums,i,r);
        }
    }
}
