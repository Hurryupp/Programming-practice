package MiroSoftTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * 字典序排数
 */
public class P2 {
    //解法1：
    @Test
//    public List<Integer> lexicalOrder(int n){
//        List<Integer> ans = new ArrayList<>();
//        helper(0,1,n,ans);
//        return ans;
//    }
//    //base 是除了个位以外的值,start是下一层的个数
//    public void helper(int base,int start,int n,List<Integer> ans ){
//        if(base>n){
//            return ;
//        }
//        for(int i = start;i<10;i++){
//            // num是当前值
//            int num = base+i;
//            if(num<= n){
//                ans.add(num);
//                helper(num*10,0,n,ans);
//            }
//        }
//    }

    //解法2：迭代方法，性能更优，空间复杂度为O(1)
    public List<Integer> lexicalOrder(int n){
        ArrayList<Integer> list = new ArrayList<>();
        int num = 1;
        while (list.size() < n) {
            while (num <= n) {
                list.add(num);
                //遍历字节点
                num *= 10;
            }
            while (num % 10 == 9 || num > n) {
                num /= 10;
            }
            num++;
        }
        return list;
    }
}
