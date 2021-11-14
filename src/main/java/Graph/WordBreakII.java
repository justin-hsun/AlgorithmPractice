package Graph;

// https://leetcode.com/problems/word-break-ii/
// 140
// BFS + memorization

import java.util.*;
import java.util.stream.Collectors;

public class WordBreakII {

    List<List<Integer>> parent = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[s.length()];
        int maxLen = 0;

        for (int i = 0; i < s.length(); ++i) {
            parent.add(new ArrayList<>());
        }

        for (String word : wordDict) {
            words.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        queue.add(-1);

        while (!queue.isEmpty()) {
            StringBuilder sb1 = new StringBuilder();
            int curLen = 0;
            int start = queue.pollFirst();
            if (start != -1) {
                if (visited[start]) continue;
                else visited[start] = true;
                if (start == s.length() - 1) continue;
            }
            for (int i = start + 1; i < s.length(); ++i) {
                sb1.append(s.charAt(i));
                if (words.contains(sb1.toString())) {
                    queue.add(i);
                    parent.get(i).add(start);
                }
                curLen++;
                if (curLen >= maxLen) break;
            }
        }

        List<String> ret = new ArrayList<>();
        for (var path : findParentPath(s.length() - 1)) {
            //System.out.println(path);
            List<String> ss = new ArrayList<>();
            for (int i = 0; i < path.size() - 1; ++i) {
                ss.add(s.substring(path.get(i)+1, path.get(i + 1) + 1));
            }
            ret.add(String.join(" ", ss));
        }

        return ret;
    }

    private List<List<Integer>> findParentPath(int childIdx) {
        List<List<Integer>> ret = new ArrayList<>();
        for (var parentIdx : parent.get(childIdx)) {
            if (parentIdx == -1) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(parentIdx);
                ret.add(tmp);
                continue;
            }
            ret.addAll(findParentPath(parentIdx));
        }

        return ret.stream()
                .peek(p -> p.add(childIdx))
                .collect(Collectors.toList());
    }
}
