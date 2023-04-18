package LeetCode.Easy;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;
        int n = s.length();
        int m = t.length();
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == n;

    }

    public static void main(String[] args) {

    }

}
