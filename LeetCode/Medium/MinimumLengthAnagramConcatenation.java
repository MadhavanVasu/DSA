package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumLengthAnagramConcatenation {

    public boolean isFeasible(String s, int k) {
        char[] charFreq = new char[26];
        for (int i = 0; i < k; i++) {
            charFreq[s.charAt(i) - 'a']++;
        }
        for (int i = k; i <= s.length() - k; i += k) {
            char[] anagramFreq = new char[26];
            for (int j = i; j < i + k; j++) anagramFreq[s.charAt(j) - 'a']++;
            for (int j = 0; j < 26; j++) {
                if (charFreq[j] != anagramFreq[j]) return false;
            }
        }
        return true;
    }

    public int minAnagramLength(String s) {
        int n = s.length();
        List<Integer> feasibleLengths = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) feasibleLengths.add(i);
        }
        int start = 0;
        int end = feasibleLengths.size() - 1;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(s, feasibleLengths.get(mid))) {
                if (feasibleLengths.get(mid) < result) result = feasibleLengths.get(mid);
                end = mid - 1;
            } else start = mid + 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
