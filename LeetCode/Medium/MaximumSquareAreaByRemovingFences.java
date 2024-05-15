package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSquareAreaByRemovingFences {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> availWidth = new HashSet<>();
        int MOD = 1_000_000_007;
        int[] verticalFences = new int[vFences.length + 2];
        int[] horizontalFences = new int[hFences.length + 2];
        int i;
        for (i = 0; i < vFences.length; i++) verticalFences[i] = vFences[i];
        verticalFences[i] = 1;
        verticalFences[i + 1] = n;
        for (i = 0; i < hFences.length; i++) horizontalFences[i] = hFences[i];
        horizontalFences[i] = 1;
        horizontalFences[i + 1] = m;
        Arrays.sort(verticalFences);
        for (i = 0; i < verticalFences.length - 1; i++) {
            for (int j = i + 1; j < verticalFences.length; j++)
                availWidth.add(Math.abs(verticalFences[i] - verticalFences[j]) % MOD);
        }
        int maxResult = -1;
        Arrays.sort(horizontalFences);
        for (i = 0; i < horizontalFences.length - 1; i++) {
            for (int j = i + 1; j < horizontalFences.length; j++) {
                int length = Math.abs(horizontalFences[j] - horizontalFences[i]) % MOD;
                if (availWidth.contains(length) && length > maxResult) {
                    maxResult = length;
                }
            }
        }
        if (maxResult == -1) return -1;
        return (int) (((long) maxResult * maxResult) % MOD);
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[] hFences = {2, 3};
        int[] vFences = {2};
        System.out.println(new MaximumSquareAreaByRemovingFences().maximizeSquareArea(m, n, hFences, vFences));

    }

}
