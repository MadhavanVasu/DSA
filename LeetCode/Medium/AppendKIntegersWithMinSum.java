package LeetCode.Medium;

import java.util.Arrays;

public class AppendKIntegersWithMinSum {

    public static long minimalKSum(int[] nums, int k) {

        int min = 0;
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            if (k == 0)
                break;
            if (num == min) continue;
            int diff = num - min - 1;
            if (diff != 0) {
                if (diff >= k) {
                    diff = k;
                    k = 0;
                } else
                    k -= diff;
                long sum1 = ((long) min * (min + 1)) / 2;
                long sum2 = ((long) (min + diff) * (min + diff + 1)) / 2;
                sum += (sum2 - sum1);
            }
            min = num;
        }
        if (k != 0) {
            long sum1 = ((long) min * (min + 1)) / 2;
            long sum2 = ((long) (min + k) * (min + k + 1)) / 2;
            sum += (sum2 - sum1);
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {5, 6};
        int k = 6;
        System.out.println(minimalKSum(nums, k));

    }

}
