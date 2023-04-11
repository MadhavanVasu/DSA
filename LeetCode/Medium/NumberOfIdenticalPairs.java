package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > 1)
                result += map.get(i) - 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
