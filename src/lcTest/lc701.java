package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 二叉搜索树中的插入操作
 */
public class lc701 {
    @Test
    public void test(){

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right,val);
        }else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
