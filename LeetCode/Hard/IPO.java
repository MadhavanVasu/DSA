package LeetCode.Hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++)
            projects[i] = new int[]{capital[i], profits[i]};
        Arrays.sort(projects, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while (k-- != 0) {
            while (i < n && projects[i][0] <= w) heap.add(projects[i++][1]);
            if (heap.isEmpty()) break;
            w += heap.poll();
        }
        return w;

    }

    public static void main(String[] args) {

        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        System.out.println(findMaximizedCapital(2, 0, profits, capital));
    }

}
