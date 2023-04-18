package LeetCode.Easy;

public class MergeStringsAlternatively {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = word1.length();
        int m = word2.length();
        while (i < n || j < m) {
            if (i < n) sb.append(word1.charAt(i++));
            if (j < m) sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }

}
