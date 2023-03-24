package LeetCode.Medium;

public class Trie {

    public class Node {
        Node[] alpha;
        int end;
        public Node() {
            alpha = new Node[26];
            for (int i = 0; i < 26; i++)
                alpha[i] = null;
            end = 0;
        }
    }

    Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node temp = head;
        for (char x : word.toCharArray()) {
            int pos = x - 97;
            if (temp.alpha[pos] == null) {
                temp.alpha[pos] = new Node();
            }
            temp = temp.alpha[pos];
        }
        temp.end = 1;
    }

    public boolean search(String word) {
        Node temp = head;
        for (char x : word.toCharArray()) {
            int pos = x - 97;
            if (temp.alpha[pos] == null) {
                return false;
            }
            temp = temp.alpha[pos];
        }
        return temp.end == 1;
    }

    public boolean startsWith(String prefix) {
        Node temp = head;
        for (char x : prefix.toCharArray()) {
            int pos = x - 97;
            if (temp.alpha[pos] == null) {
                return false;
            }
            temp = temp.alpha[pos];
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
