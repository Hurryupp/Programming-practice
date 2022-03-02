package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 合并区间
public class lc56 {
    @Test
    public void test(){
        int[][] a = {{1,3}};
        int[][] m = merge(a);
        System.out.println(Arrays.deepToString(m));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
        List<int[]> m = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0]; int R = intervals[i][1];
            if (i==0||intervals[i][0]>m.get(m.size()-1)[1]){
                m.add(new int[]{L,R});
            }
            else if(intervals[i][0]<m.get(m.size()-1)[1]){
                m.get(m.size()-1)[1] = Math.max(m.get(m.size()-1)[1],intervals[i][1]);
            }
        }
        return m.toArray(new int[m.size()][]);
    }
}
