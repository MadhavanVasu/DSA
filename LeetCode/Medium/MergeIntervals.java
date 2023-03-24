package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;
        int[][] result = new int[n][2];
        int pos = 0;
        int length = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= prev[0] && intervals[i][0] <= prev[1]) {
                if (intervals[i][1] > prev[1])
                    prev[1] = intervals[i][1];
            } else {
                result[pos] = prev;
                length++;
                pos++;
                prev = intervals[i];
            }
        }
        result[pos] = prev;
        length++;
        return Arrays.copyOfRange(result, 0, length);
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,0},{1,2}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
