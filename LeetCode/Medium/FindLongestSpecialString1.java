package LeetCode.Medium;

public class FindLongestSpecialString1 {

    public int maximumLength(String s) {
        int n = s.length();
        int max = -1;
        for (int i = 1; i <= n; i++) {
            int[] charCount = new int[26];
            int count = 1;
            char prev = s.charAt(0);
            for (int j = 1; j < n; j++) {
                if (s.charAt(j) != prev) {
                    if (count >= i) {
                        int pos = prev - 'a';
                        charCount[pos] += (count - i - 1);
                        if (charCount[pos] >= 3) {
                            max = i;
                            break;
                        }
                    }
                    count = 0;
                    prev = s.charAt(j);
                }
                count++;
            }
            if (count >= i) {
                int pos = prev - 'a';
                charCount[pos] += (count - (i - 1));
                if (charCount[pos] >= 3)
                    max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new FindLongestSpecialString1().maximumLength("aaaa"));
    }

}
