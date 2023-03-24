package LeetCode.Medium;

public class WordDictionary {
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

    public WordDictionary() {
        this.head = new Node();
    }

    public void addWord(String word) {
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

    public boolean helper(Node head, int i, String word) {
        if (i == word.length())
            return head.end==1;
        int pos = word.charAt(i) - 97;
        if (word.charAt(i) == '.') {
            for (int j = 0; j < 26; j++) {
                if (head.alpha[j] != null){
                    boolean a = helper(head.alpha[j], i + 1, word);
                    if (a)
                        return true;
                }
            }
        } else if (head.alpha[pos] != null) {
            return helper(head.alpha[pos], i + 1, word);
        }
        return false;
    }


    public boolean search(String word) {

        return helper(head, 0, word);

    }


}
