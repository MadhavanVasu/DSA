package LeetCode.Easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsRichestPile {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : gifts)
            pq.add(x);

        for (int i = 0; i < k; i++) {
            int ele = pq.poll();
            int sqrt = (int) Math.floor(Math.sqrt(ele));
            pq.add(sqrt);
        }
        int res = 0;
        while (!pq.isEmpty())
            res += pq.poll();
        return res;
    }

    public static void main(String[] args) {

    }

}
