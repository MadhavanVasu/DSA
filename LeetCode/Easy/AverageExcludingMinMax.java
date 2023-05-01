package LeetCode.Easy;

import java.util.Arrays;

public class AverageExcludingMinMax {
    public double averageOnePass(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int x : salary) {
            if (x < min) min = x;
            if (x > max) max = x;
            sum += x;
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }

    public double average(int[] salary) {
        int min = Arrays.stream(salary).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(salary).max().orElse(Integer.MAX_VALUE);
        double sum = 0.0;
        for (int x : salary) {
            if (x != min && x != max) sum += x;
        }
        return Math.round((sum / (salary.length - 2)) * 100000.0) / 100000.0;
    }

    public static void main(String[] args) {

    }
}
