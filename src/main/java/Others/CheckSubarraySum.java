package Others;

// 523

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {
    public boolean solutions(int[] nums, int k) {
        Map<Integer, Integer> runningSum = new HashMap<>();
        runningSum.put(0, -1);
        int sum = 0;
        boolean lastZero = false;
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] == 0){
                if (lastZero) return true;
                lastZero = true;
                continue;
            } else {
                lastZero = false;
            }
            sum += nums[i];
            if (runningSum.containsKey(sum%k) && runningSum.get(sum%k) < i-1) return true;
            runningSum.putIfAbsent(sum%k, i);
        }
        return false;
    }
}
