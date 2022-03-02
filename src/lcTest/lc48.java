package lcTest;

import org.junit.Test;

import java.util.Arrays;

// 旋转图像
public class lc48 {
    @Test
    public void test(){
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(m));
        rotate(m);
        System.out.println(Arrays.deepToString(m));
    }
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0;i<len/2+1;i++){
            for (int j = i; j <len-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i];
                matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
                matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
                matrix[j][len-i-1] = tmp; // 最后
            }
        }
    }
}
