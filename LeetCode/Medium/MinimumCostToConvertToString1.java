package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCostToConvertToString1 {
    class Pair {
        char c;
        int distance;

        public Pair(char c, int distance) {
            this.c = c;
            this.distance = distance;
        }
    }

    public long dfs(char s, char d, Long[][] dp, Map<Character, List<Pair>> adjMap, int[] visited) {
        if (s == d) return 0;
        int i = s - 'a';
        int j = d - 'a';
        if (dp[i][j] != null) return dp[i][j];
        long ans = Long.MAX_VALUE;
        if (!adjMap.containsKey(s)) return ans;
        for (Pair adjacent : adjMap.get(s)) {
            int next = adjacent.c - 'a';
            int distance = adjacent.distance;
            if (visited[next] == 0) {
                visited[next] = 1;
                long currMin = dfs(adjacent.c, d, dp, adjMap, visited);
                if (currMin != Long.MAX_VALUE) {
                    currMin += distance;
                    if (currMin < ans) ans = currMin;
                }
                visited[next] = 0;
            }
        }
        dp[i][j] = ans;
        return ans;
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Long[][] dp = new Long[26][26];
        Map<Character, List<Pair>> adjMap = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            List<Pair> adj = adjMap.getOrDefault(original[i], new ArrayList<>());
            adj.add(new Pair(changed[i], cost[i]));
            adjMap.put(original[i], adj);
        }
        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            int[] visited = new int[26];
            long tempResult = dfs(source.charAt(i), target.charAt(i), dp, adjMap, visited);
            if (tempResult == Long.MAX_VALUE) return -1;
            result += tempResult;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
