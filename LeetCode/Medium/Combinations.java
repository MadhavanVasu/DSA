package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public void helper(int i, int n, int k, List<List<Integer>> combinations, List<Integer> combination) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
        } else if (i != n + 1) {
            combination.add(i);
            helper(i + 1, n, k, combinations, combination);
            combination.remove(combination.size() - 1);
            helper(i+1,n,k,combinations,combination);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1,n,k,result,new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {

    }

}
