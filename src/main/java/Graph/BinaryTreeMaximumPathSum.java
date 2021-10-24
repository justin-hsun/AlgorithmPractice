package Graph;

// 124
// O(N) visit each node once
// recursion. Check all possible case at each level
// 1. parent
// 2. parent + left
// 3. parent + right
// 4. parent + left + right
// currMax = max(currMax,1,2,3,4)
// return max(1,2,3) as recursion result

public class BinaryTreeMaximumPathSum {
    public class TreeNode {
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

    private int max = -1001;

    public int solutions(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;

        findMax(root);

        return max;
    }

    private int findMax(TreeNode parent) {
        int leftMax = parent.left == null ? 0 : findMax(parent.left);
        int rightMax = parent.right == null ? 0 : findMax(parent.right);
        int bothMax = leftMax + rightMax + parent.val;

        int ret = Math.max(Math.max(leftMax+parent.val, rightMax+parent.val), parent.val);
        max = Math.max(Math.max(ret, bothMax), max);

        return ret;
    }

}
