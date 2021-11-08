package Others;

// https://leetcode.com/problems/divide-two-integers/
// 29
// power of 2 to get logN time

import java.util.*;

public class DivideTwoIntegers {
    public class Pair {
        int powerOfTwo;
        int val;
        public Pair(int a, int b) {
            powerOfTwo = a;
            val = b;
        }
    }
    public int divide(int dividend, int divisor) {
        boolean negative = false;
        int ret = 0;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) negative = true;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend < divisor) return 0;
        List<Pair> lst = new ArrayList<>();
        int twoPower = 1;
        while (divisor <= dividend) {
            lst.add(new Pair(twoPower, divisor));
            twoPower += twoPower;
            divisor += divisor;
        }
        for (int i=lst.size()-1; i>=0; --i) {
            if (lst.get(i).val <= dividend) {
                dividend -= lst.get(i).val;
                ret += lst.get(i).powerOfTwo;
            }
        }

        if (negative) return -ret;
        return ret;
    }
}
