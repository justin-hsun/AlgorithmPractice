package DynamicProgramming;

// 300
// https://leetcode.com/problems/longest-increasing-subsequence/
// building a sub cleverly and BS

import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] sub = new int[nums.length];
        int range = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(sub, 0, range, num);
            if (i < 0) {
                i = -(i+1);
                sub[i] = num;
            }
            if (i == range) range++;
        }
        return range;
    }
}
