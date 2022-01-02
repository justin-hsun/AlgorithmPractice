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

#Map<Node, Node>
    // Two different objects, even with same values on all fields, still have different hash.
    Node a = new Node(1), b = new Node(1);
    Map<Node, Integer> map = new HashMap<>();
    map.put(a, 1);
    map.put(b, 2);
    // map: {Node@52a86356=2, Node@66480dd7=1}

#BFS/DFS with Level
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int level = q.size();
        for(int i = 0; i < level; i++){
            TreeNode top = q.poll();
            ...
        }
    }

#Dynamic Programming
1. Find recursive relation / Define D
2. Populate D with base case
3. Use for loop to start the computation

#Arrays.sort with custom comparator
    // Define a and b type
    Arrays.sort(intervals, (int [] a, int[] b) -> a[0] - b[0]);

#BinarySearch in ArryaList or Primitive Array
    ArryaList: Collections.binarySearch(lst, key, Comparator)
    Primitive Array: Arrays.binarySearch(lst, startIndex(inclusive), endIndex(exclusive), key)
Both returns positive index when found, negative index when not found. 
The negative indicates insertion point via **-(res+1)**.