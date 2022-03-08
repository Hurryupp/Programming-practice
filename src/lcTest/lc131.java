package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 分割回文串
 */
public class lc131 {
    @Test
    public void test(){

    }
    List<List<String>> ans = new ArrayList<>();
    Deque<String > res = new LinkedList<String>();
    public List<List<String>> partition(String s ){
       helper(s,0);
       return ans;
    }
    public void helper(String s,int start){
        if (start>=s.length()){
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            //判断是否回文
            if (isValid(s,start,i)){
                res.add(s.substring(start,i+1));
                helper(s,i+1);
                res.removeLast();
            }
        }
    }
    public boolean isValid(String s,int start,int end){
        for (int i = start,j = end; i < j; i++,j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
