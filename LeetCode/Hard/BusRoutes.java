package LeetCode.Hard;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        Map<Integer, List<Integer>> busStopMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (!busStopMap.containsKey(routes[i][j])) {
                    busStopMap.put(routes[i][j], new ArrayList<>());
                }
                busStopMap.get(routes[i][j]).add(i);
                if (max < routes[i][j]) max = routes[i][j];
            }
        }
        int[] stopVisited = new int[max + 1];
        int[] busVisited = new int[routes.length + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int x : busStopMap.get(source)) {
            queue.add(x);
            busVisited[x] = 1;
        }
        stopVisited[source] = 1;
        int busCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            busCount++;
            while (size-- != 0) {
                int bus = queue.poll();
                for (int x : routes[bus]) {
                    if (stopVisited[x] != 1) {
                        stopVisited[x] = 1;
                        if (x == target) return busCount;
                        for (int y : busStopMap.get(x)) {
                            if (busVisited[y] != 1) {
                                queue.add(y);
                                busVisited[y] = 1;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
