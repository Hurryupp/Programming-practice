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
        int[] nums = {5, 3, 1, 4, 2, 7, 6};
        int[] ints = Sort(nums);
        System.out.println(Arrays.toString(ints));
    }
    int[] temp;
    public int[] Sort(int[] nums){
        temp = new int[nums.length];
        //递归调用左子树
        Sort(nums)
    }
    public void  Merge(int nums){

    }
}
