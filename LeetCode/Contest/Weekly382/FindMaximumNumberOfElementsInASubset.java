package LeetCode.Contest.Weekly382;

import java.util.HashMap;
import java.util.Map;

public class FindMaximumNumberOfElementsInASubset {

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int result = 1;
        for (int x : nums) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        for (int x : freqMap.keySet()) {
            int freq = freqMap.get(x);
            if (x == 1) {
                if (freq % 2 != 0) {
                    if (freq > result) result = freq;
                } else if (freq - 1 > result) result = freq;
            } else {
                int i = 1;
                int len = 1;
                while (true) {
                    double ele = Math.pow(x, i);
                    System.out.println(ele);
                    if (freqMap.containsKey(ele)) {
                        int res = len + (len - 1);
                        if (res > result) result = res;
                        if (freqMap.get(ele) >= 2) {
                            i *= 2;
                            len++;
                        } else break;
                    } else break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new FindMaximumNumberOfElementsInASubset().maximumLength(new int[]{1, 16, 49, 16, 121}));

    }

}
