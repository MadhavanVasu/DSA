package LeetCode.Contest.Weekly348;

public class SemiOrderedPerumutation {

    public int semiOrderedPermutation(int[] nums) {

        int n = nums.length;
        if (nums[0] == 1 && nums[n - 1] == n) return 0;
        int pos1 = -1;
        int posN = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                pos1 = i;
            if (nums[i] == n)
                posN = i;
        }
        int count = (pos1 + (n - 1 - posN));
        if (posN < pos1) count -= 1;
        return count;
    }

    public static void main(String[] args) {

    }

}
