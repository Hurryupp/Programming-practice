package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 * 删除二叉搜索树中的节点
 */
public class lc450 {
    @Test
    public void test(){

    }

    //思路一：拉不拉东的思路
//    public TreeNode deleteNode(TreeNode root, int key) {
//        if (root==null){
//            return null;
//        }
//        if (root.val == key) {
//            TreeNode dele = dele(root, key);
//            return dele;
//        }
//        else if (root.val < key) {
//            root.right = deleteNode(root.right,key);
//        }else {
//            root.left = deleteNode(root.left,key);
//        }
//        return root;
//    }
//    public TreeNode dele(TreeNode root,int key){
//        if (root.left == null && root.right == null) {
//            return null;
//        } else if (root.left == null) {
//            return root.right;
//        } else if (root.right == null) {
//            return root.left;
//        }else {
//            //寻找右子树中最小的节点
//            TreeNode tmp = root.right;
//            TreeNode last = root;
//            while (tmp.left != null) {
//                last = tmp;
//                tmp = tmp.left;
//            }
//            if (last != root) {
//                //继承左孩子
//                tmp.left = root.left;
//                root.left = null; //断掉左孩子
//                //保存tmp右孩子
//                if (tmp.right != null) {
//                    last.left = tmp.right;
//                    tmp.right = null;
//                }else {
//                    last.left = null;
//                }
//
//                if (root.right != tmp) {
//                    tmp.right = root.right;
//                }
//                root.right = null;
//                return tmp;
//            }
//            else {
//                tmp.left = root.left;
//                root.left = null;
//                root.right = null;
//                return tmp;
//            }
//        }
//    }

    //思路二：
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            else {
                TreeNode tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                tmp.left = root.left;
                return root.right;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left,key);
        }
        else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
