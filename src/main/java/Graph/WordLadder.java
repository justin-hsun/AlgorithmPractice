package Graph;

// 127
// https://leetcode.com/problems/word-ladder/

import java.util.*;

public class WordLadder {

    Map<String, List<String>> g = new HashMap<>();
    Map<String, Integer> d = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean hasBeginWord = wordList.contains(beginWord);
        if (!wordList.contains(endWord)) return 0;
        if (!hasBeginWord) wordList.add(beginWord);
        for (int j=0; j<wordList.size(); ++j) {
            for (int k=j; k<wordList.size(); ++k) {
                int diff = 0;
                for (int i=0; i<wordList.get(j).length(); ++i) {
                    if (wordList.get(j).charAt(i) != wordList.get(k).charAt(i)) diff++;
                    if (diff > 1) break;
                }
                //System.out.println(w + " and " + ww + " have " + diff + " diff");
                if (diff == 1) {
                    g.putIfAbsent(wordList.get(j), new ArrayList<>());
                    g.putIfAbsent(wordList.get(k), new ArrayList<>());
                    g.get(wordList.get(j)).add(wordList.get(k));
                    g.get(wordList.get(k)).add(wordList.get(j));
                }
            }
        }
        //System.out.println(g);
        if (!hasBeginWord) wordList.remove(beginWord);
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(beginWord);
        d.put(beginWord, 1);
        while(!q.isEmpty()) {
            String curr = q.poll();
            visited.add(curr);
            g.getOrDefault(curr, new ArrayList<>()).forEach(n -> {
                if (!visited.contains(n)) {
                    d.put(n, Math.min(d.get(curr)+1, d.getOrDefault(n, Integer.MAX_VALUE)));
                    q.add(n);
                }
            });
        }
        return d.getOrDefault(endWord, 0);
    }
}
