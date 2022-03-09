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
        List<String> strings = letterCombinations("43");
        System.out.println(strings.toString());

    }
//    String[] res = new String[]{
//            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
//    };
//    List<String> ans =  new ArrayList<>();
//    //Deque<String> res = new LinkedList<>();
//    public List<String> letterCombinations(String digits) {
//        if (digits.length()==0){
//            return ans;
//        }
//        char[] array = digits.toCharArray();
//        helper(array,0,"");
//        return ans;
//    }
//    // lists是序列，p是位置，str是记录的数据
//    public void helper(char[] lists,int p,String str) {
//        if (p == lists.length) {
//            ans.add(str);
//            return;
//        }
//        char c = lists[p];
//        String a = res[(int)c-97];
//        for (int i = 0; i<a.length() ;i++){
//            str = str+a.charAt(i);
//            helper(lists,p+1,str);
//            str = str.substring(0,str.length()-1);
//        }
//    }
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0||digits==null){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        String[] res = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        char[] array = digits.toCharArray();
        helper(array,0,ans,str,res);
        return ans;
    }
    public void helper(char[] digits,int p,List<String > ans,StringBuilder str,String[] res){
        if (p == digits.length) { //char 记录第几个元素
            ans.add(new String(str));
            return;
        }
        char digit = digits[p]; //找到那个按键
        String  tmp =  res[digit-'0'];   //该按键上面的字符串有哪些
        for (int i = 0; i < tmp.length(); i++) {    //从按键上的字符串开始循环
            str.append(tmp.charAt(i));
            helper(digits,p+1,ans,str,res); //递归则递归字符串
            str.delete(str.length()-1,str.length());
        }
    }




}
