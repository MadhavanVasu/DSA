package LeetCode.Medium;

public class FindLongestSpecialString2 {

    public boolean isFeasible(int len, String s, int n) {
        int[] charCount = new int[26];
        int count = 1;
        char prev = s.charAt(0);
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) != prev) {
                if (count >= len) {
                    int pos = prev - 'a';
                    charCount[pos] += (count - len - 1);
                    if (charCount[pos] >= 3) {
                        return true;
                    }
                }
                count = 0;
                prev = s.charAt(j);
            }
            count++;
        }
        if (count >= len) {
            int pos = prev - 'a';
            charCount[pos] += (count - (len - 1));
            return charCount[pos] >= 3;
        }
        return false;
    }

    public int maximumLength(String s) {
        int n = s.length();
        int start = 1;
        int end = n;
        int max = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(mid, s, n)) {
                if (mid > max) max = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return max;
    }

}
