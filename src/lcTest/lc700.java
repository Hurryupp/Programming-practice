package lcTest;

import org.junit.Test;

public class lc700 {
    @Test
    public void test(){

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        else if (root.val>val){
            return searchBST(root.left,val);
        }
        else {
            return searchBST(root.right,val);
        }
    }
}
