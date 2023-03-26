package LeetCode.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestCycleInGraph {

    public static int longestCycle(int[] edges) {
        Set<Integer> visited = new HashSet<>();
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == -1 || visited.contains(i)) continue;
            visited.add(i);
            int j = i;
            int length = 0;
            Map<Integer, Integer> currTraversal = new HashMap<>();
            currTraversal.put(i, 0);
            while (true) {
                int v = edges[j];
                if (v != -1 && !currTraversal.containsKey(v) && !visited.contains(v)) {
                    length++;
                    visited.add(v);
                    currTraversal.put(v, length);
                    j = v;
                } else {
                    if (currTraversal.containsKey(v) && currTraversal.get(v) <= length)
                        max = Math.max(max, length + 1 - currTraversal.get(v));
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] edges = {3, 3, 4, 2, 3};
        System.out.println(longestCycle(edges));
    }

}
