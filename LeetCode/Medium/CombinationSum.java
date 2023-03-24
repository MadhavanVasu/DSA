package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSum {

    public static List<List<Integer>> helper(int i, int target, int[] candidates, int n) {
        if (i >= n)
            return new ArrayList<>();
        if (i == n - 1 && candidates[i] > target) {
            return new ArrayList<>();
        }
        List<List<Integer>> res1;
        List<List<Integer>> result = new ArrayList<>();
        if (candidates[i] < target) {
            res1 = helper(i, target - candidates[i], candidates, n);
            if (!res1.isEmpty()) {
                for (List<Integer> x : res1) {
                    List<Integer> temp = new ArrayList<>(x);
                    temp.add(candidates[i]);
                    result.add(temp);
                }
            }
        } else if (target == candidates[i]) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            result.add(list);
        }
        List<List<Integer>> res2 = helper(i + 1, target, candidates, n);
        if (!res2.isEmpty()) {
            result.addAll(res2);
        }
        return result;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> tempRes = helper(0, target, candidates, candidates.length);
        Set<List<Integer>> set = tempRes.stream().collect(Collectors.toSet());
        List<List<Integer>> result = set.stream().collect(Collectors.toList());

        for (List<Integer> x : result)
            Collections.reverse(x);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {3, 2};
        int target = 6;
        System.out.println(combinationSum(candidates, target));
    }

}
