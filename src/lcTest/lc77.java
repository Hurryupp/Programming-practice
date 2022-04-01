package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 组合
 */
public class lc77 {
    @Test
    public void test(){
        int n = 1;
        int k = 1;
        combine(n,k);
        System.out.println(ans.toString());
    }
//    List<List<Integer>> ans = new ArrayList<>();
//    Deque<Integer> res = new LinkedList<>();
//    public List<List<Integer>> combine(int n, int k) {
//        helper(n,k,1);
//        return ans;
//    }
//    public void helper(int n,int k,int p){
//        if (k <= 0) {
//            ans.add(new LinkedList<>(res));
//            return;
//        }
//        for (int i = p; i <= n-(k-res.size())+1; i++) {
//            System.out.println(i);
//            res.add(i);
//            helper(n,k-1,i+1);
//            res.removeLast();
//        }
//    }

    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        ans = new ArrayList<>();
        helper(n,0,k,1);
        return ans;
    }
    LinkedList<Integer> res ;
    List<List<Integer>> ans;
    public void helper(int n,int p,int k,int start){
        if (p==k){
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = start;i<= n-(k-res.size())+1;i++){
            res.add(i);
            helper(n,p+1,k,i+1);
            res.removeLast();
        }
    }

}
