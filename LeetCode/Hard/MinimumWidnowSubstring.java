package LeetCode.Hard;

public class MinimumWidnowSubstring {

    public String minWindow(String s, String t) {
        int[] tCharFreqUpper = new int[26];
        int[] tCharFreqLower = new int[26];
        for (char x : t.toCharArray()) {
            if (x >= 65 && x <= 90) tCharFreqUpper[x - 'A']++;
            else tCharFreqLower[x - 'a']++;
        }
        int[] windowCharFreqLower = new int[26];
        int[] windowCharFreqUpper = new int[26];
        int start = -1;
        int end = -1;
        int currStart = 0;
        int currEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) windowCharFreqUpper[s.charAt(i) - 'A']++;
            else windowCharFreqLower[s.charAt(i) - 'a']++;
            currEnd = i;
            while (true) {
                boolean flag = true;
                for (int j = 0; j < 26; j++) {
                    if (windowCharFreqLower[j] < tCharFreqLower[j] || windowCharFreqUpper[j] < tCharFreqUpper[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (start == -1 || end - start > currEnd - currStart) {
                        start = currStart;
                        end = currEnd;
                    }
                } else break;
                if (s.charAt(currStart) >= 65 && s.charAt(currStart) <= 90) windowCharFreqUpper[s.charAt(currStart) - 'A']--;
                else windowCharFreqLower[s.charAt(currStart) - 'a']--;
                currStart++;
            }
        }
        if (start == -1) return "";
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWidnowSubstring().minWindow("ADOBECODEBANC", "ABC"));
    }

}
