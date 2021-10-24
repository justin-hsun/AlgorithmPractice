package Graph;

// 269
// compare in between words
// in degree = # of chars in before this char

import java.util.*;

public class AlienOrder {
    public String solutions(String[] words) {

        StringBuilder ret = new StringBuilder();

        if (words.length == 1) {
            Set<Character> s = new HashSet<>();
            for (char c : words[0].toCharArray()) {
                s.add(c);
            }
            for (char c : s) {
                ret.append(c);
            }
            return ret.toString();
        }

        HashMap<Character, Integer> inDegByChar = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (int i=0; i<words.length-1; ++i) {
            boolean foundDiff = false;
            char[] small = words[i].toCharArray();
            char[] large = words[i+1].toCharArray();
            for (char c : small) {
                inDegByChar.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new ArrayList<>());
            }
            for (char c : large) {
                inDegByChar.putIfAbsent(c, 0);
                graph.putIfAbsent(c, new ArrayList<>());
            }
            for (int j=0; j<Math.min(small.length, large.length); ++j) {
                if (small[j] != large[j]) {
                    inDegByChar.put(large[j], inDegByChar.get(large[j]) + 1);
                    graph.computeIfAbsent(small[j], (k -> new ArrayList<>())).add(large[j]);
                    foundDiff = true;
                    break;
                }
            }
            if (!foundDiff && small.length > large.length) return "";
        }

        Queue<Character> inDegZeroQueue = new LinkedList<>();
        for (var entry : inDegByChar.entrySet()) {
            if (entry.getValue() == 0) inDegZeroQueue.add(entry.getKey());
        }
        while (!inDegZeroQueue.isEmpty()) {
            char c = inDegZeroQueue.poll();
            ret.append(c);
            for (char nextC : graph.get(c)) {
                var inDeg = inDegByChar.get(nextC);
                if (inDeg == 1) {
                    inDegZeroQueue.add(nextC);
                    inDegByChar.put(nextC, 0);
                }
                else inDegByChar.put(nextC, inDeg-1);
            }
        }
        for (var entry : inDegByChar.entrySet()) {
            if (entry.getValue() != 0) return "";
        }
        return ret.toString();
    }
}
