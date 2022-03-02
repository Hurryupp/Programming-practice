package lcTest;

import org.junit.Test;

//不同路径
public class lc62 {
    @Test
    public void test(){
        System.out.println(uniquePaths(51, 9));
    }
    //private int ans = 0;
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0){
                    continue;
                }
                else if (i==0){
                    res[i][j] = res[i][j-1];
                }
                else if (j==0){
                    res[i][j] = res[i-1][j];
                }
                else {
                    res[i][j] = res[i-1][j]+res[i][j-1];
                }
            }
        }
        return res[m-1][n-1];
    }
    /*
    public void mypath(int m,int n,int x,int y){
        if (x==m&&y==n){
            ans++;
            return ;
        }
        if (x==m){
            mypath(m,n,x,y+1);
        }
        else if (y==n){
            mypath(m,n,x+1,y);
        }
        else {
            mypath(m,n,x,y+1);
            mypath(m,n,x+1,y);
        }
    }*/
}
