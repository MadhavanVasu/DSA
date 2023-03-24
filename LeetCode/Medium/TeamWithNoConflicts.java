package LeetCode.Medium;

// https://leetcode.com/problems/best-team-with-no-conflicts/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TeamWithNoConflicts {

    public static class Player {
        public int score;
        public int age;

        public Player() {

        }

        @Override
        public String toString() {
            return "Player{" +
                    "score=" + score +
                    ", age=" + age +
                    '}';
        }

        public Player(int score, int age) {
            this.score = score;
            this.age = age;
        }

    }

    public static int helperFn(int prev, int i, int[] dp, List<Player> players, int n) {
        if (i == n - 1) {
            if (prev == -1) {
                return players.get(i).score;
            }
            if (players.get(i).age >= players.get(prev).age && players.get(prev).score <= players.get(i).score) {
                return players.get(i).score;
            }
            return 0;
        }

        if (prev != -1 && dp[i] != -1)
            return dp[i];

        int a = -1;
        if (prev == -1 || (players.get(i).age >= players.get(prev).age && players.get(prev).score <= players.get(i).score)) {
            a = players.get(i).score + helperFn(i, i + 1, dp, players, n);
        }
        int b = helperFn(prev, i + 1, dp, players, n);

        int c = helperFn(-1, i+1, dp, players, n );

        dp[i] = Math.max(Math.max(a, b),c);
        System.out.println(Arrays.toString(dp));
        return dp[i];
    }

    public static int bestTeamScore(int[] scores, int[] ages) {

        int n = ages.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Player player = new Player(scores[i], ages[i]);
            players.add(player);
        }
        Collections.sort(players, (o1, o2) -> {
            if (o1.age < o2.age)
                return -1;
            else if (o1.age > o2.age)
                return 1;
            else if (o1.score < o2.score)
                return -1;
            else if (o1.score > o2.score)
                return 1;
            return 0;
        });
        return helperFn(-1, 0, dp, players, n);
    }

    public static void main(String[] args) {

        int[] scores = {1,2,3,5};
        int[] ages = {8,9,10,1};

        System.out.println(bestTeamScore(scores, ages));

    }

}
