package LeetCode.Medium;

import java.util.Stack;

public class NextGreaterElement3 {

    public static int nextGreaterElement(int n) {

        Stack<Integer> stack = new Stack<>();
        int tempNum = n;
        while (tempNum > 0) {
            int r = tempNum % 10;
            if (stack.isEmpty() || stack.peek() <= r)
                stack.push(r);
            else {
                tempNum = tempNum / 10;
                int f = 0;
                Stack<Integer> tempStack = new Stack<>();
                while (!stack.isEmpty()) {
                    int ele = stack.pop();
                    if (ele > r && f == 0) {
                        tempStack.push(ele);
                    } else {
                        int temp = tempStack.pop();
                        tempNum = tempNum * 10 + temp;
                        tempStack.push(r);
                        tempStack.push(ele);
                        f = 1;
                    }
                }
                if (f == 0)
                    tempNum = tempNum * 10 + r;
                return tempNum;
            }
            tempNum = tempNum / 10;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12));
    }

}
