package MiroSoftTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 复原IP地址
 */
public class P10 {
    @Test
    public void test(){
        List<String> list = restoreIpAddresses("101023");
        System.out.println(list.toString());
    }
    List<String > ans = new LinkedList<String>();
    LinkedList<String > res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s,0);
        return ans;
    }
    //str是字符串，p是分成了多部分了
    public void helper(String str,int p){
        if(str.length()==0 && p==4){
            String s = "";
            for (int i =0;i<res.size();i++){
                if (i == res.size()-1){
                    s += res.get(i);
                    break;
                }
                s = s+ res.get(i)+".";
            }
            ans.add(s);
            return;
        }
        if (p==4 && str.length()!=0) {
            return;
        }
        for (int i = 0; i<3&&i<str.length(); i++){
            if ((str.length()-i)/3 > (4-(p+1))*1.0){
                continue;
            }
            String substring = str.substring(0, i+1);
            if (isValid(substring)){
                res.add(substring);
                System.out.println(res.toString());
                helper(str.substring(i+1,str.length()),p+1);
                res.removeLast();
            }
        }
    }
    public boolean isValid(String str){
        if (str.length()==0) return false;
        //判断是否在0-255，是否有前导0
        if (str.charAt(0)=='0'&&str.length()>1){
            return false;
        }
        for (int i = 0; i < str.length();i++){
            if (str.charAt(i)>'9'||str.charAt(i)<'0'){
                return false;
            }
        }
        if (Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255) {
            return true;
        }
        return false;
    }
}
