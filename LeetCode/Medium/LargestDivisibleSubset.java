//package LeetCode.Medium;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class LargestDivisibleSubset {
//
//    List<Integer> maxResult = new ArrayList<>();
//
//    public List<Integer> helper(int i, int prev, int[] nums, List<List<List<Integer>>> dp, int n, List<Integer> result) {
//        if (i >= n) {
//            if (result.size() > maxResult.size()) maxResult = new ArrayList<>(result);
//            return result;
//        }
//        List<Integer> a = new ArrayList<>();
//        if (prev != -1 && nums[i] % nums[prev] == 0) {
//            List<Integer> temp = new ArrayList<>(result);
//            temp.add(nums[i]);
//            a = helper(i + 1, i, nums, dp, n, temp);
//        }
//        List<Integer> b = helper(i + 1, prev, nums, dp, n, new ArrayList<>(result));
//        if (a.size() > b.size()) {
//            dp.get(i).get(prev).add(a);
//        } else dp.get(i).get(prev).add(b);
//    }
//
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        List<List<List<Integer>>> dp = new ArrayList<>();
//
//        helper(0, -1, nums, dp, n, new ArrayList<>());
//        return maxResult;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
//    }
//
//}
