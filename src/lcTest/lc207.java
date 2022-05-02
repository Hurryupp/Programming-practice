package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lc207 {
    @Test
    public void test(){

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //建立图，以邻接矩阵的方法
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0;i<prerequisites.length;i++){
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            graph[from].add(to);
        }
        visted = new boolean[numCourses];
        onPath = new boolean[numCourses];
        ans = new LinkedList<>();
        //多个课可能不相链接，所以每个都要循环到
        for (int i = 0; i < numCourses; i++) {
            helper(graph,i);
        }
        if(flag){ //有环
            return new int[0];
        }
        Collections.reverse(ans);
        int[] ints = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ints[i] = ans.get(i);
        }
        return ints;
    }
    boolean[] visted; //记录那个已经被访问
    boolean[] onPath; //记录现在正在北访问的路径，如果已经访问过又回来了，则就是有环路
    boolean flag;
    List<Integer> ans;
    //DFS遍历每一个节点
    public void helper(List<Integer>[] grapg,int p){
        if (onPath[p]){
            flag = true;
        }
        if (visted[p]){
            return;
        }
        onPath[p] = true;
        visted[p] = true;
        for (int t :    //一个节点可能有多个先修课
                grapg[p]) {
            helper(grapg,t);

        }
        ans.add(p);
        onPath[p] = false;
    }
}
