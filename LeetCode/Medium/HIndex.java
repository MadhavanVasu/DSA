package LeetCode.Medium;

import java.util.Arrays;

public class HIndex {

    public int hIndexUsingSorting(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int citationCount = citations[i];
            int rem = n - i;
            if (rem >= citationCount) result = citationCount;
        }
        return result;
    }

    public boolean isFeasible(int[] citations, int k) {
        int paperCount = 0;
        for (int citation : citations) {
            if (citation >= k) paperCount++;
        }
        return paperCount >= k;
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int start = 0;
        int end = n;
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(citations, mid)) {
                if (mid > result) result = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
