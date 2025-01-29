package LeetCode.Contest.Weekly431;

import java.util.*;

public class FindMirrorScoreOfAString {

    // abcdefghijklmnopqrstuvwxyz

    public long calculateScore(String s) {
        List<Stack<Integer>> charIndexStack = new ArrayList<>();
        for (int i = 0; i < 26; i++) charIndexStack.add(new Stack<>());
        Map<Character, Character> mirrorMap = new HashMap<>();
        for (int i = 0; i < 13; i++) {
            char c1 = (char) ('a' + i);
            char c2 = (char) ('z' - i);
            mirrorMap.put(c1, c2);
            mirrorMap.put(c2, c1);
        }
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            char mirrorChar = mirrorMap.get(s.charAt(i));
            int ind = mirrorChar - 'a';
            if (!charIndexStack.get(ind).isEmpty()) {
                int j = charIndexStack.get(ind).pop();
                result += (i - j);
            } else {
                ind = s.charAt(i) - 'a';
                charIndexStack.get(ind).push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
