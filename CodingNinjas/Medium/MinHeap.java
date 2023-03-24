package CodingNinjas.Medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    public static class MinPQ {

        int[] heap;
        int capacity;
        int size;

        public MinPQ() {
            size = 0;
            capacity = 0;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
            heap = new int[capacity];
        }

        public void insert(int v) {
            heap[size++] = v;
            if (size != 1) {
                int curr = size - 1;
                int parent = (int) Math.ceil(curr / 2) - 1;
                while (parent != -1 && heap[parent] > heap[curr]) {
                    int temp = heap[parent];
                    heap[parent] = heap[curr];
                    heap[curr] = temp;
                    curr = parent;
                    parent = (int) Math.ceil(curr / 2) - 1;
                }
            }
        }

        public int removeMin() {
            if (size == 0)
                return -1;
            int ele = heap[0];
            if (size == 1) {
                size--;
            } else {
                heap[0] = heap[size - 1];
                size--;
                minHeapify(0);
            }
            return ele;
        }

        public void minHeapify(int i) {

            while (true) {
                if (i >= 0 && i <= (size / 2) - 1) {
                    int smallest = i;
                    if (2 * i < size && heap[2 * i] < heap[i])
                        smallest = 2 * i;
                    if (2 * i + 1 < size && heap[2 * i + 1] < heap[i])
                        smallest = 2 * i + 1;
                    if (smallest != i){
                        int temp = heap[i];
                        heap[i] = heap[smallest];
                        heap[smallest] = temp;
                        i = smallest;
                    }
                    else
                        break;
                } else
                    break;
            }
        }

        @Override
        public String toString() {
            return "MinPQ{" +
                    "heap=" + Arrays.toString(heap) +
                    '}';
        }
    }


    static int[] minHeap(int n, int[][] q) {

        MinPQ pq = new MinPQ();
        pq.setCapacity(n);
        List<Integer> res = new ArrayList<>();
        for (int[] x : q) {
            if (x[0] == 1) {
                res.add(pq.removeMin());
            } else {
                pq.insert(x[1]);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return result;

    }

}
