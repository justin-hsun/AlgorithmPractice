package SlidingWindow;

// 76
// 0. set start as 0
// 1. find an end where window meets requirement
// 2. move start forwards until window doesn't meet requirement
// 3. record length
// 4. move end forwards until window meet requirement
// 5. repeat 2-5

import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> tCharLeftCnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCharLeftCnt.put(c, tCharLeftCnt.getOrDefault(c, 0)+1);
        }
        int uniqueTCharNonZeroCnt = tCharLeftCnt.keySet().size();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        char[] sc = s.toCharArray();

        for (int i=0; i<sc.length; ++i) {
            if (tCharLeftCnt.containsKey(sc[i])) {
                tCharLeftCnt.put(sc[i], tCharLeftCnt.get(sc[i])-1);
                if (tCharLeftCnt.get(sc[i]) == 0) uniqueTCharNonZeroCnt--;
            }
            if (uniqueTCharNonZeroCnt == 0) {
                end = i;
                break;
            }
        }

        // can't even find one
        if (uniqueTCharNonZeroCnt > 0) return "";

        int retStart = start;
        int retEnd = end;

        for (int i=end; i<sc.length; ++i) {
            if (uniqueTCharNonZeroCnt > 0) {
                if (tCharLeftCnt.containsKey(sc[i])) {
                    tCharLeftCnt.put(sc[i], tCharLeftCnt.get(sc[i])-1);
                    if (tCharLeftCnt.get(sc[i]) == 0) uniqueTCharNonZeroCnt--;
                }
            }
            while (uniqueTCharNonZeroCnt == 0 && start <= i) {
                if (tCharLeftCnt.containsKey(sc[start])) {
                    tCharLeftCnt.put(sc[start], tCharLeftCnt.get(sc[start])+1);
                    if (tCharLeftCnt.get(sc[start]) > 0) {
                        if (i-start+1 < minLen) {
                            minLen = i-start+1;
                            retStart = start;
                            retEnd = i;
                        }
                        uniqueTCharNonZeroCnt++;
                    }
                }
                start++;
            }
            //System.out.println("start: " + start + " end: " + i + " uniqueTCharNonZeroCnt: " + uniqueTCharNonZeroCnt);
            //System.out.println(tCharLeftCnt.toString());
        }

        return s.substring(retStart, retEnd+1);
    }
}
