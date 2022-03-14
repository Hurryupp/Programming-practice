package MiroSoftTest;

import com.sun.jmx.snmp.BerEncoder;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * @author lenovo
 * 验证二叉树
 */
public class P18 {
    @Test
    public void test(){
        TreeNode treeNode1 = new TreeNode(1, null,null);
        TreeNode treeNode3 = new TreeNode(3, null,null);
        TreeNode treeNode2 = new TreeNode(2, treeNode1,treeNode3);
        System.out.println(isValidBST(treeNode2));
    }
    public boolean isValidBST(TreeNode root) {
        long floor = Integer.MIN_VALUE;
        floor--;
        long top = Integer.MAX_VALUE;
        top++;
        return isBST(root,floor,top);
    }
    public boolean isBST(TreeNode root,long floor,long top){
        if (root == null) {
            return true;
        }
        if (root.val > floor && root.val < top) {
            return isBST(root.left,floor,root.val)&&isBST(root.right,root.val,top);
        }
        else {
            return false;
        }
    }
}
