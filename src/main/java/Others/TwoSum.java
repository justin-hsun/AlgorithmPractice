package Others;

import java.util.HashMap;
import java.util.Map;

// 1
// build map and check as we go

public class TwoSum {
    public int[] solutions(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (var num : nums) {
            if (map.containsKey(target - num)) {
                ret[0] = map.get(num);
                ret[1] = map.get(target-num);
                return ret;
            }
        }
        return ret;
    }
}
