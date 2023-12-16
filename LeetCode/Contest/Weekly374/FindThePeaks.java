package LeetCode.Contest.Weekly374;

import java.util.ArrayList;
import java.util.List;

public class FindThePeaks {

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
