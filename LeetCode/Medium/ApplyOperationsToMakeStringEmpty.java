package LeetCode.Medium;

public class ApplyOperationsToMakeStringEmpty {

    public String lastNonEmptyString(String s) {
        int[] allowedChar = new int[26];
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) {
            allowedChar[c - 'a']++;
            charFreq[c - 'a']++;
        }
        int maxFreq = 0;
        for (int x : charFreq) maxFreq = Math.max(maxFreq, x);
        maxFreq -= 1;
        for (int i = 0; i < 26; i++) {
            allowedChar[i] = Math.max(0, allowedChar[i] - maxFreq);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']--;
            if (allowedChar[c - 'a'] > 0 && charFreq[c - 'a'] == 0) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
