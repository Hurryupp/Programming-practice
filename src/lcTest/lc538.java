package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 把二叉搜索树转换成累加树
 */
public class lc538 {
    @Test
    public void test(){

    }
    private int last;
    public TreeNode convertBST(TreeNode root) {
       if (root==null){
           return null;
       }
       last = 0;
       helper(root);
       return root;
    }
    public void helper(TreeNode root){
        if (root == null) {
            return;
        }
        helper(root.right);
        root.val += last;
        last = root.val;
        helper(root.left);
    }
}
