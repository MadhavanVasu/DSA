package LeetCode.Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {

    class PQNode {
        int i;
        int j;
        double val;

        public PQNode(int i, int j, double val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<PQNode> pq = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double val = ((double) arr[i]) / arr[j];
                PQNode node = new PQNode(arr[i], arr[j], val);
                if (pq.size() < k) pq.add(node);
                else if (pq.peek().val < node.val) {
                    pq.poll();
                    pq.add(node);
                }
            }
        }
        return new int[]{pq.peek().i, pq.peek().j};
    }

}
