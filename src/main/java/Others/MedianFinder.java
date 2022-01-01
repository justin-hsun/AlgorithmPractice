package Others;

// 295
// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> left = new PriorityQueue<>((b, a) -> a-b);
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a-b);

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (left.size() == 0 && right.size() == 0) left.add(num);
//        else if (left.size() == 0 && num <= right.peek()) left.add(num);
//        else if (left.size() == 0 && num > right.peek()) right.add(num);
        else if (right.size() == 0 && num > left.peek()) right.add(num);
        else if (right.size() == 0 && num <= left.peek()) left.add(num);
        else if (num <= right.peek()) left.add(num);
        else right.add(num);
        balance();
    }

    public double findMedian() {
        int n = left.size()+right.size();
        if (n == 0) return 0.0;
        else if (n == 1 && left.size() == 1) return left.peek().doubleValue();
        else if (n == 1 && right.size() == 1) return right.peek().doubleValue();
        else if ((n % 2) == 0) return (left.peek().doubleValue() + right.peek().doubleValue())/2.0;
        else if (left.size() > right.size()) return left.peek().doubleValue();
        else return right.peek().doubleValue();
    }

    private void balance() {
        while (left.size() - right.size() > 1) {
            right.add(left.poll());
        }
        while (right.size() - left.size() > 1) {
            left.add(right.poll());
        }
    }

}
