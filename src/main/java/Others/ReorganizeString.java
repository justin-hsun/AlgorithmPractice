package Others;

// https://leetcode.com/problems/reorganize-string/
// 767
// PriorityQueue

import java.util.*;

public class ReorganizeString {
    public class Tuple {
        Character k;
        int v;
        public Tuple(Character k, int v) {
            this.k = k;
            this.v = v;
        }
    }
    public String reorganizeString(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Tuple> heap = new PriorityQueue<>((b, a) -> a.v - b.v);
        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        map.forEach((key, value) -> heap.add(new Tuple(key, value)));
        if (heap.size() <= 1) return "";
        while(!heap.isEmpty()) {
            var curr = heap.poll();
            var next = heap.poll();
            if (curr.v == 0) break;
            if (next.v == 0 && curr.v > 1) return "";
            if (next.v == 0 && curr.v == 1) {
                sb.append(curr.k);
                break;
            }
            sb.append(curr.k);
            sb.append(next.k);
            curr.v--;
            next.v--;
            heap.add(curr);
            heap.add(next);
        }

        return sb.toString();
    }
}
