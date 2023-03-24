package LeetCode.Medium;

public class BrowserHistory {

    public class Node {
        String website;
        Node next;
        Node prev;

        public Node(String website) {
            this.website = website;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    public BrowserHistory(String homepage) {

        head = new Node(homepage);

    }

    public void visit(String url) {

        Node node = new Node(url);
        head.next = node;
        node.prev = head;
        head = head.next;
    }

    public String back(int steps) {
        while (steps != 0 && head.prev != null) {
            head = head.prev;
            steps--;
        }
        return head.website;
    }

    public String forward(int steps) {
        while (steps != 0 && head.next != null) {
            head = head.next;
            steps--;
        }
        return head.website;
    }

}
