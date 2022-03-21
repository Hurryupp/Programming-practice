package lcTest;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lenovo
 * 排序数组
 */
public class lc912 {
    @Test
    public void test(){
        int[] nums = {5, 2, 3, 1};
        int[] array = sortArray(nums);
        System.out.println(Arrays.toString(array));
    }
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        Sort(nums,0,nums.length-1);
        return nums;
    }
    int[] temp;
    public void Sort(int[] nums,int low,int high){
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        Sort(nums,low,mid); //左边排序
        Sort(nums,mid+1,high);  //右边排序
        Merge(nums,low,mid,high);
    }
    //合并数组,并将数组排序
    public void Merge(int[] nums,int low,int mid,int high){
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        //双指针合并
        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i == mid+1){
                nums[k] = temp[j++];
            } else if (j == high) {
                nums[k] = temp[i++];
            }else if (temp[i]>temp[j]){
                nums[k] = nums[j++];
            }
            else{
                nums[k] = nums[i++];
            }
        }
    }

}
