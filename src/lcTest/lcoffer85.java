package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 剑指offer85 生成匹配的括号
 */
public class lcoffer85 {

    @Test
    public void test(){
        generateParenthesis(3);
        System.out.println(ans.toString());
    }
    List<String > ans = new ArrayList<>();
    StringBuilder res = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        helper(n,0,0);
        return ans;
    }
    public void helper(int n,int leftCount,int rightCount){
        if (n == leftCount && n == rightCount) {
            ans.add(res.toString());
            return;
        }
        if (leftCount < n) {
            res.append("(");
            helper(n,leftCount+1,rightCount);
            res.delete(res.length()-1,res.length());
        }
        if (leftCount > rightCount && rightCount < n) {
            res.append(")");
            helper(n,leftCount,rightCount+1);
            res.delete(res.length()-1,res.length());
        }
    }
}
