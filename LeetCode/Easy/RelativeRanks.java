package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        List<int[]> scoreIndList = new ArrayList<>();
        for (int i = 0; i < n; i++) scoreIndList.add(new int[]{score[i], i});
        scoreIndList.sort((a, b) -> Integer.compare(b[0], a[0]));
        String[] result = new String[n];
        for (int i = 0; i < 3 && i < n; i++) {
            if (i == 0) result[scoreIndList.get(i)[1]] = "Gold Medal";
            if (i == 1) result[scoreIndList.get(i)[1]] = "Silver Medal";
            if (i == 2) result[scoreIndList.get(i)[1]] = "Bronze Medal";
        }
        for (int i = 3; i < n; i++) {
            result[i] = Integer.toString(scoreIndList.get(i)[1] + 1);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
