package LeetCode.Medium;

public class SpecialArray2 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parentArr = new int[n];
        int parent = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] % 2 != nums[i - 1] % 2) {
                parentArr[i] = parent;
            } else {
                parentArr[i] = i;
                parent = i;
            }
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = parentArr[queries[i][0]] == parentArr[queries[i][1]];
        }
        return result;
    }
//    2 4 6 3 2
//    -2 -3 -4 -3 -2

    public static void main(String[] args) {

    }

}
