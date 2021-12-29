package Graph;

// 39
// https://leetcode.com/problems/combination-sum/
// backtracking

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    public List<List<Integer>> solutions(int[] candidates, int target) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> ret = new ArrayList<>();
        for (int val : candidates) {
            if (val < target) lst.add(val);
            else if (val == target) ret.add(List.of(val));
        }
        backtrack(ret, new ArrayList<>(), lst, target, 0, 0);
        return ret;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, List<Integer> candidates, int target, int index, int sum) {
        if (sum > target) return;
        if (sum == target) combinations.add(new ArrayList<>(combination));
        else {
            for (int i = index; i < candidates.size(); ++i) {
                combination.add(candidates.get(i));
                backtrack(combinations, combination, candidates, target, i, sum + candidates.get(i));
                combination.remove(combination.size() - 1);
            }
        }
    }
}
