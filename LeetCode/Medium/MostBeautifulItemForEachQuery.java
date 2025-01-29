package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MostBeautifulItemForEachQuery {

    public int findMax(List<int[]> items, int price) {
        int max = 0;
        int start = 0;
        int end = items.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (items.get(mid)[0] <= price) {
                max = Math.max(max, items.get(mid)[1]);
                start = mid + 1;
            } else end = mid - 1;
        }
        return max;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {

        List<int[]> sortedItems = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) return -1;
            if (a[0] > b[0]) return 1;
            return Integer.compare(a[1], b[1]);
        });
        pq.addAll(Arrays.asList(items));
        int prev = -1;
        int max = 0;
        while (!pq.isEmpty()) {
            int[] item = pq.poll();
            max = Math.max(max, item[1]);
            if (prev == -1 || sortedItems.get(prev)[0] < item[0]) {
                sortedItems.add(new int[]{item[0], max});
                prev++;
            } else {
                sortedItems.get(prev)[1] = max;
            }
        }
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            max = findMax(sortedItems, queries[i]);
            result[i] = max;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] items = new int[][]{{1, 2}, {1, 2}, {1, 3}, {1, 4}};
        int[][] items = new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
//        int[] queries = new int[]{1};
        int[] queries = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(new MostBeautifulItemForEachQuery().maximumBeauty(items, queries)));
    }

}
