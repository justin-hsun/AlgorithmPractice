package Others;

// https://leetcode.com/problems/copy-list-with-random-pointer/
// 138
// Map<Node, Node> works

import java.util.*;

public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node ret = null;
        Node prev = null;
        while(head != null) {
            Node newNode = new Node(head.val);
            newNode.random = head.random;
            map.put(head, newNode);
            if (ret == null) ret = newNode;
            if (prev != null) prev.next = newNode;
            prev = newNode;
            head = head.next;
        }
        Node curr = ret;
        while(curr != null) {
            curr.random = map.get(curr.random);
            curr = curr.next;
        }
        return ret;
    }
}
