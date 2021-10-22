package Graph;

// 1192. Critical Connections in a Network

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class CriticalConnections {

    Map<Integer, List<Integer>> graph = new ConcurrentHashMap<>();
    Map<Integer, Integer> timestamp = new ConcurrentHashMap<>();

    public List<List<Integer>> solutions(int n, List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            graph.computeIfAbsent(connection.get(0), (k -> new ArrayList<>())).add(connection.get(1));
            graph.computeIfAbsent(connection.get(1), (k -> new ArrayList<>())).add(connection.get(0));
        }
        for (int key : graph.keySet()) {
            timestamp.put(key, 0);
        }
        System.out.println("Initial graph: " + graph.toString());
        dfs(0,0);

        return connections.stream()
                .filter(l -> graph.get(l.get(0)).contains(l.get(1)))
                .collect(Collectors.toList());
    }

    private int dfs(int curr, int parent) {
        timestamp.put(curr, timestamp.get(parent) + 1);
        int ret = timestamp.get(curr);
        List<Integer> neighbours = new ArrayList<>();
        for (int n : graph.get(curr)) {
            neighbours.add(n);
        }
        for (int n : neighbours) {
            //System.out.println(String.format("parent: %d -> curr: %d -> n: %d", parent, curr, n));
            if (n == parent) {
                //System.out.println(String.format("ret: %d, graph: %s, ts: %s", ret, graph.toString(), timestamp.toString()));
                continue;
            }
            else if (timestamp.get(n) == 0) {
                var min = dfs(n, curr);
                if (min <= timestamp.get(curr)) {
                    graph.get(curr).remove(Integer.valueOf(n));
                    graph.get(n).remove(Integer.valueOf(curr));
                }
                ret = Math.min(ret, min);
            }
            else if (timestamp.get(n) < timestamp.get(curr)) {
                graph.get(curr).remove(Integer.valueOf(n));
                graph.get(n).remove(Integer.valueOf(curr));
                ret = Math.min(ret, timestamp.get(n));
            } else {
                graph.get(curr).remove(Integer.valueOf(n));
                graph.get(n).remove(Integer.valueOf(curr));
            }
            //System.out.println(String.format("ret: %d, graph: %s, ts: %s", ret, graph.toString(), timestamp.toString()));
        }
        return ret;
    }
}
