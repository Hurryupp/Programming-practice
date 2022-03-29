package MiroSoftTest;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public int findMax(int[] array, int len){
        int n=7; //倍数
        int sum=0; //总数
        int flag; //下标标记
        //首先将数组从小到大排序
        Arrays.sort(array);
        //计算总和
        for(int i=0;i<len;++i){
            sum+=array[i];
        }
        //判断是否为n的倍数
        for(int i=0;i < len ;++i){
            if(0 == sum%n){
                flag=i; //如果是，就记下数组下标，退出循环
                break;
            }
            else
                sum-=array[i]; //如果不是n的倍数，则减去最小的一个数，再进行循环判断
        }
        if(0==sum)
            return 0;
        else
            return sum;

    }

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sca.nextInt();
        }
        System.out.println(new Main().findMax(arr, n));
    }
}
