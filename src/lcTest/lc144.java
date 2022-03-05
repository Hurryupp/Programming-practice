package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * 二叉树的前序遍历
 */
public class lc144 {
    @Test
    public void test(){

    }
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root==null) {
            return ans;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }
}
