package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 */
public class lc105 {
    @Test
    public void test(){
        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    public TreeNode helper(int[] preorder, int[] inorder,int pstart,int pend,
                           int instart,int inend){
        //1、递归的结束条件
        if (preorder.length==0||pstart>=pend||instart>=inend){
            return null;
        }
        //2、该节点自己的事情,创建节点，并把左右两个链上
        TreeNode node = new TreeNode(preorder[pstart]);
        System.out.println(node.val);
        // 找到节点的位置
        int index =0;
        for (int i = instart; i < inend; i++) {
            if (inorder[i]==preorder[pstart]){
                index = i;
                break;
            }
        }
        int leftsize = index-instart;
        TreeNode node1 = helper(preorder, inorder, pstart+1, leftsize+pstart+1,
                instart,index);
        TreeNode node2 = helper(preorder, inorder, pstart+leftsize+1, pend,
                index+1,inend);
        node.left = node1;
        node.right = node2;
        return node;
    }
}
