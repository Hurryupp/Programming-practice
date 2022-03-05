package lcTest;

import org.junit.Test;

/**
 * @author lenovo
 */
public class lc116 {
    @Test
    public void test(){

    }
    public Node connect(Node root) {
        if (root==null){
            return null;
        }
        connectTwoNode(root.left,root.right);
        return root;
    }
    public void connectTwoNode(Node L,Node R){
        if (L==null||R==null){
            return;
        }
        L.next = R;
        connectTwoNode(L.left,L.right);
        connectTwoNode(L.right,R.left);
        connectTwoNode(R.left,R.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}