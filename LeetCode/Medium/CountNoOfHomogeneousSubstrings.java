package LeetCode.Medium;

public class CountNoOfHomogeneousSubstrings {


    public int countHomogenous(String s) {
        int MOD = 1000000007;
        int n = s.length();
        int result = 0;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(prev)) {
                int count = i - prev;
                result = (result + ((count * ((count + 1) % MOD)) % MOD) / 2) % MOD;
                prev = i;
            }
        }
        int count = n - prev;
        result = (int) (result + ((count * ((long) (count + 1) % MOD)) % MOD) / 2) % MOD;
        return result;
    }

    public static void main(String[] args) {

    }

}
