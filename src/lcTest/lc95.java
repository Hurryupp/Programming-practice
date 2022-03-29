package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//不同的二叉搜索树2
public class lc95 {
    @Test
    public void test(){
        generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return  helper(1,n);

    }
    public List<TreeNode> helper(int low,int high){
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (low > high) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = low; i<=high;i++){
            //弄出左子树
            List<TreeNode> leftTree = helper(low, i - 1);
            System.out.println(leftTree.toString());
            //弄出右子树
            List<TreeNode> rightTree = helper(i + 1, high);
            for (TreeNode left :
                    leftTree) {
                for (TreeNode right :
                        rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    treeNodes.add(node);
                }
            }
        }
        return treeNodes;
    }
}
