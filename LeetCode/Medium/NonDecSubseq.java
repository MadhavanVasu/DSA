package LeetCode.Medium;

import java.util.*;
import java.util.stream.Collectors;

public class NonDecSubseq {

    public static List<List<Integer>> helperFn(int i, int n, double prev, int[] nums, Map<Integer, List<List<Integer>>> dp) {
        if (i == n - 1) {
            if (nums[i] >= prev) {
                List<Integer> res = new ArrayList<>() {
                    {
                        add(nums[i]);
                    }
                };
                List<List<Integer>> result = new ArrayList<>();
                result.add(res);
                return result;
            }
            return null;
        }
        List<List<Integer>> dpList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (prev == Double.POSITIVE_INFINITY || nums[i] >= prev) {
            if (dp.containsKey(i)) {
                result.addAll(dp.get(i));
            }
            else {
                List<List<Integer>> res1 = helperFn(i + 1, n, nums[i], nums, dp);
                if (res1 != null) {
                    for (List<Integer> x : res1) {
                        x.add(0, nums[i]);
                        dpList.add(x);
                        result.add(x);
                    }
                }
                dp.put(i, dpList);

            }
        }
        List<List<Integer>> res2 = helperFn(i + 1, n, Double.POSITIVE_INFINITY, nums, dp);
        List<List<Integer>> res3 = helperFn(i + 1, n, prev, nums, dp);
        if (res2 != null) {
            for (List<Integer> x : res2) {
                result.add(x);
            }
        }
        if (res3 != null) {
            for (List<Integer> x : res3) {
                result.add(x);
            }
        }
        List<Integer> tempRes = new ArrayList<>();
        if (nums[i] >= prev) {
            tempRes.add(nums[i]);
            result.add(tempRes);
        }
        for(Integer x : dp.keySet())
        {
            System.out.println(x + " " + Arrays.toString(dp.get(x).toArray()));
        }
        return result;

    }

    public static List<List<Integer>> findSubsequences(int[] nums) {

        List<List<Integer>> res = helperFn(0, nums.length, Double.POSITIVE_INFINITY, nums, new HashMap<>());
        Set<List<Integer>> temp = res.stream().collect(Collectors.toSet());
        res = temp.stream().collect(Collectors.toList());
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> x : res) {
            if (x.size() > 1)
                result.add(x);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<List<Integer>> result = findSubsequences(nums);
        for (List<Integer> x : result) {
            System.out.println(Arrays.toString(x.toArray()));
        }

    }

}
