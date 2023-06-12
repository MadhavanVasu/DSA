package LeetCode.Easy;

public class LexicographicallySmallestPalindrome {

    public String makeSmallestPalindrome(String s) {

        int n = s.length();
        if (n == 1) return s;
        StringBuilder sb = new StringBuilder(s);
        int i = n / 2 - 1;
        int j = (n - 1) / 2 + 1;
        while (i >= 0 && j < n) {
            if (sb.charAt(i) != sb.charAt(j)) {
                sb.setCharAt(i, (char) Math.min(sb.charAt(i), sb.charAt(j)));
                sb.setCharAt(j, sb.charAt(i));
            }
            i--;
            j++;
        }
        return sb.toString();
    }

}
