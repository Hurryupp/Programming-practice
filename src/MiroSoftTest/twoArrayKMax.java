package MiroSoftTest;

import org.junit.Test;

/**
 * @author lenovo
 * 两个数组里求最大
 */
public class twoArrayKMax {
    @Test
    public void test(){
        int A[] = {11};
        int B[] = {15,14, 13, 12, 10, 8, 7, 4, 2};
        int k =6;
        //int num = maxNum(A, 0, A.length, B, 0, B.length, k);
        //int num2 = maxNum2(A, 0, B, 0, 6);
        int num2 = maxNum2(B,  A,  6);
        System.out.println(num2);

    }
    //重点解决方法
    // m是a的头，n是b的头
//    public int maxNum2(int[] a,int m,int[] b,int n,int k){
//        //保持m小
//        if (a.length-m > b.length-n) {
//            return maxNum2(b,n,a,m,k);
//        }
//        //如果最短的是0，那么返回b中的数据
//        if (a.length == m) {
//            return b[n+k-1];
//        }
//        //终止条件
//        if (k == 1) {
//            return Math.max(a[m],b[n]);
//        }
//        //递归
//        int offset = Math.min(a.length-m,k/2);
//        if (a[m+offset-1]<b[n+offset-1]){
//            return maxNum2(a,m,b,n+offset,k-offset);
//        }
//        else if(a[m+offset-1]>b[n+offset-1]){
//            return maxNum2(a,m+offset,b,n,k-offset);
//        }
//        else {
//            return a[m+offset-1];
//        }
//    }

    //双指针
    public int maxNum2(int[] a,int[] b,int target){
        if (a.length > b.length) {
            return maxNum2(b,a,target);
        }
        int num = 0;
        int aindex = 0;
        int bindex = 0;
        while (aindex < a.length && bindex < b.length) {
            if (num<target){
                if (a[aindex]>b[bindex]){
                    aindex++;
                    num++;
                }
                else {
                    bindex++;
                    num++;
                }
                if (num == target - 1&& aindex<a.length) {
                    return Math.max(a[aindex],b[bindex]);
                }
            }
        }
        return b[bindex+(target-num-1)];
    }

}
