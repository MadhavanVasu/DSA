package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class DetonateMaximumBombs {

    public static boolean isPointInCircle(double x, double y, double centerX, double centerY, double radius) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        return distance <= radius;
    }

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;
        Queue<Integer> queue = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            visited[i] = 1;
            queue.add(i);
            int count = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (j == v || visited[j] == 1) continue;
                    int x = bombs[j][0];
                    int y = bombs[j][1];
                    int currX = bombs[v][0];
                    int currY = bombs[v][1];
                    int r = bombs[v][2];

                    if (isPointInCircle(x, y, currX, currY, r)) {
                        visited[j] = 1;
                        queue.add(j);
                        count++;
                    }
                }
            }
            if (count > max) max = count;
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] bombs = {{2, 1, 3}, {6, 1, 4}};
        System.out.println(new DetonateMaximumBombs().maximumDetonation(bombs));

    }

}
