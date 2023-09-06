package LeetCode.Contest.Weekly360;

import java.util.HashSet;
import java.util.Set;

public class MinimumPossibleSumOfBeautifulArray {

    public long minimumPossibleSum(int n, int target) {

        Set<Integer> set = new HashSet<>();
        long sum = 0;
        int i = 1;
        while (n > 0) {
            if (!set.contains(i)) {
                sum += i;
                set.add(target - i);
                n--;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {

    }

}
