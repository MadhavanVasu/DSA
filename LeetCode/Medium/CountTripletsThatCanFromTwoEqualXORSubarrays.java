package LeetCode.Medium;

public class CountTripletsThatCanFromTwoEqualXORSubarrays {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < n; j++) {
                xor ^= arr[j];
                int a = 0;
                for (int k = i; k < j; k++) {
                    a ^= arr[k];
                    int b = xor ^ a;
                    if (a == b) result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
