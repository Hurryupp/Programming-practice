package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 二叉搜索树中第K小的元素
 */
public class lc230 {
    @Test
    public void test(){

    }
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        helper(root,k);
        return val;
    }
    int count;
    int val;
    public void helper(TreeNode root,int k){
        if (root==null){
            return;
        }
        helper(root.left,k);
        count++;
        if (count==k){
            val = root.val;
            return;
        }
        helper(root.right,k);
    }
}
