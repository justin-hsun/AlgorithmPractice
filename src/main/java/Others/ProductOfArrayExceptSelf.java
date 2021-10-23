package Others;

// 238
// Edge case matters
// division of zero trigger

public class ProductOfArrayExceptSelf {
    public int[] solutions(int[] nums) {
        int sum = 1;
        int zeroCnt = 0;
        int[] ret = new int[nums.length];
        for (int num : nums) {
            if (num == 0) zeroCnt += 1;
        }
        for (int num : nums) {
            if (num != 0) sum = sum * num;
        }
        for (int i=0; i<nums.length; ++i) {
            if (nums[i] == 0 && zeroCnt > 1) ret[i] = 0;
            else if (nums[i] == 0) ret[i] = sum;
            else if (zeroCnt > 0) ret[i] = 0;
            else ret[i] = sum / nums[i];
        }
        return ret;
    }
}
