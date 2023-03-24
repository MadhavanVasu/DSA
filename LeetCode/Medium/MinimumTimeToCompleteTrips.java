package LeetCode.Medium;

public class MinimumTimeToCompleteTrips {

    public static boolean isFeasible(long t, int[] time, int totalTrips, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += (t / time[i]);
            if (total >= totalTrips) return true;
        }
        return total >= totalTrips;
    }

    public static long minimumTime(int[] time, int totalTrips) {
        long left = Integer.MAX_VALUE;
        int n = time.length;
        for (int j : time) if (j < left) left = j;
        int max = 0;
        for (int j : time) if (j > max) max = j;
        long right = left * totalTrips;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isFeasible(mid, time, totalTrips, n)) {
                right = mid - 1;
            } else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {

        int[] time = {1935, 5727103};
        int totalTime = 6189436;
        System.out.println(minimumTime(time, totalTime));

    }

}
