package Graph;

// 199
// BFS (queue) + level queue

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> ret = new ArrayList<>();
    private Queue<Integer> levelq = new LinkedList<>();
    private int level = 0;

    public List<Integer> solutions(TreeNode root) {
        if (root == null) return List.of();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        levelq.add(level);
        while (!q.isEmpty()) {
            var node = q.poll();
            var lvl = levelq.poll();
            if (lvl > level) level = lvl;
            if (node.left != null) {
                q.add(node.left);
                levelq.add(level+1);
            }
            if (node.right != null) {
                q.add(node.right);
                levelq.add(level+1);
            }
            if (!levelq.isEmpty() && levelq.peek() > level) ret.add(node.val);
            if (levelq.isEmpty()) ret.add(node.val);
        }
        return ret;
    }

    private int NumOfChildren(TreeNode p) {
        if (p.left == null && p.right == null) return 0;
        else if (p.left == null) return 1;
        else if (p.right == null) return 1;
        else return 2;
    }
}
