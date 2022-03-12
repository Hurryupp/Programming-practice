package MiroSoftTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class rudu {
    @Test
    public void test(){
        int[] v ={1,1,5};
        int[] a ={0,1};
        int[] b ={2,2};
        System.out.println(solution(v, a, b));
    }
    public int solution(int[] V,int[] A,int[] B){
        int[] map = new int[V.length];
        for (int i = 0; i < B.length; i++) {
            map[B[i]] += 1;
        }
        used = new boolean[V.length];
        helper(map,0,V,A,B,0,used);
        return max;
    }
    int max = 0;
    boolean[] used ;
    public void helper(int[] map,int k,int[] v,int[] a,int[] b,int sum,boolean[] used){
        if (k==2){
            max = Math.max(max,sum);
            System.out.println("获得值为："+sum);
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (v[i]>0&&used[i]==false&&map[i]==0){
                used[i] = true;
                sum += v[i];
                System.out.println("选择："+i+" 价值："+v[i]+ " K: "+k);
                //更新入度map
                for (int j = 0; j < a.length; j++) {
                    if (a[j]==i){
                        map[b[j]] -= 1;
                    }
                }

//                System.out.println("入度表");
//                for (int l = 0; l < map.length; l++) {
//                    System.out.print(map[l]+" ");
//                }
//                System.out.println();


                //递归下一层
                helper(map,k+1,v,a,b,sum,used);
                //回退
                for (int j = 0; j < a.length; j++) {
                    if (a[j]==i){
                        map[b[j]] += 1;
                    }
                }
//                System.out.println("回退入度表");
//                for (int l = 0; l < map.length; l++) {
//                    System.out.print(map[l]+" ");
//                }
//                System.out.println();

                //更新入度
                used[i] = false;
                sum -= v[i];
            }
            else {
                System.out.println("不选");
                helper(map,k+1,v,a,b,sum,used);
            }
        }
    }
}
