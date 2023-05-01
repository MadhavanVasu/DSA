package LeetCode.Contest.Biweekly103;

import java.util.HashSet;
import java.util.Set;

public class FindThePrefixCommonArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int[] result = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) count++;
            else {
                if (s2.contains(A[i])) count++;
                if (s1.contains(B[i])) count++;
            }
            s1.add(A[i]);
            s2.add(B[i]);
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
