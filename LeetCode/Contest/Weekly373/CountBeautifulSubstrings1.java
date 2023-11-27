package LeetCode.Contest.Weekly373;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountBeautifulSubstrings1 {

    public int beautifulSubstrings(String s, int k) {

        int n = s.length();
        int[] vowelsPrefixSum = new int[n];
        int[] consonantsPrefixSum = new int[n];
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int vowelsSum = 0;
        int consonantsSum = 0;
        for (int i = 0; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelsSum++;
            } else consonantsSum++;
            vowelsPrefixSum[i] = vowelsSum;
            consonantsPrefixSum[i] = consonantsSum;
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                vowelsSum = vowelsPrefixSum[j] - (i == 0 ? 0 : vowelsPrefixSum[i - 1]);
                consonantsSum = consonantsPrefixSum[j] - (i == 0 ? 0 : consonantsPrefixSum[i - 1]);
                if (vowelsSum == consonantsSum && (vowelsSum * consonantsSum) % k == 0) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
