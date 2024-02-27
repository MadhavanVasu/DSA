package LeetCode.Easy;

public class MissingNum {

    public int missingNumberUsingXOR(int[] nums) {
        int n = nums.length;
        int missingNum = 0;
        for (int i = 0; i <= n; i++) missingNum ^= i;
        for (int x : nums) missingNum ^= x;
        return missingNum;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int reqdSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for (int x : nums) actualSum += x;
        return reqdSum - actualSum;
    }

}
