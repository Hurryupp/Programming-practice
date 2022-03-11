package MiroSoftTest;

import org.junit.Test;

/**
 * @author lenovo
 * 字符串括号全部匹配的最长子字符串长度
 */
public class zifuchuankuohao {
    @Test
    public void test(){
        String str = "())()()()";
        //排除多余的右括号
        int left = 0; int right = 0;
        int maxlength = 0;
        for (int i =0;i<str.length();i++){
            if (str.charAt(i)=='('){
                left++;
            }
            if (str.charAt(i)==')'){
                right++;
            }
            if (right==left){
                maxlength = Math.max(maxlength,2*right);
            }
            else if (right>left){  //出现了多余的右括号
                left = 0;
                right = 0;
            }
        }
        //排除多余的左括号
        left = 0; right = 0;
        for (int i = str.length()-1;i>=0;i--){
            if (str.charAt(i) == '('){
                left++;
            }
            if (str.charAt(i)==')'){
                right++;
            }
            if (right == left) {
                maxlength = Math.max(maxlength,2*left);
            }
            else if (left>right){    //出现了多余的左括号
                left = 0;
                right = 0;
            }
        }
        System.out.println(maxlength);

    }
}
