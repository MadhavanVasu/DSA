package LeetCode.Contest.Weekly393;

public class MaximumPrimeDifference {

    public int maximumPrimeDifference(int[] nums) {
        boolean[] sievePrimeTable = new boolean[101];
        for (int i = 2; i <= 100; i++) sievePrimeTable[i] = true;
        for (int i = 2; i <= 100; i++) {
            if (sievePrimeTable[i]) {
                for (int j = i * 2; j <= 100; j += i)
                    sievePrimeTable[j] = false;
            }
        }
        int startInd = -1;
        int endInd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sievePrimeTable[nums[i]]) {
                if (startInd == -1) startInd = i;
                endInd = i;
            }
        }
        return endInd - startInd;
    }

    public static void main(String[] args) {

    }

}
