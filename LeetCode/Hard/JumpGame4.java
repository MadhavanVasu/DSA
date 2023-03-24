package LeetCode.Hard;

import java.util.*;

public class JumpGame4 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1 || n == 2)
            return n - 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(arr[i]))
                map.get(arr[i]).add(i);
            else
                map.put(arr[i], new ArrayList<>(List.of(i)));
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- != 0) {
                int ele = queue.poll();
                if (ele == n - 1)
                    return level;
                if (ele - 1 != -1 && !visited[ele - 1] && arr[ele] != arr[ele - 1]) {
                    queue.add(ele - 1);
                    visited[ele - 1] = true;
                }
                if (ele + 1 != n && !visited[ele + 1] && arr[ele] != arr[ele + 1]) {
                    queue.add(ele + 1);
                    visited[ele + 1] = true;
                }
                if (map.containsKey(arr[ele])) {
                    for (int x : map.get(arr[ele])) {
                        if (x != ele) {
                            queue.add(x);
                            visited[x] = true;
                        }
                    }
                    map.remove(arr[ele]);
                }
            }
            level++;
        }
        return -1;
    }

}
