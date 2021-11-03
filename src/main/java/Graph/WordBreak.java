package Graph;

// https://leetcode.com/problems/word-break/
// 139
// BFS

import java.util.*;

public class WordBreak {
    public boolean solutions(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[s.length()];
        int maxLen = 0;

        for (String word : wordDict) {
            words.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i=0; i<s.length(); ++i) {
            sb.append(s.charAt(i));
            if (words.contains(sb.toString())) queue.add(i);
        }

        while (!queue.isEmpty()) {
            StringBuilder sb1 = new StringBuilder();
            int curLen = 0;
            int start = queue.pollFirst();
            if (visited[start]) continue;
            else visited[start] = true;
            if (start == s.length()-1) return true;
            for (int i=start+1; i<s.length(); ++i) {
                sb1.append(s.charAt(i));
                if (words.contains(sb1.toString())) queue.add(i);
                curLen++;
                if (curLen >= maxLen) break;
            }

        }

        return false;
    }
}
