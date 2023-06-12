package LeetCode.Contest.Weekly348;

import java.util.HashSet;
import java.util.Set;

public class MinimizeStringLength {

    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (Character x : s.toCharArray()) {
            if (set.add(x))
                result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
