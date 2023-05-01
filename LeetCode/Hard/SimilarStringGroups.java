package LeetCode.Hard;

import java.util.*;

public class SimilarStringGroups {
    public void findAdjacency(String[] strs, List<List<Integer>> adjList) {
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < i; j++) {
                Character a1 = null;
                Character a2 = null;
                Character b1 = null;
                Character b2 = null;
                int count = 0;
                for (int k = 0; k < strs[i].length(); k++) {
                    if (count > 2) break;
                    if (strs[i].charAt(k) != strs[j].charAt(k)) {
                        if (a1 == null) {
                            a1 = strs[i].charAt(k);
                            b1 = strs[j].charAt(k);
                        } else if (a2 == null) {
                            a2 = strs[i].charAt(k);
                            b2 = strs[j].charAt(k);
                        }
                        count++;
                    }
                }
                if ((count == 0 || count == 2) && Objects.equals(a1, b2) && Objects.equals(a2, b1)) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
    }

    public int numSimilarGroups(String[] strs) {
        if (strs.length == 0) return 0;
        int n = strs.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        findAdjacency(strs, adjList);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                groups++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int x : adjList.get(v)) {
                        if (visited[x] != 1) {
                            visited[x] = 1;
                            queue.add(x);
                        }
                    }
                }
            }
        }
        return groups;
    }

    public static void main(String[] args) {
        String[] strs = {"tars", "rats", "arts", "star"};
        System.out.println(new SimilarStringGroups().numSimilarGroups(strs));
    }

}
