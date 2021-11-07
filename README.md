#Find Sum in Array
Build and check Map as we go (in one pass)

#Flatening a BST In-order
    ArrayList<Integer> nodesSorted = new ArrayList<>();
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nodesSorted.add(root.val);
        inorder(root.right);
    }