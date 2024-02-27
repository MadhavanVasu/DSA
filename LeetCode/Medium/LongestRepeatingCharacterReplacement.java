package LeetCode.Medium;

public class LongestRepeatingCharacterReplacement {

    public int findMaxForEachChar(String s, char c, int k) {
        int max = 0;
        int start = 0;
        int i = 0;
        int counter = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) != c) {
                if (counter == k) {
                    int len = i - start;
                    if (len > max) max = len;
                    while (start <= i) {
                        if (s.charAt(start) != c) {
                            start += 1;
                            break;
                        }
                        start++;
                    }
                }
                counter++;
            }
        }
        int len = i - start;
        if (len > max) max = len;
        return max;
    }

    public int characterReplacementEfficient(String s, int k) {
        int max = 0;
        for (int i = 0; i < 26; i++) {
            int tempMax = findMaxForEachChar(s, (char) ('A' + i), k);
            if (tempMax > max) max = tempMax;
        }
        return max;
    }

    public boolean isFeasible(String s, int l, int k) {
        int[] charFreqArr = new int[26];
        for (int i = 0; i < l; i++) charFreqArr[s.charAt(i) - 'A']++;
        for (int x : charFreqArr) {
            if (x == l || l - x <= k) return true;
        }
        for (int i = l; i < s.length(); i++) {
            charFreqArr[s.charAt(i - l) - 'A']--;
            charFreqArr[s.charAt(i) - 'A']++;
            for (int x : charFreqArr) {
                if (x == l || l - x <= k) return true;
            }
        }
        return false;
    }

    public int characterReplacement(String s, int k) {
        int start = 1;
        int end = s.length();
        int max = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(s, mid, k)) {
                if (mid > max) max = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("ABAA", 0));
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABCACCC", 4));

    }

}
