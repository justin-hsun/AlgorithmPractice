package AmazonOA;


import java.util.*;

public class CountMiss {
    public static class Pair {
        int val;
        int ts;
        public Pair(int val, int ts) {
            this.val = val;
            this.ts = ts;
        }
    }
    List<Integer> a = new ArrayList<>();

    public static Map<Integer, Pair> map = new HashMap<>();
    public static PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.ts-b.ts);

    public static int countMiss(int[] input, int size) {
        a.
        int count = 0;
        int miss = 0;
        for (int i=0; i<input.length; ++i) {
            if (map.containsKey(input[i])) {
                miss++;
                var p = map.get(input[i]);
                minHeap.remove(p);
                p.ts = i;
                minHeap.add(p);
            } else if (count < size) {
                count++;
                Pair p = new Pair(input[i], i);
                map.put(input[i], p);
                minHeap.add(p);
            } else {
                Pair p = new Pair(input[i], i);
                map.put(input[i], p);
                minHeap.add(p);
                var lp = minHeap.poll();
                map.remove(lp.val);
            }
        }
        return miss;
    }
}
