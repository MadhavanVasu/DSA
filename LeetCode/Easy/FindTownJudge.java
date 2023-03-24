package LeetCode.Easy;

import java.util.stream.IntStream;

public class FindTownJudge {

    //Same logic with single array
    public static int simplifiedFindJudge(int n, int[][] trust) {
        int[] trusted = new int[n];

        for (int[] x : trust) {
            trusted[x[0] - 1]--;
            trusted[x[1] - 1]++;
        }
        return IntStream.range(0, n)
                .filter(i -> trusted[i] == n - 1)
                .findFirst()
                .orElse(-2) + 1;

    }

    public static int findJudge(int n, int[][] trust) {

        int[] outdegree = new int[n];

        int[] indegree = new int[n];

        for (int[] x : trust) {
            outdegree[x[0] - 1] = 1;
            indegree[x[1] - 1] += 1;
        }
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0 && indegree[i] == n - 1)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        System.out.println(findJudge(n, trust));
        System.out.println(simplifiedFindJudge(n, trust));
    }

}
