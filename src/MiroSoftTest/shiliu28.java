package MiroSoftTest;

import org.junit.Test;

public class shiliu28 {
    @Test
    public void test(){
        String s = "a58F";
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='0'&&chars[i]<='9'){
                result = result*16 + chars[i]-'0';
            }
            else if (chars[i]>='a'&&chars[i]<='f'){
                result = result*16 + chars[i]-'a'+10;
            }
            else if (chars[i]>='A'&&chars[i]<='F'){
                result = result*16 + chars[i]-'A'+10;
            }
        }
        System.out.println(result);
        String s1 = fun(result, "");
        System.out.println(s1);
        return ;

    }
    public String fun(int x,String s){
        if (x < 8) {
            s = s+ x;
        }
        else {
            //fun(x/8,s);
            s = fun(x/8,s) + (x%8);
        }
        return s;
    }
}
