package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class SplitAStringIntoMaximumNumberOfUniqueSubstrings {

    public int helper(int i, String s, int n, Set<String> uniqueStrings) {
        if (i == n) return 0;

        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < n; j++) {
            sb.append(s.charAt(j));
            if (!uniqueStrings.contains(sb.toString())) {
                uniqueStrings.add(sb.toString());
                int count = helper(j + 1, s, n, uniqueStrings);
                if (count != Integer.MIN_VALUE)
                    max = Math.max(max, count + 1);
                uniqueStrings.remove(sb.toString());
            }
        }
        return max;
    }

    public int maxUniqueSplit(String s) {
        return helper(0, s, s.length(), new HashSet<>());
    }

}
