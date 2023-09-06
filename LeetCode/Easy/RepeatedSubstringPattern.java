package LeetCode.Easy;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            int j = i + 1;
            boolean flag = true;
            if (n % (i + 1) == 0) {
                while (j < n) {
                    if (s.charAt(j % (i + 1)) != s.charAt(j)) {
                        flag = false;
                        break;
                    }
                    j++;
                }
                if (flag) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
