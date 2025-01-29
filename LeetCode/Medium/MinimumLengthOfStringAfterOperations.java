package LeetCode.Medium;

public class MinimumLengthOfStringAfterOperations {

    public int minimumLength(String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) charFreq[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] >= 3) {
                if (charFreq[i] % 2 == 0) charFreq[i] = 2;
                else charFreq[i] = 1;
            }
        }
        int result = 0;
        for (int x : charFreq) result += x;
        return result;
    }

    public int minimumLengthOnePass(String s) {
        int[] charFreq = new int[26];
        int result = 0;
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
            result++;
            if (charFreq[c - 'a'] == 3) {
                result -= 2;
                charFreq[c - 'a'] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
    // 3 -> 1 0 -> 1
    // 4 -> 1 1 -> 2
    // 5 -> 1 2 -> 1
    // 6 -> 2 0 -> 2
    // 7 -> 2 1 -> 1
    // 8 -> 2 2 -> 2
    // 9 -> 3 0 -> 1
    // 10 -> 3 1 -> 2


    // aa

}
