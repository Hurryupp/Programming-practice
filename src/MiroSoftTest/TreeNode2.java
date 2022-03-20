package MiroSoftTest;

public class TreeNode2 {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode2() {
    }

    public TreeNode2(int val) {
        this.val = val;
    }

    public TreeNode2(int val, TreeNode left, TreeNode right) {
        this(val);
        this.left = left;
        this.right = right;
    }

}
