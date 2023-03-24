package CodingNinjas.Easy;

public class Queue {

    public class Node {
        Integer data;
        Node next;

        public Node() {
            this.data = null;
            this.next = null;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;


    Queue() {
        head = null;
        tail = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        if(head==null)
            return true;
        return false;
    }

    void enqueue(int data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        }
        else {
            Node temp = head;
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    int dequeue() {
        if(head==null)
            return -1;
        int data = head.data;
        head = head.next;
        if(head==null)
            tail = null;
        return data;
    }

    int front() {
        if(head==null)
            return -1;
        return head.data;
    }

}
