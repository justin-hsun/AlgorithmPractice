package DivideAndConquer;

// 973
// Comparator can be replaced with lambda
// (a, b) -> a-b : increase
// (b, a) -> a-b : decrease

import java.util.*;

public class KCloestestPointToOrigin {
    public int[][] solutions(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((b, a) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > k) heap.poll();
        }
        var ret = new int[k][k];
        for (int i=0; i<k; i++) {
            ret[i] = heap.poll();
        }
        return ret;
    }
}
