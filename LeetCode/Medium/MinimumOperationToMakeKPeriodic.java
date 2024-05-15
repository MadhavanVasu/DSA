package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationToMakeKPeriodic {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> stringCount = new HashMap<>();
        int n = word.length();
        int max = 0;
        int substrCount = n / k;
        for (int i = 0; i <= n - k; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) sb.append(word.charAt(j));
            stringCount.put(sb.toString(), stringCount.getOrDefault(sb.toString(), 0) + 1);
            if (stringCount.get(sb.toString()) > max) max = stringCount.get(sb.toString());
        }
        return substrCount - max;
    }

    public static void main(String[] args) {

    }


}
