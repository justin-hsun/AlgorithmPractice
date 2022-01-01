package Graph;

// 207
// https://leetcode.com/problems/course-schedule/

import java.util.*;

public class CourseSchedule {

    Map<Integer, List<Integer>> g = new HashMap<>();
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        for (int[] pre : prerequisites) {
            g.putIfAbsent(pre[1], new ArrayList<>());
            g.get(pre[1]).add(pre[0]);
        }

        //System.out.println(g);
        visited = new boolean[numCourses];
        for (int i=0; i<numCourses; ++i) {
            if (!visited[i] && !DFS(new HashSet<>(), i)) return false;
        }
        return true;
    }

    private boolean DFS(Set<Integer> stack, int curr) {
        visited[curr] = true;
        stack.add(curr);
        //System.out.println(curr);
        for (int n : g.getOrDefault(curr, new ArrayList<>())) {
            if (stack.contains(n)) return false;
            if (!visited[n] && !DFS(stack, n)) return false;
        }
        stack.remove(curr);
        return true;
    }
}
