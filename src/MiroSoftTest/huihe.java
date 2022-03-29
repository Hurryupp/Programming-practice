package MiroSoftTest;

import java.util.Arrays;
import java.util.Scanner;

public class huihe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        int p = helper(nums);
        System.out.println(Math.abs((nums[p] - nums[0]) - (nums[len - 1] - nums[p])));
    }
    public static int helper(int[] nums){
        int len = nums.length;
        if (len==2){
            return 0;
        }
        int target = (nums[0]+nums[len-1])/2;
        int low=0,high=len-1;
        int mid = -1;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid] == target)
                return mid; //找到了
            else if(target > nums[mid])
                low=mid+1;
            else
                high=mid-1;
        }
        if(nums[mid]>target) //没找到，找一个离得最近的
        {
            if (Math.abs(nums[mid]-target) >Math.abs( target-nums[mid-1])){
                return mid-1;
            }
            else
                return mid;
        }
        else{
            if (Math.abs(nums[mid]-target )> Math.abs(nums[mid+1]-target)){
                return mid+1;
            }
            else
                return mid;
        }
    }


    /*
    public static int helper(int[] nums){
        int len = nums.length;
        if (len==2){
            return nums[1]-nums[0];
        }
        int[] dis = new int[len];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            dis[i] = Math.abs((nums[i]-nums[0])-(nums[len-1]-nums[i]));
            min = Math.min(min,dis[i]);
        }
        return min;
    }
    public static int helper2(int[] nums){
        int len = nums.length;
        if (len==2){
            return nums[1]-nums[0];
        }
        int mid = (nums[0]+nums[len-1])/2;
        int p = 0;
        int value =Math.abs(mid-nums[0]);
        for (int i = 0; i < len; i++) {
            int tmp = Math.abs(mid - nums[i]);
            if (tmp < value) {
                value = tmp;
                p = i;
            }
        }
        return Math.abs((nums[p]-nums[0])-(nums[len-1]-nums[p]));
    }*/

}
