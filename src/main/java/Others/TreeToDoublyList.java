package Others;

// 426
// recursive call should return both head and tail

public class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node solutions(Node root) {
        if (root == null) return null;
        Node[] ret = findLinkList(root);
        ret[1].right = ret[0];
        ret[0].left = ret[1];
        return ret[0];
    }

    private Node[] findLinkList(Node parent) {
        Node[] ret = new Node[2];
        if (parent.left != null) {
            Node[] lc = findLinkList(parent.left);
            lc[1].right = parent;
            parent.left = lc[1];
            ret[0] = lc[0];
        } else {
            ret[0] = parent;
        }
        if (parent.right != null) {
            Node[] rc = findLinkList(parent.right);
            rc[0].left = parent;
            parent.right = rc[0];
            ret[1] = rc[1];
        } else {
            ret[1] = parent;
        }
        return ret;
    }
}
