package LeetCode.Medium;

public class KthSymbolInGrammar {

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        else {
            int ans = kthGrammar(n - 1, (int) Math.ceil((double) k / 2));
            if (ans == 0) {
                if (k % 2 == 1) return 0;
                return 1;
            } else {
                if (k % 2 == 1) return 1;
                return 0;
            }
        }
    }

    public static void main(String[] args) {

    }

}
