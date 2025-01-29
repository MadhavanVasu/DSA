package LeetCode.Medium;

public class CountSubstringWithKFrequencyCharacters1 {

    public int numberOfSubstrings(String s, int k) {
        int start = 0;
        int result = 0;
        int n = s.length();
        int[] charFreq = new int[26];
        for (int i = 0; i < n; i++) {
            int currChar = s.charAt(i);
            charFreq[currChar - 'a']++;
            if (charFreq[currChar - 'a'] == k) {
                result += (n - i);
                while (start <= i) {
                    charFreq[s.charAt(start) - 'a']--;
                    start++;
                    if (s.charAt(start - 1) != currChar) {
                        result += (n - i);
                    } else break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
