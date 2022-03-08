package lcTest;

import org.junit.Test;

import javax.crypto.spec.DESedeKeySpec;
import java.util.*;

/**
 * @author lenovo
 */
public class lc17 {
    @Test
    public void test(){
        letterCombinations("23");
        
    }
    String[] res = new String[]{
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    List<String> ans =  new ArrayList<>();
    //Deque<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0){
            return ans;
        }
        char[] array = digits.toCharArray();
        helper(array,0,"");
        return ans;
    }
    // lists是序列，p是位置，str是记录的数据
    public void helper(char[] lists,int p,String str) {
        if (p == lists.length) {
            ans.add(str);
            return;
        }
        char c = lists[p];
        String a = res[(int)c-97];
        for (int i = 0; i<a.length() ;i++){
            str = str+a.charAt(i);
            helper(lists,p+1,str);
            str = str.substring(0,str.length()-1);
        }
    }
}
