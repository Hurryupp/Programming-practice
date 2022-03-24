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
    private int[] temp;
    public void Sort(int[] nums,int low,int high){
        //拆分函数
        if (low >=high){
            return;
        }
        int mid = (low+high)/2;
        Sort(nums,low,mid); //递归调用左半边
        Sort(nums,mid+1,high); //递归调用右半边
        Merge(nums,low,mid+1,high+1); //左右两部分合起来
    }
    public void Merge(int[] nums,int low,int mid,int high){
        //合并函数
        for (int i = low;i<high;i++){
            temp[i] = nums[i];
        }
        //双指针合并
        int start1 = low;
        int start2 = mid;
        for (int i = low; i<high;i++){
            if (start1 == mid) {
                nums[i] = temp[start2++];
            } else if (start2 == high) {
                nums[i] = temp[start1++];
            }else if (temp[start1]>temp[start2]){
                nums[i] = temp[start2++];
            }
            else {
                nums[i] = temp[start1++];
            }
        }
    }
}
