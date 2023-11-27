package LeetCode.Easy;

import java.util.*;

public class SortIntegersByNumberOf1Bits {

    public int findNumberOfBits(int n) {
        if (n == 0 || n == 1) return n;
        int power = (int) (Math.log(n) / Math.log(2));
        int diff = n - (int) Math.pow(2, power);
        return 1 + findNumberOfBits(diff);
    }

    public int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Arrays.sort(arr);
        for (int x : arr) {
            int bits = findNumberOfBits(x);
            List<Integer> list = map.getOrDefault(bits, new ArrayList<>());
            list.add(x);
            map.put(bits, list);
        }
        int[] result = new int[arr.length];
        int i = 0;
        for (Integer bits : map.keySet()) {
            for (Integer x : map.get(bits))
                result[i++] = x;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new SortIntegersByNumberOf1Bits().sortByBits(new int[]{6, 7, 8, 1, 2, 3, 0, 5, 4})));

    }

}
