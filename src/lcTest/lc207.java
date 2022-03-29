package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc207 {
    @Test
    public void test(){
        int[][] ints = new int[1][];
        ints[0] = new int[]{1,0};
//        ints[1] = new int[]{0,1};
//        ints[2] = new int[]{0,9};
//        System.out.println(ints[0][0]);
        canFinish(2,ints);
    }
    boolean[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //创建图
        List<Integer>[] G = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            G[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        //构架遍历数组
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        //hasCicle = false;
        for (int i = 0; i < numCourses; i++) {
            helper(G,i);
        }
        
        
        return hasCicle;
    }
    boolean[] onPath;
    boolean hasCicle = false;
    public void helper(List<Integer>[] G,int s){
        if (onPath[s]){
            hasCicle = true;
        }
        if (visited[s]||hasCicle){
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int num :
                G[s]) {
            helper(G, num);
        }
        onPath[s] = false;
    }

}
