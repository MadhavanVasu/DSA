package IQns;

public class ValidPasswords {

    public int countValidPasswords(int n, int k) {
        int result = 1;
        int MOD = 1000000007;
        for (int i = 0; i < n; i++) result = (result * 26) % MOD;
        if (n == k) return (result - 26) % MOD;
        int reducer = 1;
        for (int i = 0; i < k; i++) reducer = (reducer * (26 - i)) % MOD;
        for (int i = 1; i < n; i++) {
            result -= reducer;
        }
        result -= 26;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPasswords().countValidPasswords(4,2));
    }


}
