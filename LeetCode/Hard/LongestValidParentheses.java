package LeetCode.Hard;

import java.util.Stack;

public class LongestValidParentheses {

    public static int helper(int i, int[] dp, Stack<Character> stack, String s, int n, int count)
    {
        if(i==n-1)
        {
            if(s.charAt(i)=='(' || stack.isEmpty())
                return 0;
            else
            {
                stack.pop();
                if(stack.isEmpty())
                    return count+2;
                else
                    return 0;
            }
        }
        if(dp[i]!=-1)
            return count + dp[i];
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        if(s.charAt(i)==')') {
            if(!stack.isEmpty()) {
                stack.pop();
                a = helper(i + 1, dp, stack, s, n, count + 2);
                d = helper(i+1,dp,new Stack<>(),s,n,count+2);
            }

        }
        else {
            stack.push(s.charAt(i));
            b = helper(i + 1, dp, stack, s, n, count);
            Stack<Character> newStack = new Stack<>();
            newStack.push(s.charAt(i));
            d = helper(i+1, dp, newStack, s, n, 0);
        }

        c = helper(i + 1, dp, new Stack<>(), s, n, 0);
        int max = Math.max(Math.max(Math.max(a,b),c),d);
        dp[i] = max;
        return dp[i];
    }

    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        for(int i=0; i<s.length(); i++) dp[i] = -1;
        return helper(0,dp,new Stack<>(),s,s.length(),0);

    }

    public static void main(String[] args) {
        String s = "(()())";
        System.out.println(longestValidParentheses(s));
    }

}
