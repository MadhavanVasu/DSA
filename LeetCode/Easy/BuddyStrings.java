package LeetCode.Easy;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {

        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char x : s.toCharArray()) {
                if (!set.add(x)) return true;
            }
            return false;
        } else {
            Character c1 = null;
            Character c2 = null;
            Character c3 = null;
            Character c4 = null;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (c1 == null) {
                        c1 = s.charAt(i);
                        c3 = goal.charAt(i);
                    } else if (c2 == null) {
                        c2 = s.charAt(i);
                        c4 = goal.charAt(i);
                    } else return false;
                }
            }
            return c1 != null && c1.equals(c4) && c2 != null && c2.equals(c3);
        }

    }

    public static void main(String[] args) {

    }

}
