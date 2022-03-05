package lcTest;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @author lenovo
 */
public class lc226 {
    @Test
    public void test(){

    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 递归调用反转子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
