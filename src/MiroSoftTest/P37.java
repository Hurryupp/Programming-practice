package MiroSoftTest;

import org.junit.Test;

public class P37 {
    @Test
    public void test(){
        int[] nums = {0,0,0,0,0,0,1,0,1,1,0,1,1,1,0,0,0,0};
        boolean da = da(nums, 3, 4);
        //System.out.println(da);
    }
    public boolean da(int[] nums,int min,int max){
        int len = nums.length;
        boolean[] arr = new boolean[len];
        arr[0] = true;
        for (int i = 1; i < len; i++) {
            if (nums[i]==1){
                continue;
            }
            boolean flag  =false;
            for (int j = i-max; j < i - min + 1 && j>=0; j++) {
                flag =flag||arr[j];
            }
            flag = flag||arr[i-1];
            arr[i] = flag;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i]+" ");
        }
        return arr[nums.length-1];
    }
}
