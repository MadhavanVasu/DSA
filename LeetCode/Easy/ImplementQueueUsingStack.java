package LeetCode.Easy;

import java.util.Stack;

public class ImplementQueueUsingStack {

    class MyQueue {

        Stack<Integer> pushStack;
        Stack<Integer> popStack;

        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }
        public void push(int x) {
            pushStack.push(x);
        }

        public int pop() {
            peek();
            return popStack.pop();
        }

        public int peek() {
            if (!popStack.isEmpty())
                return popStack.peek();

            while (!pushStack.isEmpty())
                popStack.push(pushStack.pop());
            return popStack.peek();
        }

        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }

}
