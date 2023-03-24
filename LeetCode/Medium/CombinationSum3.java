package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void helper(int i, int sum, List<Integer> temp, List<List<Integer>> result, int k, int n) {
        if (sum == 0 && k == 0)
            result.add(new ArrayList<>(temp));
        else {
            for (int j = i; j <=9; j++) {
                if (j > sum)
                    break;
                temp.add(j);
                helper(j + 1, sum - j, temp, result, k - 1, n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();
        helper(1, n, new ArrayList<>(), result, k, n);
        return result;
    }

    public static void main(String[] args) {

        int k = 3;
        int n = 7;
        System.out.println(combinationSum3(k, n));

    }

}
