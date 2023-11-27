package LeetCode.Contest.Biweekly113;

import java.util.List;

public class MinimumRightShifts {

    public int minimumRightShifts(List<Integer> nums) {

        if (nums.size() == 1) return 0;

        int start = -1;
        int end = -1;
        int min = -1;

        boolean flag = false;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                if (!flag) {
                    min = nums.get(0);
                    flag = true;
                    start = i + 1;
                    end = i + 1;
                } else return -1;
            } else {
                if (flag) {
                    if (nums.get(i + 1) > min) return -1;
                    end = i + 1;
                }
            }
        }
        if (start == -1) return 0;
        else return end - start + 1;
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(new MinimumRightShifts().minimumRightShifts(List.of(3, 4, 5, 1, 2)));
    }

}
