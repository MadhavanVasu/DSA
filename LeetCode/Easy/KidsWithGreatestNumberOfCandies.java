package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int x : candies) max = Math.max(x, max);
//        int max = Arrays.stream(candies).max().orElse(0);
        List<Boolean> result = new ArrayList<>();
        for (int x : candies)
            result.add(x + extraCandies >= max);
        return result;
    }

    public static void main(String[] args) {

    }

}
