package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc797 {
    @Test
    public void test(){
        int[][] ints = new int[4][];
        ints[0] = new int[]{1,2};
        ints[1] = new int[]{3};
        ints[2] = new int[]{3};
        ints[3] = new int[]{1,2};
        allPathsSourceTarget(ints);


    }
    LinkedList<Integer> res = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int len = graph.length;
        helper(graph,0,len);
        return ans;
    }
    public void helper(int[][] graph,int x,int len){
        if (x == len-1||graph[x] == null) {
            res.add(x);
            System.out.println(res.toString());
            ans.add(new LinkedList<>(res));
            res.removeLast();
            return;
        }
        for (int i = 0;i<graph[x].length;i++){
            //加入结果集
            res.add(x);
            //递归下一层
            helper(graph,graph[x][i],len);
            //回退
            res.removeLast();
        }
    }
}
