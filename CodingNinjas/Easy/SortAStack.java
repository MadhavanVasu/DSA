package CodingNinjas.Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SortAStack {

    public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        int ele = stack.pop();
        sortStack(stack);
        if(stack.isEmpty()) stack.push(ele);
        else {
            Stack<Integer> temp = new Stack<>();
            do{
                if(!stack.isEmpty() && ele<stack.peek())
                    temp.push(stack.pop());
                else
                {
                    stack.push(ele);
                    while (!temp.isEmpty())
                        stack.push(temp.pop());
                }
            }while (!temp.isEmpty());
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hi");

    }

}
