package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TaskScheduler {

    public class CharCount {
        char c;
        int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public String toString() {
            return c + " " + count;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] charFreq = new int[26];
        for (char c : tasks) charFreq[c - 65]++;
        int result = 0;
        PriorityQueue<CharCount> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.count, a.count));
        for (int i = 0; i < 26; i++) {
            if (charFreq[i] != 0)
                pq.add(new CharCount((char) ('A' + i), charFreq[i]));
        }
        while (!pq.isEmpty()) {
            int k = n;
            Set<CharCount> visited = new HashSet<>();
            while (k > 0 && !pq.isEmpty()) {
                CharCount cc = pq.poll();
                result++;
                k--;
                cc.count -= 1;
                visited.add(cc);
                k--;
            }
            result += k;
            for (CharCount cc : visited) if (cc.count > 0) pq.add(cc);
        }
        return result;
    }

    public int leastIntervalUsingSort(char[] tasks, int n) {
        int[] charFreq = new int[26];
        for (char c : tasks) charFreq[c - 65]++;
        int result = 0;
        while (true) {
            Arrays.sort(charFreq);
            int k = n + 1;
            int i = 25;
            while (k > 1) {
                if (charFreq[i] > 0) {
                    charFreq[i--] -= 1;
                    result++;
                    k--;
                } else break;
            }
            boolean flag = false;
            for (int x : charFreq)
                if (x > 0) {
                    flag = true;
                    break;
                }
            if (!flag) break;
            result += k;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
