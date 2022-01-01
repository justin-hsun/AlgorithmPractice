package Others;

import java.util.*;

public class MergeIntervals {
    public int[][] solutions(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        List<List<Integer>> ret = new ArrayList<>();
        int[] curr = {-1, -1};
        for (int[] interval : intervals) {
            if (curr[0] == -1 && curr[1] == -1) curr = interval;
            else if (interval[0] > curr[1]) {
                ret.add(List.of(curr[0], curr[1]));
                curr[0] = -1;
                curr[1] = -1;
            }
            else curr[1] = Math.max(interval[1], curr[1]);
        }
        int[][] res = new int[ret.size()][2];
        for (int i=0; i<res.length; ++i) {
            res[i][0] = ret.get(i).get(0);
            res[i][1] = ret.get(i).get(1);
        }
        return res;
    }
}
