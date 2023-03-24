package LeetCode.Easy;


// https://leetcode.com/problems/separate-the-digits-in-an-array/

import java.util.ArrayList;
import java.util.List;

public class SeparateDigitsInArr {

    public int[] separateDigits(int[] nums) {
        List<Integer> tempRes = new ArrayList<>();
        for (int x : nums) {
            String s = Integer.toString(x);
            for (char c : s.toCharArray())
                tempRes.add(Integer.parseInt(String.valueOf(c)));
        }
        return tempRes.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {

    }

}
