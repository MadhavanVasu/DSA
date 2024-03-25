package LeetCode.Medium;

public class MinimumLengthOfStringAfterDeletingEnds {

    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                while (start == 0 || start < s.length() || s.charAt(start) != s.charAt(start - 1)) {
                    start++;
                }
                while (true) {
                    end--;
                    if (s.charAt(end) != s.charAt(end + 1)) break;
                }
            } else return end - start + 1;
        }
        if (start > end) return 0;
        return 1;
    }

    public static void main(String[] args) {

    }

}
