package LeetCode.Contest.Weekly362;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PointsThatIntersectCar {

    public int numberOfPoints(List<List<Integer>> nums) {

        Comparator<List<Integer>> customComp = (a, b) -> {
            if (a.get(0) < b.get(0))
                return -1;
            else if (a.get(0) > b.get(0))
                return 1;
            else return a.get(1).compareTo(b.get(1));
        };

        nums.sort(customComp);

        int result = 0;
        int start = nums.get(0).get(0);
        int end = nums.get(0).get(1);
        for (List<Integer> num : nums) {
            if (num.get(0) >= start && num.get(0) <= end) {
                if (end < num.get(1))
                    end = num.get(1);
            } else {
                result += (end - start) + 1;
                start = num.get(0);
                end = num.get(1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
