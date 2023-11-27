package LeetCode.Contest.Weekly364;

import java.util.List;

public class BeautifulTowers1 {

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long max = 0;
        long sum = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            sum = maxHeights.get(i);
            int prev = maxHeights.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (maxHeights.get(j) <= prev) {
                    sum += maxHeights.get(j);
                    prev = maxHeights.get(j);
                } else {
                    sum += prev;
                }
            }
            prev = maxHeights.get(i);
            for (int j = i + 1; j < maxHeights.size(); j++) {
                if (maxHeights.get(j) <= prev) {
                    sum += maxHeights.get(j);
                    prev = maxHeights.get(j);
                } else {
                    sum += prev;
                }
            }
            if (sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
