package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                queue.add(i);
                visited[i] = 1;
                provinces++;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (isConnected[i][j] == 1 && visited[j] != 1) {
                            visited[j] = 1;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return provinces;
    }

    public static void main(String[] args) {

    }

}
