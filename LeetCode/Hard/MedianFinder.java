package LeetCode.Hard;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    public MedianFinder() {

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    }

    public void addNum(int num) {

        int size1 = maxHeap.size();
        int size2 = minHeap.size();

        if (size1 == 0 || num < maxHeap.peek()) {
            if (size1 == size2 || size2 - size1 == 1)
                maxHeap.add(num);
            else {
                int ele = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(ele);
            }
        } else {
            if (size1 == size2 || size1 - size2 == 1)
                minHeap.add(num);
            else {
                int ele = minHeap.poll();
                minHeap.add(num);
                maxHeap.add(ele);
            }
        }


    }

    public double findMedian() {
        System.out.println(maxHeap);
        System.out.println(minHeap);

        if (minHeap.size() == maxHeap.size())
            return ((double) minHeap.peek() + maxHeap.peek()) / 2;
        return maxHeap.peek();

    }
}

class Solution {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(12);
        medianFinder.addNum(10);
        medianFinder.addNum(13);
        medianFinder.addNum(11);
        medianFinder.addNum(5);
//        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
    }
}