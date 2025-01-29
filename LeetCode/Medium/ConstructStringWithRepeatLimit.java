package LeetCode.Medium;

public class ConstructStringWithRepeatLimit {

    public String repeatLimitedString(String s, int repeatLimit) {
        StringBuilder sb = new StringBuilder();
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) charFreq[c - 'a']++;
        while (sb.length() != s.length()) {
            for (int j = 25; j >= 0; j--) {
                int prev = -1;
                if (sb.length() != 0) prev = sb.charAt(sb.length() - 1) - 'a';
                if (charFreq[j] > 0 && (prev == -1 || prev != j)) {
                    int repeat = repeatLimit;
                    while (charFreq[j] > 0 && repeat-- > 0) {
                        sb.append((char) j + 'a');
                        charFreq[j]--;
                    }
                    if (charFreq[j] > 0) {
                        for (int k = 25; k >= 0; k--) {
                            if (k != j && charFreq[k] > 0) {
                                sb.append((char) k + 'a');
                                charFreq[k]--;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
