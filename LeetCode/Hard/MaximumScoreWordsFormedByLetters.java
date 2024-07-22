package LeetCode.Hard;

public class MaximumScoreWordsFormedByLetters {

    public int helper(int i, String[] words, int n, int[] charFreq, int[] score) {
        if (i == n) return 0;
        int a = 0;
        int[] currFreq = new int[26];
        for (char c : words[i].toCharArray()) currFreq[c - 'a']++;
        boolean flag = true;
        for (int j = 0; j < 26; j++) {
            if (charFreq[j] < currFreq[j]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int currScore = 0;
            for (int j = 0; j < 26; j++) {
                currScore += score[j] * currFreq[j];
                charFreq[j] -= currFreq[j];
            }
            a = currScore + helper(i + 1, words, n, charFreq, score);
            for (int j = 0; j < 26; j++) {
                charFreq[j] += currFreq[j];
            }
        }
        int b = helper(i + 1, words, n, charFreq, score);
        return Math.max(a, b);
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] charFreq = new int[26];
        for (char c : letters) charFreq[c - 'a']++;
        return helper(0, words, words.length, charFreq, score);
    }


}
