package lcTest;
// 二叉树中的最大路径和
public class lc124 {
    public static void main(String[] args) {

    }
    //第一次写
//    private int ans =0;
//    public int maxPathSum(TreeNode root) {
//        if (null==root) return 0;
//        int l = maxPathSum(root.left);
//        int r = maxPathSum(root.right);
//        if (l<=0&&r<=0){
//            ans = ans>root.val?ans:root.val;
//        }
//        else if(l<=0){
//            //ans = Math.max(ans,root.val+r);
//            ans = ans>(root.val+r)?ans:(root.val+r);
//        }
//        else if(r<=0){
//            //ans = Math.max(ans,root.val+l);
//            ans = ans>(root.val+l)?ans:(root.val+l);
//        }
//        else{
//            ans = ans>(root.val+r+l)?ans:(root.val+l+r);
//        }
//        return Math.max(root.val+l>r?l:r,root.val) ;
//        //return root.val+(l>r?l:r)>0?(l>r?l:r):0;
//
//    }

    //第二次写
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return maxValue;
    }
    //返回最大路径
    public int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left <= 0 && right <= 0) {
            maxValue = Math.max(maxValue,root.val);
            //return root.val;
        } else if (left <= 0) {
            maxValue = Math.max(maxValue,root.val+right);
        } else if (right <= 0) {
            maxValue = Math.max(maxValue,root.val+left);
        }
        else {
            maxValue = Math.max(maxValue,root.val+left+right);
        }
        return Math.max(root.val,Math.max(root.val+left,root.val+right));
    }
}
