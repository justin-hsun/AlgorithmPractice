package Others;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// 34
// BS

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    int start = Integer.MAX_VALUE;
    int end = -1;

    public int[] searchRange(int[] nums, int target) {
        BS(nums, target, 0);
        if (start == Integer.MAX_VALUE) start = -1;
        return new int[]{start, end};
    }

    private void BS(int[] part, int target, int prevLen) {
        if (part.length == 0) return;
        if (part.length == 1) {
            if (part[0] == target) {
                start = Math.min(prevLen, start);
                end = Math.max(prevLen, end);
            }
            return;
        }
        int midIdx = part.length/2;
        if (part[midIdx] > target) BS(Arrays.copyOfRange(part, 0, midIdx), target, prevLen);
        else if (part[midIdx] < target) BS(Arrays.copyOfRange(part, midIdx, part.length), target, midIdx+prevLen);
        else {
            start = Math.min(prevLen+midIdx, start);
            end = Math.max(prevLen+midIdx, end);
            BS(Arrays.copyOfRange(part, 0, midIdx), target, prevLen);
            BS(Arrays.copyOfRange(part, midIdx, part.length), target, midIdx+prevLen);
        }
    }
}
