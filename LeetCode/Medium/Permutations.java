package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

// Using Backtracking
public class Permutations {

    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length)
            result.add(new ArrayList<>(temp));
        else {
            for (int num : nums) {
                if (temp.contains(num))
                    continue;
                temp.add(num);
                backtrack(result, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

}
