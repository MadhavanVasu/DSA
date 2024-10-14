package LeetCode.Medium;

import java.util.*;

public class MinimumCostToConvertToString1 {

    public long[][] computeShortestPathUsingFloydWarshall(int n, long[][] adjMatrix) {
        long[][] currMatrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(adjMatrix[i], 0, currMatrix[i], 0, n);
        }
        for (int i = 0; i < n; i++) {
            long[][] nextMatrix = new long[n][n];
            for (int j = 0; j < n; j++) {
                System.arraycopy(currMatrix[j], 0, nextMatrix[j], 0, n);
            }
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int z = 0; z < n; z++) {
                        if (currMatrix[y][x] != Long.MAX_VALUE && currMatrix[x][z] != Long.MAX_VALUE) {
                            long dist = currMatrix[y][x] + currMatrix[x][z];
                            nextMatrix[y][z] = Math.min(nextMatrix[y][z], dist);
                        }
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                System.arraycopy(nextMatrix[j], 0, currMatrix[j], 0, n);
            }
        }
        return currMatrix;
    }


    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] adjMatrix = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j)
                    adjMatrix[i][j] = Long.MAX_VALUE;
            }
        }
        for (int i = 0; i < original.length; i++) {
            if (adjMatrix[original[i] - 'a'][changed[i] - 'a'] > cost[i])
                adjMatrix[original[i] - 'a'][changed[i] - 'a'] = cost[i];
        }
        long[][] minDistance = computeShortestPathUsingFloydWarshall(26, adjMatrix);
        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                long dist = minDistance[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (dist == Long.MAX_VALUE) return -1;
                result += dist;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
