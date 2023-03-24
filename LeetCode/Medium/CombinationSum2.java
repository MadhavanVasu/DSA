package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Yet to be solved

public class CombinationSum2 {

    public static void helper(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int start)
    {
        if(target<0)
            return;
        if(target==0)
            result.add(new ArrayList<>(temp));
        else{
            for(int i=start; i<candidates.length; i++)
            {
                if(i>start && candidates[i]==candidates[i-1])
                    continue;
                temp.add(candidates[i]);
                helper(result, temp, candidates, target-candidates[i],i+1);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), candidates, target, 0);
        return result;

    }

    public static void main(String[] args) {
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
        System.out.println(combinationSum2(candidates, target));
    }


}
