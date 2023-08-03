package LeetCode.Contest.Weekly355;

import java.util.ArrayList;
import java.util.List;

public class LargestElementAfterMerge {

    public long maxArrayValue(int[] nums) {

//        List<Integer> sumArray = new ArrayList<>(List.of());
//        int max = 0;
//        for (int x : nums)
//            sumArray.add(x);
//        while (true) {
//            List<Integer> temp = new ArrayList<>();
//            int sum = 0;
//            for (int i = 0; i < sumArray.size(); i++) {
//                if (i == 0 || sumArray.get(i - 1) <= sumArray.get(i))
//                    sum += sumArray.get(i);
//                else {
//                    temp.add(sum);
//                    sum = sumArray.get(i);
//                }
//            }
//            temp.add(sum);
//            for (int x : sumArray) {
//                if (x > max) max = x;
//            }
//            if (sumArray.equals(temp)) return max;
//            else
//                sumArray = temp;
//        }

        int max = 0;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || nums[i] <= sum)
                sum += nums[i];
            else {
                if (max < sum) max = sum;
                sum = nums[i];
            }
        }
        if (max < sum) max = sum;
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 3};
        System.out.println(new LargestElementAfterMerge().maxArrayValue(nums));
    }

}
