package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> solutions(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, new ArrayList<>(), convert(nums));
        return ret;
    }

    private void backtrack(List<List<Integer>> permutations, List<Integer> combination, List<Integer> nums) {
        if (combination.size() == nums.size()) permutations.add(new ArrayList<>(combination));
        else {
            List<Integer> tmp = new ArrayList<>(nums);
            tmp.removeAll(combination);
            for (int val : tmp) {
                combination.add(val);
                backtrack(permutations, combination, nums);
                combination.remove(combination.size()-1);
            }
        }
    }

    private List<Integer> convert(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int num : nums) {
            ret.add(num);
        }
        return ret;
    }
}
