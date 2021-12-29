package AmazonOA;

import java.util.*;

public class WinningSequence {
    public List<Integer> winningSequence(int n, int lower, int upper){
        if ((upper - lower)*2+1 < n) {
            return List.of(-1);
        }

        int[][] c;
        Arrays.sort(c, (a,b) -> a[1]-b[1]);

        if ((upper-lower+1) >= (n-1)) {
            List<Integer> ret = new ArrayList<>();
            ret.add(upper-1);
            int i = 0;
            while (ret.size() < n) {
                ret.add(upper-i);
                i++;
            }
            return ret;
        } else {
            List<Integer> ret = new ArrayList<>();
            int frontLen = n - (upper - lower + 1);
            for (int i=upper-frontLen; i<upper; ++i) {
                ret.add(i);
            }
            int j = 0;
            while (ret.size() < n) {
                ret.add(upper-j);
                j++;
            }
            return ret;
        }
    }
}
