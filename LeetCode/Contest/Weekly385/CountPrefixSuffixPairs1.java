package LeetCode.Contest.Weekly385;

public class CountPrefixSuffixPairs1 {

    public boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.length() > str2.length()) return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
            if (str1.charAt(i) != str2.charAt(str2.length() - str1.length() + i)) return false;
        }
        return true;
    }

    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
