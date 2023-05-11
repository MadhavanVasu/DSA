package LeetCode.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxNumberOfVowelsInSubstring {
    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < k; i++) if (vowels.contains(s.charAt(i))) vowelCount++;
        int max = vowelCount;
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) vowelCount--;
            if (vowels.contains(s.charAt(i))) vowelCount++;
            if (vowelCount > max) max = vowelCount;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
