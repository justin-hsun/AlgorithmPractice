package Graph;

// https://leetcode.com/problems/accounts-merge/
// 721
// Merge -> BFS/DFS
// Iterative approach is always better
// Practice BFS/DFS, details matters

import java.util.*;

public class AccountsMerge {
    Map<String, Set<String>> g = new HashMap<>();
    Map<String, String> emailToName = new HashMap<>();
    Set<String> visited = new HashSet<>();

    public List<List<String>> solutions(List<List<String>> accounts) {
        List<List<String>> ret = new ArrayList<>();

        // Build the graph
        for (var account : accounts) {
            if (account.size() == 2 && !g.containsKey(account.get(1))) {
                g.put(account.get(1), new HashSet<>());
                emailToName.put(account.get(1), account.get(0));
                continue;
            }
            for (int i=1; i<account.size()-1; ++i) {
                g.putIfAbsent(account.get(i), new HashSet<>());
                g.putIfAbsent(account.get(i+1), new HashSet<>());
                g.get(account.get(i)).add(account.get(i+1));
                g.get(account.get(i+1)).add(account.get(i));
                emailToName.put(account.get(i), account.get(0));
                emailToName.put(account.get(i+1), account.get(0));
            }
        }

        System.out.println(g.toString());

        // BFS
        Queue<String> queue = new LinkedList<>();
        for (var email : g.keySet()) {
            if (visited.contains(email)) continue;
            List<String> emails = new ArrayList<>();
            queue.add(email);
            visited.add(email);
            emails.add(email);
            while (!queue.isEmpty()) {
                var v = queue.poll();
                for (var n : g.get(v)) {
                    if (!visited.contains(n)) {
                        emails.add(n);
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
            Collections.sort(emails);
            emails.add(0, emailToName.get(email));
            ret.add(emails);
        }

        return ret;
    }
}
