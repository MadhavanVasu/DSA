package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfString {

    public int partitionString(String s) {

        Set<Character> set = new HashSet<>();
        int result = 0;
        for (Character c : s.toCharArray()) {
            boolean isPresent = set.add(c);
            if (!isPresent) {
                result += 1;
                set = new HashSet<>();
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {

    }

}
