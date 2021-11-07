package DivideAndConquer;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
// 33
// Divide and conquer

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        return findIdx(nums, target);
    }

    private int findIdx(int[] nums, int t) {
        if (nums.length == 1) {
            if (nums[0] == t) return 0;
            return -1;
        }
        if (nums.length == 2) {
            if (nums[0] == t) return 0;
            if (nums[1] == t) return 1;
            return -1;
        }
        if (nums[nums.length-1] > nums[0]) { // not shifted
            if (t >= nums[0] && t <= nums[nums.length-1]) {
                int[] numsLeft = new int[nums.length/2];
                int[] numsRight = new int[nums.length-nums.length/2];
                for (int i=0; i<nums.length/2; ++i) {
                    numsLeft[i] = nums[i];
                }
                for (int i=0; i<nums.length-nums.length/2; ++i) {
                    numsRight[i] = nums[nums.length/2+i];
                }
                var left = findIdx(numsLeft, t);
                if (left != -1) return left;
                var right = findIdx(numsRight, t);
                if (right != -1) return numsLeft.length + right;
                return -1;
            } else {
                return -1;
            }
        } else { // shift
            if (nums[nums.length-1] < t && nums[0] > t) {
                return -1;
            } else {
                int[] numsLeft = new int[nums.length/2];
                int[] numsRight = new int[nums.length-nums.length/2];
                for (int i=0; i<nums.length/2; ++i) {
                    numsLeft[i] = nums[i];
                }
                for (int i=0; i<nums.length-nums.length/2; ++i) {
                    numsRight[i] = nums[nums.length/2+i];
                }
                var left = findIdx(numsLeft, t);
                if (left != -1) return left;
                var right = findIdx(numsRight, t);
                if (right != -1) return numsLeft.length + right;
                return -1;
            }
        }
    }
}
