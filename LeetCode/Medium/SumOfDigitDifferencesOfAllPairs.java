package LeetCode.Medium;

public class SumOfDigitDifferencesOfAllPairs {

    public long sumDigitDifferences(int[] nums) {
        int numOfDigits = (int) (Math.floor(Math.log10(nums[0])) + 1);
        int[][] freqArr = new int[numOfDigits][10];
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int place = numOfDigits - 1;
            while (num > 0) {
                int rem = num % 10;
                result += (i - freqArr[place][rem]);
                freqArr[place][rem]++;
                num /= 10;
                place--;
            }

        }
        return result;
    }

    public static void main(String[] args) {

    }

}
