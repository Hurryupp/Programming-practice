package MiroSoftTest;

/**
 * @author lenovo
 * 字符串转整数 atoi
 */
public class P1 {

    public int myAtoi(String s){
        int len = s.length();
        char[] array = s.toCharArray();
        //1、删除前导空格
        int index = 0;
        while (index<len && array[index]==' '){
            index++;
        }
        //2、提取符号
        int sign = 1;
        char signChar = array[index];
        if (signChar == '+'){
            index++;
        }
        else if (signChar == '-'){
            sign = -1;
            index++;
        }

        //3、开始计算数值
        int ans = 0;
        while (index < len){
            //获取当前的字符
            char curChar = array[index];
            //判断是否合规
            if (curChar < '0'||curChar > '9'){
                break;
            }
            //判断是否超出限制
            if (ans > Integer.MAX_VALUE/10 || (ans ==Integer.MAX_VALUE/10 && (curChar-'0')>7)) {
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE / 10 || (ans==Integer.MIN_VALUE/10 && (curChar-'0')>8)) {
                return Integer.MIN_VALUE;
            }
            ans = ans*10 +(curChar-'0');
        }
        return sign*ans;
    }
}
