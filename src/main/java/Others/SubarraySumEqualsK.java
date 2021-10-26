package Others;

import java.util.HashMap;
import java.util.Map;

// 560
// a+b=c => a = c-b
// Map: {Running sum - k, freq}

public class SubarraySumEqualsK {
    public int solutions(int[] nums, int k) {
        int ret = 0;
        int sum = 0;
        Map<Integer, Integer> sumsMap = new HashMap<>();
        sumsMap.put(0, 1);
        for (int i=0; i<nums.length; ++i) {
            sum += nums[i];
            ret += sumsMap.getOrDefault(sum-k, 0);
            sumsMap.put(sum, sumsMap.getOrDefault(sum, 0)+1);
        }
        //System.out.println(sumsMap.toString());
        return ret;
    }
}
