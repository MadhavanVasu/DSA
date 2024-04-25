package LeetCode.Contest.Weekly394;

public class CountNumberOfSpecailCharacter1 {
    public int numberOfSpecialChars(String word) {
        int[] lowerFreq = new int[26];
        int[] upperFreq = new int[26];
        for (Character x : word.toCharArray()) {
            if (x >= 65 && x <= 90) upperFreq[x - 'A']++;
            else lowerFreq[x - 'a']++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (lowerFreq[i] != 0 && upperFreq[i] != 0) result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
