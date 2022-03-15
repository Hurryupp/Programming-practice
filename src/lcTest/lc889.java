package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 前序和后序构造二叉树
 */
public class lc889 {
    @Test
    public void test(){
        int[] inorder = {2,1};
        int[] postorder = {1,2};
        TreeNode node = constructFromPrePost(inorder, postorder);
        show(node);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0) {
            return null;
        }
        return helper(preorder,0,preorder.length,postorder,0,postorder.length);
    }
    public TreeNode helper(int[] preorder,int preStart,int preEnd,
                           int[] postorder,int postStart,int postEnd){
        if (preEnd <= preStart||postEnd<=postStart) {
            return null;
        }
        //节点的事情
        TreeNode node = new TreeNode(preorder[preStart]);
        if (preStart + 1 < preEnd) {
            int val = preorder[preStart+1];
            int index = 0;
            for (int i = postStart; i <postEnd; i++) {
                if (val==postorder[i]){
                    index = i;
                    break;
                }
            }
            int leftsize = index - postStart+1;
            //调用子节点
            node.left = helper(preorder,preStart+1,preStart+1+leftsize,
                    postorder,postStart,index+1);
            node.right = helper(preorder,preStart+1+leftsize,preEnd,
                    postorder,index+1,postEnd-1);
        }
        return node;
    }
    public void show(TreeNode root){
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val+" ");
        show(root.left);
        show(root.right);
    }
}
