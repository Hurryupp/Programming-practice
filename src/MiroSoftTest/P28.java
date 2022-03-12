package MiroSoftTest;

import org.junit.Test;

/**
 * @author lenovo
 * 二叉树的最近公共祖先
 */
public class P28 {
    @Test
    public void test(){
        System.out.println((int)'z');
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        } else if (l == null) {
            return r;
        } else if (r == null) {
            return l;
        }else {
            return root;
        }
    }
}
