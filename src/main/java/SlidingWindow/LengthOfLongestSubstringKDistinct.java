package SlidingWindow;

// 340
// D[i, k] = max(D[i-1, k]

import java.util.HashMap;
import java.util.LinkedList;

public class LengthOfLongestSubstringKDistinct {
    public int solutions(String s, int k) {
        if (k == 0) return 0;

        int currK = 0;
        int currLen = 0;
        int maxLen = 0;
        HashMap<Character, Integer> charToCnt = new HashMap<>();
        LinkedList<Character> window = new LinkedList<>();
        char[] sc = s.toCharArray();

        for (char c : sc) {
            if (charToCnt.getOrDefault(c, 0) == 0) {
                while (currK == k) {
                    char front = window.poll();
                    currLen--;
                    charToCnt.put(front, charToCnt.get(front) - 1);
                    if (charToCnt.get(front) == 0) currK--;
                }
                charToCnt.put(c, 1);
                currK++;
            } else {
                charToCnt.put(c, charToCnt.getOrDefault(c, 0) + 1);
            }
            window.add(c);
            currLen++;
            maxLen = Math.max(currLen, maxLen);
        }

        return maxLen;
    }
}
