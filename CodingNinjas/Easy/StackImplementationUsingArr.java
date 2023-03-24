package CodingNinjas.Easy;

public class StackImplementationUsingArr {

    int[] arr;
    int top = -1;
    int n = -1;

    public StackImplementationUsingArr(int n) {
        arr = new int[n];
        this.n = n;
    }

    void push(int num) {
        if (top + 1 < n) {
            top += 1;
            arr[top] = num;
        }
    }

    int pop() {
        if (top == -1)
            return top;
        top--;
        return arr[top + 1];
    }

    int top() {
        if (top == -1)
            return -1;
        return arr[top];
    }

    int isEmpty() {
        if (top == -1)
            return 1;
        return 0;
    }

    int isFull() {
        if (top == n - 1)
            return 1;
        return 0;
    }

}
