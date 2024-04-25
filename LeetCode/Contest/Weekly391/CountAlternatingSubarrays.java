package LeetCode.Contest.Weekly391;

public class CountAlternatingSubarrays {

    public long countAlternatingSubarrays(int[] nums) {
        long count = 1;
        long result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) count++;
            else {
                result += (count * (count + 1)) / 2;
                count = 1;
            }
        }
        result += (count * (count + 1)) / 2;
        return result;
    }

    public static void main(String[] args) {

    }

}
