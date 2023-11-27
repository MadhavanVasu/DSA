package LeetCode.Medium;

public class LongestPalindromicSubstring {

    public String helper(int i, int j, String s) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = helper(i - 1, i + 1, s);
            String s2 = helper(i, i + 1, s);
            if (s1.length() > result.length()) result = s1;
            if (s2.length() > result.length()) result = s2;
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
