package LeetCode.Medium;

public class GrumpyBookstoreOwner {

    // O(N) -> Sliding Window
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxUnsatisfied = 0;
        int currStart = 0;
        int currUnsatisfied = 0;
        int n = customers.length;
        for (int i = 0; i <= n; i++) {
            if (i - currStart == minutes) {
                if (currUnsatisfied > maxUnsatisfied) {
                    maxUnsatisfied = currUnsatisfied;
                }
                if (grumpy[currStart] == 1)
                    currUnsatisfied -= customers[currStart];
                currStart = currStart + 1;
            }
            if (i < n && grumpy[i] == 1) currUnsatisfied += customers[i];
        }
        int result = maxUnsatisfied;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                result += customers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
