package IQns;

import java.util.HashSet;
import java.util.Set;

public class FindValidCombinations {

    public int helper(int i, Set<Integer> numSet, int rem, int A, int B, int prev) {
        if (i >= A) {
            return Integer.MAX_VALUE;
        }
        int ans = 0;
        for (int j = 1; j <= B; j++) {
            if (!numSet.contains(j) || prev != j) {
                numSet.add(j);
                int k = 0;
                if (rem == 0) ans++;
                else {
                    while (true) {
                        int tempAns = (helper(i + k + 1, numSet, rem - 1, A, B, j));
                        if (tempAns == Integer.MAX_VALUE) break;
                        ans += tempAns;
                        k++;
                    }
                }
                numSet.remove(j);
            }
        }
        return ans;
    }

    public long validCombinations(int A, int B, int C) {
        return helper(0, new HashSet<>(), C, A, B, -1);
    }

    public static void main(String[] args) {
        System.out.println(new FindValidCombinations().validCombinations(4, 4, 1));
    }

}
