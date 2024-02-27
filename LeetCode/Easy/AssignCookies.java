package LeetCode.Easy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int result = 0;
        for (int k : g) {
            while (j < s.length) {
                if (k <= s[j]) {
                    result++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
