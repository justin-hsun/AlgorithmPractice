package Others;

// 23
// heap sort k elements at a time
// O(NlogK)

import java.util.PriorityQueue;

public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

    public ListNode solutions(ListNode[] lists) {
        ListNode ret = null;
        if (lists.length == 0) return ret;
        for (ListNode listNode : lists) {
            if (listNode != null) heap.add(listNode);
        }
        ListNode curr = null;
        while (!heap.isEmpty()) {
            var node = heap.poll();
            if (node.next != null) heap.add(node.next);
            if (curr == null) {
                curr = node;
                ret = curr;
            } else {
                curr.next = node;
                curr = node;
            }
        }

        return ret;
    }
}
