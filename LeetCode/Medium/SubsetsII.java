package LeetCode.Medium;

import java.util.*;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int i = nums.length - 1;
        while (i >= 0) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> x : result) {
                List<Integer> copy = new ArrayList<>(x);
                copy.add(nums[i]);
                temp.add(copy);
            }
            for (List<Integer> x : temp)
                result.add(x);
            List<Integer> t = new ArrayList<>();
            t.add(nums[i]);
            result.add(t);
            i--;
        }
        List<List<Integer>> mainList = new ArrayList<>();
        mainList.addAll(result);
        mainList.add(new ArrayList<>());
        return mainList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> x : res) {
            System.out.println(Arrays.toString(x.toArray()));
        }

    }

}
