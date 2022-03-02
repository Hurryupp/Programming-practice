package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 力扣 509 斐波那契数列
 * 迭代方法，自底向上
 */
public class lc509 {
    @Test
    public void test(){
        int n = 0;
        System.out.println(fib(n));
    }
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int s1 = 0;
        int s2 = 1;
        for(int i = 2;i<=n;i++){
            s2 = s1 + s2;
            s1 = s2 - s1;
        }
        return s2;
    }
}
