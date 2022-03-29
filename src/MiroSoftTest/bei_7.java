package MiroSoftTest;

import java.util.Scanner;

public class bei_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        max = 0;
        helper(nums,0,0);
        System.out.println(max);
    }
    static int max ;
    public static void helper(int[] nums,int p,int res){
        if (p==nums.length){
            if (res % 7 == 0) {
                max = Math.max(max,res);
            }
            return;
        }
        //剪枝

        //选
        helper(nums,p+1,res+nums[p]);
        //不选
        helper(nums,p+1,res);
    }
}
