package lcTest;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @author lenovo
 * 二叉树展开为链表
 *
 */
public class lc114 {
    @Test
    public void test(){

    }
    //递归的办法
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        //拉平左右子树
        flatten(root.left);
        flatten(root.right);
        // 创建临时变量
        TreeNode R = root.right;
        TreeNode L = root.left;
        // 把左边挂到右边
        root.left = null;
        root.right = L;
        //  把右边挂到末尾
        TreeNode p = root;
        while (p.right!=null){
            p = p.right;
        }
        p.right = R;
    }
    //

}
