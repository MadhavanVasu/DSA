package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = l[i]; j <= r[i]; j++) {
                if (nums[j] < a) {
                    if (a < b) b = a;
                    a = nums[j];
                } else if (nums[j] < b) b = nums[j];
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }
            int d = b - a;
            map.put(a, map.get(a) - 1);
            int j = l[i] + 1;
            boolean isSequence = true;
            while (j <= r[i]) {
                if (map.containsKey(a + d) && map.get(a + d) > 0) {
                    map.put(a + d, map.get(a + d) - 1);
                    a += d;
                } else {
                    isSequence = false;
                    break;
                }
                j++;
            }
            result.add(isSequence);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new ArithmeticSubarrays().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));

    }

}
