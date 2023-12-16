package Gfg.Medium;

public class NumberOfSubarrayWithMaximumValue {

    static long countSubarrays(int a[], int n, int L, int R) {
        int start = 0;
        int lastValid = -1;
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= L && a[i] <= R) {
                if (start == -1) start = i;
                lastValid = i;
                result += (i - start + 1);
            } else if (a[i] < L) {
                if(start == -1) start = i;
                if(lastValid != -1) result += (lastValid - start + 1);
            } else {
                start = -1;
                lastValid = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
