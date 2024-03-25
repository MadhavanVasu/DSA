package LeetCode.Contest.Biweekly126;

public class ReplaceQuestionMarksInString {

    public String minimizeStringValue(String s) {
        int n = s.length();
        int[][] charSuffix = new int[n][26];
        int[] suffix = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '?')
                suffix[s.charAt(i) - 'a']++;
            int[] b = suffix.clone();
            charSuffix[i] = b;
        }
        int[] prefix = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '?') prefix[s.charAt(i) - 'a']++;
            else {
                int min = Integer.MAX_VALUE;
                char c = 'a';
                for (int j = 0; j < 26; j++) {
                    int currSum = prefix[j];
                    currSum += charSuffix[i][j] - 1;
                    if (currSum < min) {
                        min = currSum;
                        c = (char) (j + 'a');
                    }
                }
                sb.append(c);
                prefix[c - 'a']++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
