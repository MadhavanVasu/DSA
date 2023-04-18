package LeetCode.Medium;

import java.util.Stack;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        StringBuilder string = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length() + 1; i++) {
            if (i == path.length() || path.charAt(i) == '/') {
                String temp = string.toString();
                if (!temp.equals("")) {
                    if (temp.equals("..")) {
                        if (!stack.isEmpty()) stack.pop();
                    } else if (!temp.equals(".")) stack.push(temp);
                }
                string = new StringBuilder();
            } else
                string.append(path.charAt(i));
        }
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0 ? "/" : sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(simplifyPath("/..."));

    }

}
