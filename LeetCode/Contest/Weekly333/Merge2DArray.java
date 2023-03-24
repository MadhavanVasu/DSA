package LeetCode.Contest.Weekly333;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge2DArray {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int ptr1 = 0;
        int ptr2 = 0;
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        while (ptr1 < n || ptr2 < m) {
            int id1 = -1;
            int id2 = -1;
            if (ptr1 < n)
                id1 = nums1[ptr1][0];
            if (ptr2 < m)
                id2 = nums2[ptr2][0];
            if ((id1 != -1 && id2 != -1) && (id1 == id2)) {
                result.add(new ArrayList<>(List.of(id1, nums1[ptr1][1] + nums2[ptr2][1])));
                ptr1++;
                ptr2++;
            } else if ((id1 == -1 || id1 > id2) && ptr2<m) {
                result.add(new ArrayList<>(List.of(id2, nums2[ptr2][1])));
                ptr2++;
            } else if(ptr1<n) {
                result.add(new ArrayList<>(List.of(id1, nums1[ptr1][1])));
                ptr1++;
            }
        }
        int[][] res = new int[result.size()][2];
        int i = 0;
        for (List<Integer> x : result)
            res[i++] = new int[]{x.get(0), x.get(1)};
        return res;
    }

    public static void main(String[] args) {
//        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
//        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] nums1 = {{2,4},{3,6},{5,5}};
//        int[][] nums2 = {{1,3},{4,3}};
        int[][] nums1 = {{1,2}};
        int[][] nums2 = {{1,3}};
        System.out.println(Arrays.deepToString(mergeArrays(nums1, nums2)));

    }

}
