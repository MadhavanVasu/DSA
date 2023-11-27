package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInAnArray {

    public int rev(int n) {
        int reversedNumber = 0;
        while (n != 0) {
            int rem = n % 10;
            reversedNumber = reversedNumber * 10 + rem;
            n /= 10;
        }
        return reversedNumber;
    }

    public int countNicePairs(int[] nums) {
        long result = 0;
        int MOD = 1000000007;
        Map<Integer, Integer> differenceCountMap = new HashMap<>();
        for (int num : nums) {
            int diff = num - rev(num);
            System.out.println(diff);
            if (differenceCountMap.containsKey(diff)) {
                result = (result + differenceCountMap.get(diff)) % MOD;
            }
            differenceCountMap.put(diff, differenceCountMap.getOrDefault(diff, 0) + 1);
        }
        return (int) (result % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new CountNicePairsInAnArray().countNicePairs(new int[]{42, 11, 1, 97}));
    }
}
