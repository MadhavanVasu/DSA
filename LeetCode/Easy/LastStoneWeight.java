package LeetCode.Easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones) pq.add(x);
        while (pq.size() > 1) {
            pq.add(pq.poll() - pq.poll());
        }
        return pq.poll();
    }

    public static void main(String[] args) {

    }
}
