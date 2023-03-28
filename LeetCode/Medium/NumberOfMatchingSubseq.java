package LeetCode.Medium;

public class NumberOfMatchingSubseq {

    public static boolean isSubsequenceMatching(int i, int j, String s, String word, int n, int m) {
        if (j >= m)
            return true;
        if (i >= n)
            return false;
        if (s.charAt(i) == word.charAt(j)) {
            return isSubsequenceMatching(i + 1, j + 1, s, word, n, m);
        } else
            return isSubsequenceMatching(i + 1, j, s, word, n, m);
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        for (String x : words) {
            if (isSubsequenceMatching(0, 0, s, x, s.length(), x.length()))
                result += 1;
        }
        return result;

    }

    public static void main(String[] args) {

        String s = "dsahjpjauf";
        String[] words = { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" };
        System.out.println(numMatchingSubseq(s, words));

    }
}
