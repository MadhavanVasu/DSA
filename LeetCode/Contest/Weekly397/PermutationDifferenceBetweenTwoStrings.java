package LeetCode.Contest.Weekly397;

import java.util.HashMap;
import java.util.Map;

public class PermutationDifferenceBetweenTwoStrings {

    public int findPermutationDifference(String s, String t) {
        int[] charArr = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) charArr[s.charAt(i) - 'a'] = i;
        for (int i = 0; i < t.length(); i++) result += Math.abs(i - charArr[t.charAt(i) - 'a']);
        return result;
    }


    public static void main(String[] args) {

    }

}
