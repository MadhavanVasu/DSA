package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tempSubsets = new ArrayList<>();
            for (List<Integer> x : result) {
                List<Integer> subset = new ArrayList<>(x);
                subset.add(nums[i]);
                tempSubsets.add(subset);
            }
            result.addAll(tempSubsets);
        }
        return result;
    }

}
