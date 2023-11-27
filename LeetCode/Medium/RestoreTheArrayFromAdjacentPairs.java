package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacentElements = new HashMap<>();
        for (int[] x : adjacentPairs) {
            if (!adjacentElements.containsKey(x[0]))
                adjacentElements.put(x[0], new ArrayList<>());
            adjacentElements.get(x[0]).add(x[1]);
            if (!adjacentElements.containsKey(x[1]))
                adjacentElements.put(x[1], new ArrayList<>());
            adjacentElements.get(x[1]).add(x[0]);
        }
        int[] result = new int[adjacentPairs.length + 1];
        int start = -1;
        for (Integer x : adjacentElements.keySet()) {
            if (adjacentElements.get(x).size() == 1) {
                start = x;
                break;
            }
        }
        int i = 0;
        int next = adjacentElements.get(start).get(0);
        result[i++] = start;
        while (i != adjacentPairs.length + 1) {
            List<Integer> ele = adjacentElements.get(next);
            result[i++] = next;
            if (i == adjacentPairs.length + 1) break;
            if (ele.get(0) != result[i - 1]) {
                next = ele.get(0);
            } else {
                next = ele.get(1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
