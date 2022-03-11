package MiroSoftTest;

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class xuLieHua {
    @Test
    public void test(){
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, treeNode5);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        String serialize = serialize(treeNode1);
        System.out.println(serialize);
    }
    public String serialize(TreeNode root){
        return rserialize(root,"");
    }
    public TreeNode deserialize(String data){
        String[] strings = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(strings));

        return rdeserialize(dataList);
    }
    public String rserialize(TreeNode root,String str){
        if (root == null) {
            str += "None,";
        }
        else {
            str += String.valueOf(root.val) + ",";
            str = rserialize(root.left,str);
            str = rserialize(root.right,str);
        }
        return str;
    }
    public TreeNode rdeserialize(List<String > dataList){
        if (dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        node.left = rdeserialize(dataList);
        node.right = rdeserialize(dataList);
        return node;
    }
}
