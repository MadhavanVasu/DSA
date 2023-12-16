package LeetCode.Medium;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int tempResult = 1;
            int next = i;
            for (int j = 0; j < m; j++) {
                if (next == n) {
                    tempResult++;
                    next = 0;
                }
                if (a.charAt(next) == b.charAt(j)) {
                    next++;
                } else {
                    tempResult = Integer.MAX_VALUE;
                    break;
                }
            }
            result = Math.min(result, tempResult);
        }
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    public static void main(String[] args) {

    }
}