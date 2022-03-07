package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 最大二叉树
 */
public class lc654 {
    @Test
    public void test(){
        int[] ints = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = constructMaximumBinaryTree(ints);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length);
    }
    public TreeNode helper(int[] nums,int start,int end){
        //1、明确递归结束条件
        if(nums.length == 0||end<=start) return null;
        //2、专注节点该做的事
        //找到max和其位置
        int maxp = find(nums, start, end);
        TreeNode node = new TreeNode(nums[maxp]);
        //3、递归调用子结构
        TreeNode L = helper(nums, start, maxp); //左子树
        TreeNode R = helper(nums, maxp+1, end); //右子树
        node.left = L;
        node.right =R;
        return node;
    }
    public int find(int[] nums,int start,int end){
        int max = nums[start];
        int p = start;
        for (int i = start; i < end; i++) {
            if (nums[i]>max){
                max = nums[i];
                p = i;
            }
        }
        return p;
    }
}
