package LeetCode.Easy;

import java.util.LinkedList;

class MyStack {

    LinkedList<Integer> stack;

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {

        stack.addFirst(x);

    }

    public int pop() {
        return stack.poll();
    }

    public int top() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

public class ImplementStackusingQueue {
}
