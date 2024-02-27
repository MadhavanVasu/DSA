package LeetCode.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));
        Stack<Integer> operandsStack = new Stack<>();
        for (String x : tokens) {
            if (!operators.contains(x)) operandsStack.push(Integer.parseInt(x));
            else {
                int b = operandsStack.pop();
                int a = operandsStack.pop();
                switch (x) {
                    case "+":
                        operandsStack.push(a + b);
                        break;
                    case "-":
                        operandsStack.push(a - b);
                        break;
                    case "*":
                        operandsStack.push(a * b);
                        break;
                    case "/":
                        operandsStack.push(a / b);
                        break;
                }
            }
        }
        return operandsStack.pop();
    }

    public static void main(String[] args) {


    }

}
