package Graph;

// 210
// https://leetcode.com/problems/course-schedule-ii/

import java.util.*;

public class CourseScheduleII {

    Map<Integer, List<Integer>> g = new HashMap<>();
    boolean[] visited;
    boolean foundCycle = false;
    Set<Integer> inDegreeZeros = new HashSet<>();
    List<Integer> res = new ArrayList<>();
    int[] currLvl;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        currLvl = new int[numCourses];
        for (int i=0; i<numCourses; ++i) {
            inDegreeZeros.add(i);
            currLvl[i] = numCourses;
        }
        if (prerequisites.length == 0) {
            int[] ret = new int[numCourses];
            for (int i=0; i<numCourses; ++i) {
                ret[i] = i;
            }
            return ret;
        }
        for (int[] pre : prerequisites) {
            g.putIfAbsent(pre[1], new ArrayList<>());
            g.get(pre[1]).add(pre[0]);
            inDegreeZeros.remove(pre[0]);
        }

        //System.out.println(g);
        visited = new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int inDegreeZero : inDegreeZeros) {
            q.add(inDegreeZero);
            int lvl = 0;
            while(!q.isEmpty()) {
                int lvlCnt = q.size();
                for (int i=0; i<lvlCnt; ++i) {
                    int curr = q.poll();
                    visited[curr] = true;
                    currLvl[curr] = lvl;
                    for (int n : g.getOrDefault(curr, new ArrayList<>())) {
                        if (visited[n] && currLvl[n] <= ) return new int[0];
                    }
                }
                lvl++;
            }
        }



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
