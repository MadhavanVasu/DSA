package CodingNinjas.Easy;

import java.util.*;

public class KMaxSumCombination {
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        Collections.sort(a);
        Collections.sort(b);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = b.size() - 1; i >= 0; i--) {
            for (int j = a.size() - 1; j >= 0; j--) {
                if (pq.size() < k)
                    pq.add(b.get(i) + a.get(j));
                else if (pq.peek() < b.get(i) + a.get(j)) {
                    pq.poll();
                    pq.add(b.get(i) + a.get(j));
                } else
                    break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>(pq);
        Collections.sort(result);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>(List.of(9, 15, 20, 20, 11, 0, 18, 7));
        ArrayList<Integer> b = new ArrayList<>(List.of(16, 5, 3, 16, 13, 17, 7, 7));
        System.out.println(kMaxSumCombination(a, b, 8, 8));

    }

}
