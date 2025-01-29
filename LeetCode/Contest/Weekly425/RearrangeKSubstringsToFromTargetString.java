package LeetCode.Contest.Weekly425;

import java.util.HashMap;
import java.util.Map;

public class RearrangeKSubstringsToFromTargetString {

    public boolean isPossibleToRearrange(String s, String t, int k) {
        Map<String, Integer> substringMap = new HashMap<>();
        int n = s.length();
        k = n / k;
        for (int i = 0; i < n - k; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) sb.append(s.charAt(j));
            substringMap.put(sb.toString(), substringMap.getOrDefault(sb.toString(), 0) + 1);
        }
        for (int i = 0; i < n - k; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + k; j++) sb.append(t.charAt(j));
            if (substringMap.containsKey(sb.toString()) && substringMap.get(sb.toString()) > 0) {
                substringMap.put(sb.toString(), substringMap.get(sb.toString()) - 1);
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
