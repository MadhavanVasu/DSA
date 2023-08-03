package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // Doubly Linked List
    public class Node {

        int key;
        int val;
        Node next;
        Node prev;

        public Node() {
            key = 0;
            val = 0;
            prev = null;
            next = null;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    int currSize;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
        this.currSize = 0;

    }

    public int get(int key) {

        if (map.containsKey(key)) {
            Node curr = map.get(key);
            Node prev = curr.prev;
            Node next = curr.next;
            next.prev = prev;
            if (prev != null) prev.next = next;
            else head = next;
            tail.next = curr;
            curr.prev = tail;
            curr.next = null;
            return map.get(key).val;
        } else return -1;

    }

    public void put(int key, int value) {

        Node curr = new Node(key, value);

        if (head == null) {
            map.put(key, curr);
            head = curr;
            tail = curr;
            currSize++;
        } else if (map.containsKey(key)) {

            Node node = map.get(key);
            node.val = value;
            Node prev = node.prev;
            Node next = node.next;
            next.prev = prev;
            if (prev != null) prev.next = next;
            else head = next;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = tail.next;
        } else {
            if (currSize == capacity) {
                if (head.next != null) {
                    Node remove = head;
                    head = head.next;
                    map.remove(remove.key);
                    head.prev = null;
                    tail.next = curr;
                    curr.prev = tail;
                    tail = tail.next;
                } else {
                    map.remove(head.key);
                    head = curr;
                    tail = curr;
                }
            } else {
                tail.next = curr;
                curr.prev = tail;
                tail = tail.next;
                currSize++;
            }
            map.put(key, curr);
        }

    }
}