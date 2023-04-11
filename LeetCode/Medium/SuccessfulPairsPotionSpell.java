package LeetCode.Medium;

import java.util.Arrays;

public class SuccessfulPairsPotionSpell {

    public int binarySearch(int spell, int[] potions, long success, int m) {
        int start = 0;
        int end = m - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long) spell * potions[mid] >= success)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = binarySearch(spells[i], potions, success, m);
            result[i] = m - pos;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] spells = {9, 39};
        int[] potions = {35, 40, 22, 37, 29, 22};
        long success = 329;
        System.out.println(Arrays.toString(new SuccessfulPairsPotionSpell().successfulPairs(spells, potions, success)));
    }

}
