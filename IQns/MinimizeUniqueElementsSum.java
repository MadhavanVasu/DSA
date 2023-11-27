package IQns;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimizeUniqueElementsSum {

    public int minimizeSum(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums) maxHeap.add(x);
        while (k > 0) {
            if (maxHeap.peek() == 1) break;
            int maxElement = maxHeap.poll();
            int a = maxElement / 2;
            int b = maxElement - a;
            maxHeap.add(a);
            maxHeap.add(b);
            k--;
        }
        Set<Integer> uniqueElements = new HashSet<>();
        int sum = 0;
        while (!maxHeap.isEmpty()) {
            int ele = maxHeap.poll();
            if (!uniqueElements.contains(ele)) {
                uniqueElements.add(ele);
                sum += ele;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(new MinimizeUniqueElementsSum().minimizeSum(new int[]{1, 1, 2, 50, 10}, 3));

    }

}
