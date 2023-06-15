package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        int start = 0;
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                String range = "" + nums[start] + "";
                if (i - start != 1)
                    range += "->" + nums[i - 1] + "";
                result.add(range);
                start = i;
            }
        }
        String range = "" + nums[start] + "";
        if (nums.length - start != 1)
            range += "->" + nums[nums.length - 1] + "";
        result.add(range);
        return result;
    }

    public static void main(String[] args) {

    }

}

