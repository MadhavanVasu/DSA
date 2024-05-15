package LeetCode.Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloon {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int start = -1;
        int end = -1;
        int result = 0;
        for (int[] point : points) {
            if (start == -1 && end == -1) {
                start = point[0];
                end = point[1];
            }
            else if ((point[0] == start || start <= point[0] && point[0] <= end) && point[1] > end) end = point[1];
            else {
                result++;
                start = point[0];
                end = point[1];
            }
        }
        result++;
        return result;
    }

    public static void main(String[] args) {

    }

}
