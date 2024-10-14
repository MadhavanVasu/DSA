package LeetCode.Contest.Weekly416;

import java.util.PriorityQueue;

public class MinimumNumberOfSecondsToMakeMountainHeightZero {

    public class PQNode {
        long val;
        int time;

        int inc;

        public PQNode(long val, int time, int inc) {
            this.val = val;
            this.time = time;
            this.inc = inc;
        }
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        if (mountainHeight == 0) return 0;
        PriorityQueue<PQNode> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.val, b.val);
        });
        for (int x : workerTimes) pq.add(new PQNode(x, x, 2));
        long max = Long.MIN_VALUE;
        while (mountainHeight-- != 0) {
            PQNode node = pq.poll();
            long val = node.val;
            max = Math.max(max, val);
            node.val += ((long) node.time * node.inc);
            node.inc += 1;
            pq.add(node);
        }
        return max;
    }

    public static void main(String[] args) {

    }

    // 2 2 3 4
// 1 2
// 2 3 4 6
// 2 2
// 3 4 6 6
// 3 3
// 4 6 6 9
// 4 4
// 6 6 9 12
// 5 6
// 6 9 12 12
// 6 6
// 9 12 12 12
// 7 9
// 12 12 12 18
// 8 12
// 12 12 18 24
// 9 12
// 12 18 18 24
// 10 12


}
