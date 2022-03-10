package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * 字典序排数
 *
 */
public class lc386 {
    @Test
    public void test(){
        List<Integer> ans = lexicalOrder(21);
        System.out.println(ans.toString());
    }
    //递归思路
//    List<Integer> ans =  new ArrayList<Integer>();
//    public List<Integer> lexicalOrder(int n){
//        helper(n,1,0);
//        return ans;
//    }
//    public void helper(int n,int p,int res){
//        if (ans.size() > n) {
//            return;
//        }
//        if (p==1){
//            for (int i = 1; i < 10; i++) {
//                if (res*10+i <= n){
//                    ans.add(res*10+i);
//                    helper(n,p+1,res*10+i);
//                }
//                else{
//                    return;
//                }
//            }
//        }else {
//            for (int i = 0; i < 10; i++) {
//                if (res*10+i <= n){
//                    ans.add(res*10+i);
//                    helper(n,p+1,res*10+i);
//                }
//                else{
//                    return;
//                }
//            }
//        }
//    }

    //迭代思路
    public List<Integer> lexicalOrder(int n){
        ArrayList<Integer> list = new ArrayList<>();
        //初始化
        int num = 1;
        while (list.size() < n){
            while (num <= n) {
                list.add(num);
                num *= 10;
            }
            while (num > n || num%10 ==9) {
                num /= 10;
            }
            num++;
        }
        return list;
    }
}
