package Others;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
// 215
// Top K ... -> only keep K elements in your data structure
// O(NLogK) by only keeping K elements in the heap

import java.util.PriorityQueue;

public class FindKthLargest {
    public int solutions(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> a-b);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }

        return heap.poll();
    }
}
