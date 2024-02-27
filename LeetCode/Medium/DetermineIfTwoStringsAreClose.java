package LeetCode.Medium;

public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] charCount1 = new int[26];
        int[] charCount2 = new int[26];
        for (char c : word1.toCharArray()) charCount1[c - 'a']++;
        for (char c : word2.toCharArray()) charCount2[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (charCount1[i] != charCount2[i]) {
                boolean found = false;
                int j;
                for (j = i + 1; j < 26; j++) {
                    if (charCount2[j] == charCount1[i]) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    int temp = charCount2[i];
                    charCount2[i] = charCount2[j];
                    charCount2[j] = temp;
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
