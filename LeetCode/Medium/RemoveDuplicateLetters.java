package LeetCode.Medium;

import java.util.*;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (Character x : s.toCharArray())
            map.put(x, map.getOrDefault(x, 0) + 1);
        for (Character x : s.toCharArray()) {
            if (!set.contains(x)) {
                if (!stack.isEmpty() && stack.peek() > x) {
                    while (!stack.isEmpty()) {
                        if (stack.peek() < x || map.get(stack.peek()) == 0) break;
                        set.remove(stack.pop());
                    }
                }
                stack.push(x);
                set.add(x);
                map.put(x, map.get(x) - 1);
            } else map.put(x, map.get(x) - 1);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
