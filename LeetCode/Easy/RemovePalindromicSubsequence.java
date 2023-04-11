package LeetCode.Easy;

public class RemovePalindromicSubsequence {

    public static boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }

    public static int removePalindromeSub(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return n;
        if (validPalindrome(s)) return 1;
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("babad"));
        System.out.println(removePalindromeSub("cbbd"));
    }

}
