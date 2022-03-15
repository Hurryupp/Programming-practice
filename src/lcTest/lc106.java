package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 从中序和后序遍历中序列化构造二叉树
 */
public class lc106 {
    @Test
    public void test(){
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode node = buildTree(inorder, postorder);
        show(node);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return helper(inorder,0,inorder.length,
                postorder,0,postorder.length);
    }
    public TreeNode helper(int[] inorder, int instart, int inend,
                       int[] postorder , int poststart , int postend){
        //1、递归结束的条件
        if (inend<=instart) {
            return null;
        }
        //2、该节点该做的事情
        TreeNode node = new TreeNode(postorder[postend-1]);
        System.out.println(node.val);
        int index = 0;
        for (int i = instart; i <(inend) ; i++) {
            if (inorder[i]==postorder[postend-1]){
                index = i;
                break;
            }
        }

        //3、递归孩子节点
        int leftsize = index - instart;
        node.left = helper(inorder,instart,index,
                postorder,poststart,poststart+leftsize);
        node.right = helper(inorder,index+1,inend,
                postorder,poststart+leftsize,postend-1);
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
