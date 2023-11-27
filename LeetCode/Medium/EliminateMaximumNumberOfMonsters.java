package LeetCode.Medium;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] timeTakenByMonsters = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] < speed[i]) timeTakenByMonsters[i] = 0;
            else
                timeTakenByMonsters[i] = (int) Math.ceil(((double) dist[i] / speed[i]));
        }
        int timeTaken = 1;
        int result = 1;
        Arrays.sort(timeTakenByMonsters);
        for (int i = 1; i < dist.length; i++) {
            if (timeTaken >= timeTakenByMonsters[i]) break;
            timeTaken += 1;
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
