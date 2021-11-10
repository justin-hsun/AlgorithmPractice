package Others;

// https://leetcode.com/problems/lru-cache/
// 146
// Map + doubly linked list
// number of changed arrow = number of lines of operations

import java.util.HashMap;

public class LRUCache {

    public class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public class DDL {
        int size;
        Node head;
        Node tail;

        public DDL(int size) {
            this.size = size;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public void moveToHead(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            if (prev == head) return;
            next.prev = node.prev;
            prev.next = node.next;
            addToHead(node);
        }

        public void addToHead(Node node) {
            if (head.next == tail && tail.prev == head) {
                head.next = node;
                tail.prev = node;
                node.prev = head;
                node.next = tail;
            } else {
                node.next = head.next;
                head.next.prev = node;
                head.next = node;
                node.prev = head;
            }
        }

        public int removeFromTail() {
            Node last = tail.prev;
            tail.prev = last.prev;
            last.prev.next = tail;
            return last.key;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node n = head.next;
            while (n.next != null) {
                sb.append("(" + n.key+","+n.val + ")");
                n = n.next;
            }
            return sb.toString();
        }
    }

    DDL ddl;
    HashMap<Integer, Node> map;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.ddl = new DDL(capacity);
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        ddl.moveToHead(n);
//        System.out.println("Get " + key);
//        System.out.println(ddl.toString());
//        System.out.println(map.toString());
        return n.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ddl.moveToHead(map.get(key));
            map.get(key).val = value;
            return;
        }
        Node n = new Node(key, value);
        map.put(key, n);
        ddl.addToHead(n);
        if (count < capacity) count++;
        else map.remove(ddl.removeFromTail());
//        System.out.println("Put " + key);
//        System.out.println(ddl.toString());
//        System.out.println(map.toString());

    }

}
