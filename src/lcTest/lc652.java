package lcTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class lc652 {
    @Test
    public void test(){

    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return ans;
        }
        helper(root,root);
        return ans;
    }
    List<TreeNode> ans = new ArrayList<>();
    public void helper(TreeNode root1,TreeNode root2){
        if (root1 == null || root2 == null) {
            return;
        }
        if (root1 != root2 && root1.val == root2.val) {
            if (!ans.contains(root1)){
                ans.add(new TreeNode(root1.val,root1.left,root1.right));
            }
        }
        helper(root1.left,root2.left);
        helper(root1.right,root2.left);
        helper(root1.right,root2.right);
        helper(root1.left,root2.right);

    }
}
