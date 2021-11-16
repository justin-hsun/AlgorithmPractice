package DynamicProgramming;

// https://leetcode.com/problems/longest-palindromic-substring/
// 5
// DP

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        char[] ss = s.toCharArray();
        boolean[][] D = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); ++i) {
            D[i][i] = true;
        }
        for(int i=0; i<s.length()-1; ++i) {
            D[i][i+1] = ss[i] == ss[i+1];
        }
        for(int len=2; len<s.length(); ++len) {
            for (int start=0; start<s.length()-len; ++start) {
                D[start][start+len] = D[start+1][start+len-1] && ss[start] == ss[start+len];
            }
        }
        int maxLen = 0;
        int maxStart = 0, maxEnd = 0;
        for (int i=0; i<s.length(); ++i) {
            for (int j=i; j<s.length(); ++j) {
                if (D[i][j]) {
                    if (j-i > maxLen) {
                        maxLen = j-i;
                        maxStart = i;
                        maxEnd = j;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }
}
