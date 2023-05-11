package LeetCode.Easy;

import java.util.*;
import java.util.stream.Collectors;

public class DifferenceOfTwoArray {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> unique = new HashSet<>(s1);
        unique.removeAll(s2);
        result.add(new ArrayList<>(unique));
        unique = new HashSet<>(s2);
        unique.removeAll(s1);
        result.add(new ArrayList<>(unique));
        return result;
    }


    public static void main(String[] args) {

    }

}
