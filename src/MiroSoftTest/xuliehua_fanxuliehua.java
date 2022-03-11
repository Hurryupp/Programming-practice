package MiroSoftTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lenovo
 * 二叉树的序列化与反序列化
 */
public class xuliehua_fanxuliehua {
    @Test
    public void test(){
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
//
        String serialize = serialize(treeNode1);
        System.out.println(serialize);
        deserialize(serialize);
    }
    public String serialize(TreeNode root){
        if (root == null) {
            return "n";
        }
        String s = root.val +" "+ serialize(root.left)+" " + serialize(root.right);
        return s;
    }
    public TreeNode deserialize(String str){
        String[] strings = str.split(" ");
        List<String> dataList = new LinkedList<>(Arrays.asList(strings));
        return rdeserialize(dataList);
    }
    public TreeNode rdeserialize(List<String> dataList){
        if (dataList.get(0).equals("n")){
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}