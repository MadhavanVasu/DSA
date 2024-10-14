package LeetCode.Contest.Weekly416;

public class CountSubstringsThatCanBeRearrangedToContainTheString1 {

    public long validSubstringCount(String word1, String word2) {
        long result = 0;
        int[] charFreqWord2 = new int[26];
        for (char c : word2.toCharArray()) charFreqWord2[c - 'a']++;
        int start = 0;
        int n = word1.length();
        int[] charFreqWord1 = new int[26];
        for (int i = 0; i < n; i++) {
            charFreqWord1[word1.charAt(i) - 'a']++;
            boolean prefixFound = true;
            for (int j = 0; j < 26; j++) {
                if (charFreqWord1[j] < charFreqWord2[j]) {
                    prefixFound = false;
                    break;
                }
            }
            if (prefixFound) {
                result += (n - i);
                while (start <= i) {
                    charFreqWord1[word1.charAt(start) - 'a']--;
                    prefixFound = true;
                    for (int j = 0; j < 26; j++) {
                        if (charFreqWord1[j] < charFreqWord2[j]) {
                            prefixFound = false;
                            break;
                        }
                    }
                    start++;
                    if (prefixFound) result += (n - i);
                    else break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
