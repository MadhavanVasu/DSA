package LeetCode.Medium;

public class ReplaceArrayElementsBySign {

    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int positivePointer = 0;
        int negativePointer = 1;
        for (int x : nums) {
            if (x < 0) {
                result[negativePointer] = x;
                negativePointer += 2;
            } else {
                result[positivePointer] = x;
                positivePointer += 2;
            }
        }
        return result;
    }

}
