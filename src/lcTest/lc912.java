package lcTest;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lenovo
 * 排序数组,归并排序重点掌握
 */
public class lc912 {
    @Test
    public void test(){
        int[] nums = {5, 3, 1, 4, 2, 7, 6};
        temp = new int[nums.length];
        Sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    int[] temp; //辅助数组
    public void Sort(int[] nums,int low,int high){
        if (low >= high) {
            return;
        }
        int mid = (low+high)/2;
        //递归调用左子树
        Sort(nums,low,mid);
        Sort(nums,mid+1,high);
        Merge(nums,low,mid+1,high);
    }
    public void  Merge(int[] nums,int low ,int mid , int high){
        for (int i = low;i<=high;i++){
            temp[i] = nums[i];
        }
        int start1 = low; //左边的指针
        int start2 = mid; //右边的指针
        for (int i = low; i <= high; i++) {
            if (start1 == mid) {
                nums[i] = temp[start2++];
            } else if (start2 == high+1) {
                nums[i] = temp[start1++];
            }else if (temp[start1]>temp[start2]){
                nums[i] = temp[start2++];
            }else {
                nums[i] = temp[start1++];
            }
        }
    }
}
