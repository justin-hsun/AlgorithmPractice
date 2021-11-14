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

#Max Values
    Integer.MAX_VALUE, Integer.MIN_VALUE
    Float.MAX_VALUE, Float.MIN_VALUE
    ...

#Return Type Incompatible
    private void foo () {...}
    // Wrong
    return foo();
    // Correct
    foo();

#DoublyLinkedList
- Consider this structure when O(1) is required
- Number of changed arrow = Number of lines of operations

#replaceAll Regex
    // replaceAll() return a new replaced string rather than mutating the input string
    paragraph = paragraph.replaceAll("!|\\?|'|,|;|\\.", " ");