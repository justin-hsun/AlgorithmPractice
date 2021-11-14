package Others;

// https://leetcode.com/problems/most-common-word/
// 819
// regex and replaceAll

import java.util.*;

public class MostCommonWord {
    public class Pair {
        String s;
        int cnt;
        public Pair(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("!|\\?|'|,|;|\\.", " ");
        var words = paragraph.split(" ");
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>((b,a) -> a.cnt-b.cnt);
        for (var word : words) {
            if (!word.equals("")) {
                word = word.toLowerCase();
                freq.put(word, freq.getOrDefault(word, 0)+1);
            }
        }
        for (var entry : freq.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        while(!heap.isEmpty()) {
            var p = heap.poll();
            if (Arrays.stream(banned).anyMatch(a -> a.equals(p.s))) {
                continue;
            }
            return p.s;
        }

        return "";
    }
}
