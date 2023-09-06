package LeetCode.Medium;

import LeetCode.Model.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        Node result = map.get(temp);
        Node curr = result;
        while (temp != null) {
            curr.next = temp.next == null ? null : map.get(temp.next);
            curr.random = temp.random == null ? null : map.get(temp.random);
            curr = curr.next;
            temp = temp.next;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
