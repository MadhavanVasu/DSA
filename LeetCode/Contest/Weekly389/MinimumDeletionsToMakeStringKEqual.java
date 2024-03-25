package LeetCode.Contest.Weekly389;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MinimumDeletionsToMakeStringKEqual {
    public boolean isFeasible(int moves, int[] charFreq, int k) {
        int ops = 0;
        while (true) {
            int i = 0;
            int j = 25;
            Arrays.sort(charFreq);
            while (charFreq[i] == 0) i++;
            if (i < j) {
                int diff = Math.abs(charFreq[i] - charFreq[j]);
                if (diff <= k) return true;
                int rem = diff - k;
                if (rem >= charFreq[i]) {
                    ops += charFreq[i];
                    charFreq[i] = 0;
                } else {
                    ops += rem;
                    charFreq[j] -= rem;
                }
                if (ops > moves) return false;
            }
        }
    }


    public int minimumDeletions(String word, int k) {
        int[] charFreq = new int[26];
        for (char c : word.toCharArray()) charFreq[c - 'a']++;
        Arrays.sort(charFreq);
        int min = word.length();
        int start = 0;
        int end = word.length();
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(mid, charFreq.clone(), k)) {
                if (mid < min) min = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return min;
    }

    public static void main(String[] args) {

    }

}
