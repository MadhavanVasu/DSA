package LeetCode.Medium;

import java.util.List;
import java.util.Map;

public class MaximumLengthOfConcatenatedString {

    public int helper(int i, List<String> arr, int[] charCount, int n) {
        if (i >= n) return 0;
        int a = 0;
        boolean flag = true;
        for (char c : arr.get(i).toCharArray()) {
            if (charCount[c - 'a'] == 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int[] charCountCopy = charCount.clone();
            for (char c : arr.get(i).toCharArray()) {
                charCountCopy[c - 'a']++;
                if (charCountCopy[c - 'a'] > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                a = arr.get(i).length() + helper(i + 1, arr, charCountCopy, n);
        }
        int b = helper(i + 1, arr, charCount, n);
        return Math.max(a, b);
    }

    public int maxLength(List<String> arr) {
        return helper(0, arr, new int[26], arr.size());
    }

    public static void main(String[] args) {

    }

}
