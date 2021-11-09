package Graph;

// https://leetcode.com/problems/is-graph-bipartite/
// 785
// BFS

import java.util.*;

public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> visited = new HashSet<>(), A = new HashSet<>(), B = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<graph.length; ++i) {
            if (visited.contains(i)) continue;
            queue.add(i);
            visited.add(i);
            A.add(i);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int n : graph[v]) {
                    if (!visited.contains(n)) {
                        visited.add(n);
                        queue.add(n);
                        if (A.contains(v)) B.add(n);
                        else A.add(n);
                    } else {
                        if ((A.contains(v) && A.contains(n)) || (B.contains(v) && B.contains(n))) return false;
                    }
                }
            }
        }

        return true;
    }
}
